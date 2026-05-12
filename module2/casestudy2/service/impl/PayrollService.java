package casestudy2.service.impl;

import casestudy2.entity.Payroll;
import casestudy2.repository.AbsenceRepository;
import casestudy2.repository.EmployeeRepository;
import casestudy2.repository.PayrollRepository;
import casestudy2.service.IPayrollService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PayrollService implements IPayrollService {
    private PayrollRepository payrollRepository = PayrollRepository.getInstance();
    private AbsenceRepository absenceRepository = AbsenceRepository.getInstance();
    private EmployeeRepository employeeRepository = EmployeeRepository.getInstance();


    @Override
    public boolean update(Payroll entity) {
        calculateSalary(entity);
        return payrollRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        payrollRepository.delete(id);
    }

    @Override
    public Payroll getById(int id) {
        return payrollRepository.getById(id);
    }

    @Override
    public List<Payroll> getAll() {
        return payrollRepository.getAll();
    }
    @Override
    public List<Payroll> getByEmployee(int id){
        return payrollRepository.getByEmployee(id);
    }


    @Override
    public BigDecimal calNetSalary(int countOfAdsence, BigDecimal baseSalary, BigDecimal grossSalary) {
        int workingDays = 26;
        BigDecimal deduction = baseSalary.divide(BigDecimal.valueOf(workingDays), 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(countOfAdsence));
        return grossSalary.subtract(deduction);
    }

    @Override
    public boolean add(Payroll entity) {
        if (employeeRepository.getById(entity.getEmployeeId()) == null) {
            return false;
        }
        calculateSalary(entity);
        return payrollRepository.add(entity);
    }


    private void calculateSalary(Payroll entity) {
        entity.setGrossSalary(entity.getBaseSalary().add(entity.getBonus()));
        entity.setNetSalary(calNetSalary(absenceRepository.countAbsent(entity.getEmployeeId(), entity.getPeriod()), entity.getBaseSalary(), entity.getGrossSalary()));
    }
}
