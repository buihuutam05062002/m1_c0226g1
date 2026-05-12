package casestudy2.entity;

import java.time.LocalDate;
import java.util.List;

public class Absence {
    private Integer id;
    private Integer employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;

    public Absence(int id, int employeeId, LocalDate startDate, LocalDate endDate, String reason) {
        this.id = id;
        this.employeeId = employeeId;
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


    @Override
    public String toString() {
        return String.format(
                "| %-3d | %-10d | %-12s | %-12s | %-25s |",
                id,
                employeeId,
                startDate,
                endDate,
                reason
        );
    }
}
