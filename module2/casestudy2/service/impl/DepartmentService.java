package casestudy2.service.impl;

import casestudy2.entity.Department;
import casestudy2.repository.DepartmentRepository;
import casestudy2.repository.EmployeeRepository;
import casestudy2.service.IDepartmentService;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private DepartmentRepository departmentRepository = DepartmentRepository.getInstance();
    private EmployeeRepository employeeRepository = EmployeeRepository.getInstance();

    @Override
    public void changeManager(Department department, int managerId) {
        if (employeeRepository.getById(managerId) == null) {
            return;
        }
        if (departmentRepository.getById(department.getId()) == null) {
            return;
        }
        departmentRepository.changeManager(department, managerId);
    }

    @Override
    public boolean add(Department entity) {
        return departmentRepository.add(entity);
    }

    @Override
    public boolean update(Department entity) {
        return departmentRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        departmentRepository.delete(id);
    }

    @Override
    public Department getById(int id) {
        return departmentRepository.getById(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.getAll();
    }
}
