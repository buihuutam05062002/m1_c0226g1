package casestudy2.service;

import casestudy2.entity.Payroll;
import casestudy2.service.IService;

import java.math.BigDecimal;
import java.util.List;

public interface IPayrollService extends IService<Payroll> {
    BigDecimal calNetSalary(int countOfAbsence, BigDecimal  baseSalary, BigDecimal grossSalary);

    List<Payroll> getByEmployee(int id);
}
