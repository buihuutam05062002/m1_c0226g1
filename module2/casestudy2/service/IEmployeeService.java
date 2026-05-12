package casestudy2.service;

import casestudy2.entity.Employee;
import casestudy2.entity.JobRole;
import casestudy2.service.IService;

import java.util.List;

public interface IEmployeeService extends IService<Employee> {
    List<Employee> findByJob(JobRole job);
    List<Employee> findByName (String name);
}
