package casestudy2.service.impl;

import casestudy2.entity.Employee;
import casestudy2.entity.JobRole;
import casestudy2.repository.EmployeeRepository;
import casestudy2.service.IEmployeeService;

import java.util.List;

public class EmployeesService implements IEmployeeService {
    private EmployeeRepository employeeRepository = EmployeeRepository.getInstance();


    @Override
    public List<Employee> findByJob(JobRole job) {
        return employeeRepository.getEmployeesByJobRole(job);
    }


    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.getEmployeesByName(name);
    }

    @Override
    public boolean add(Employee entity) {
        return employeeRepository.add(entity);
    }

    @Override
    public boolean update(Employee entity) {
        return employeeRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}
