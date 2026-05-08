package casestudy.service;

import casestudy.entity.Employee;
import casestudy.entity.JobRole;

import java.util.List;

public interface IEmployeeManager extends IManager<Employee> {
    List<Employee> findByJob(JobRole job);
    List<Employee> findByName (String name);

}
