package casestudy.entity;

import java.time.LocalDate;
import java.util.List;

public class Absence {
    private int id;
    private int employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;


    public Absence(int employee, LocalDate endDate, int id, String reason, LocalDate startDate) {
        this.id = id;
        this.employeeId = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    public Absence() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
