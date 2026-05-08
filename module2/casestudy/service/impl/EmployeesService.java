package casestudy.service.impl;

import casestudy.entity.Employee;
import casestudy.entity.JobRole;
import casestudy.repository.EmployeeRepository;
import casestudy.service.IEmployeeManager;

import java.util.List;

public class EmployeesService implements IEmployeeManager {
   private EmployeeRepository employeeRepository = new EmployeeRepository();



    @Override
    public List<Employee> findByJob(JobRole job) {
        return employeeRepository.getEmployeesByJobRole(job);
    }



    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.getEmployeesByName(name);
    }

    @Override
    public void add(Employee entity) {
        employeeRepository.add(entity);
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
        return employeeRepository.getByID(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}
