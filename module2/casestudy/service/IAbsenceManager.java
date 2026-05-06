package casestudy.service;

import casestudy.entity.Absence;

import java.util.List;

public interface IAbsenceManager {
    List<Absence> getByEmployee(int employeeId);
    int countAbsent();
}
