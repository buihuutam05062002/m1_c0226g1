package casestudy.service;

import casestudy.entity.Employee;

public interface IEmployeeManager extends IManager<Employee> {
    void findByJob();
    void findByDepartment();
    void findByName();
}
