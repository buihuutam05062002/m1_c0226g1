package casestudy2.controller;

import casestudy2.entity.Employee;
import casestudy2.entity.JobRole;
import casestudy2.service.IEmployeeService;
import casestudy2.service.impl.EmployeesService;

import java.util.List;

public class EmployeeController {
    IEmployeeService iEmployeeManager = new EmployeesService();


    public List<Employee> findByJob(JobRole job) {
        return iEmployeeManager.findByJob(job);
    }

    public List<Employee> findByName(String name) {
        return iEmployeeManager.findByName(name);
    }

    public void add(Employee entity) {
        iEmployeeManager.add(entity);
    }


    public boolean update(Employee entity) {
        return iEmployeeManager.update(entity);
    }


    public void delete(int id) {
        iEmployeeManager.delete(id);
    }


    public Employee getById(int id) {
        return iEmployeeManager.getById(id);
    }


    public List<Employee> getAll() {
        return iEmployeeManager.getAll();
    }

}
