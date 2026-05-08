package casestudy.service;

import casestudy.entity.Absence;

import java.util.List;

public interface IAbsenceManager extends IManager<Absence> {
    List<Absence> getByEmployee(int employeeId);
    int countAbsent(int employeeId);
}
