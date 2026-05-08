package casestudy.service.impl;

import casestudy.entity.Department;
import casestudy.entity.Employee;
import casestudy.repository.DepartmentRepository;
import casestudy.repository.EmployeeRepository;
import casestudy.service.IDepartmentManager;

import java.util.List;

public class DepartmentService implements IDepartmentManager {
    private DepartmentRepository departmentRepository = new DepartmentRepository();
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void changeManager(Department department, Employee employee) {
        Employee employee1 = employeeRepository.getByID(employee.getId());
        if(employee1 == null){
            return;
        }
        Department department1 =    departmentRepository.getById(department.getId());
        if(department1 == null){
            return;
        }
        departmentRepository.changeManager(department1, employee1);
    }

    @Override
    public void add(Department entity) {
        departmentRepository.add(entity);
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
        return List.of();
    }
}
