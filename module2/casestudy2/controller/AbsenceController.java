package casestudy2.controller;

import casestudy2.entity.Absence;
import casestudy2.service.IAbsenceService;
import casestudy2.service.impl.AbsenceService;

import java.time.YearMonth;
import java.util.List;

public class AbsenceController {
    private IAbsenceService iAbsenceManager = new AbsenceService();


    public List<Absence> getByEmployee(int employeeId) {
        return iAbsenceManager.getByEmployee(employeeId);
    }


    public int countAbsent(int employeeId, YearMonth period) {
        return iAbsenceManager.countAbsent(employeeId, period);
    }


    public void add(Absence entity) {
        iAbsenceManager.add(entity);
    }


    public boolean update(Absence entity) {
        return iAbsenceManager.update(entity);
    }


    public void delete(int id) {
        iAbsenceManager.delete(id);
    }


    public Absence getById(int id) {
        return iAbsenceManager.getById(id);
    }


    public List<Absence> getAll() {
        return iAbsenceManager.getAll();
    }
}
