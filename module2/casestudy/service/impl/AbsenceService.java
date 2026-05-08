package casestudy.service.impl;

import casestudy.entity.Absence;
import casestudy.entity.Employee;
import casestudy.repository.AbsenceRepository;
import casestudy.repository.EmployeeRepository;
import casestudy.service.IAbsenceManager;

import java.util.List;

public class AbsenceService implements IAbsenceManager {
    private AbsenceRepository absenceRepository = new AbsenceRepository();
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Absence> getByEmployee(int employeeId) {
        return List.of();
    }

    @Override
    public int countAbsent(int employeeId) {
        Employee employee = employeeRepository.getByID(employeeId);
        if(employee == null){
            throw new IllegalArgumentException("Nhan vien khong ton tai");
        }
        return absenceRepository.countAbsent(employee.getId());
    }

    @Override
    public void add(Absence entity) {
        absenceRepository.add(entity);
    }

    @Override
    public boolean update(Absence entity) {
        return absenceRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        absenceRepository.delete(id);
    }

    @Override
    public Absence getById(int id) {
        return absenceRepository.getById(id);
    }

    @Override
    public List<Absence> getAll() {
        return absenceRepository.getAll();
    }
}
