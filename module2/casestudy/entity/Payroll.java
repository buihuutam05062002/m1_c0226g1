package casestudy.entity;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Payroll {
    private Integer id;
    private int employeeId;
    private BigDecimal  baseSalary;
    private BigDecimal  bonus;
    private YearMonth period;

    private BigDecimal grossSalary;
    private BigDecimal  netSalary;


    public Payroll(Integer id, int employeeId, BigDecimal baseSalary, BigDecimal bonus, YearMonth period, BigDecimal grossSalary, BigDecimal netSalary) {
        this.id = id;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.period = period;
        this.grossSalary = grossSalary;
        this.netSalary = netSalary;
    }

    public Payroll() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public YearMonth getPeriod() {
        return period;
    }

    public void setPeriod(YearMonth period) {
        this.period = period;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
    }

    public BigDecimal getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }
}
