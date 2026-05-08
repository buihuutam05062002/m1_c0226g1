package casestudy.service;

import casestudy.entity.Department;
import casestudy.entity.Employee;

public interface IDepartmentManager extends IManager<Department> {
        void changeManager(Department department,Employee employee );
    }
