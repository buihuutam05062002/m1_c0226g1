package casestudy2.service.impl;

import casestudy2.entity.Absence;
import casestudy2.entity.Employee;
import casestudy2.repository.AbsenceRepository;
import casestudy2.repository.EmployeeRepository;
import casestudy2.service.IAbsenceService;

import java.time.YearMonth;
import java.util.List;

public class AbsenceService implements IAbsenceService {
    private AbsenceRepository absenceRepository = AbsenceRepository.getInstance();
    private EmployeeRepository employeeRepository = EmployeeRepository.getInstance();


    @Override
    public List<Absence> getByEmployee(int employeeId) {
        return absenceRepository.getByEmployee(employeeId);
    }

    @Override
    public int countAbsent(int employeeId, YearMonth yearMonth) {
        Employee employee = employeeRepository.getById(employeeId);
        if (employee == null) {
            throw new IllegalArgumentException("Nhan vien khong ton tai");
        }
        return absenceRepository.countAbsent(employeeId, yearMonth);
    }

    @Override
    public boolean add(Absence entity) {
        return absenceRepository.add(entity);
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
