package casestudy.entity;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Payroll {
    private Integer id;
    private Employee employee;
    private BigDecimal  baseSalary;
    private BigDecimal  bonus;
    private YearMonth period;

    private BigDecimal grossSalary;
    private BigDecimal  netSalary;


}
