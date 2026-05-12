package casestudy2.service;

import casestudy2.entity.Absence;
import casestudy2.service.IService;

import java.time.YearMonth;
import java.util.List;

public interface IAbsenceService extends IService<Absence> {
    List<Absence> getByEmployee(int employeeId);
    int countAbsent(int employeeId, YearMonth period);
}
