package casestudy.controller;

import casestudy.entity.Absence;
import casestudy.entity.Employee;
import casestudy.service.IAbsenceManager;
import casestudy.service.impl.AbsenceService;

import java.util.List;

public class AbsenceController {
    private IAbsenceManager iAbsenceManager =  new AbsenceService();

    
    public List<Absence> getByEmployee(int employeeId) {
        return iAbsenceManager.getAll();
    }

    
    public int countAbsent(int employeeId) {
        return iAbsenceManager.countAbsent(employeeId);
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
