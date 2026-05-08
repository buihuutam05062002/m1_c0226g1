package casestudy.controller;

import casestudy.entity.Employee;
import casestudy.entity.JobRole;
import casestudy.service.IEmployeeManager;
import casestudy.service.impl.EmployeesService;

import java.util.List;

public class EmployeeController {
    IEmployeeManager iEmployeeManager = new EmployeesService();

     
    public List<Employee> findByJob(JobRole job) {
        return iEmployeeManager.findByJob(job);
    }
    public List<Employee> findByName(String name){
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
