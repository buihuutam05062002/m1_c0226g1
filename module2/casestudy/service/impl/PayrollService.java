package casestudy.service.impl;

import casestudy.entity.Payroll;
import casestudy.repository.PayrollRepository;
import casestudy.service.IPayrollManager;

import java.util.List;

public class PayrollService implements IPayrollManager {
    private PayrollRepository payrollRepository = new PayrollRepository();
    @Override
    public void add(Payroll entity) {
        payrollRepository.add(entity);
    }

    @Override
    public boolean update(Payroll entity) {
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
}
