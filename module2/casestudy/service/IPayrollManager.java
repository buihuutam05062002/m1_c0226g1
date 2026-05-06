package casestudy.service;

import java.math.BigDecimal;

public interface IPayrollManager {
    BigDecimal calculatePayroll();
    BigDecimal calGrossSalary();
    BigDecimal calNetSalary();
}
