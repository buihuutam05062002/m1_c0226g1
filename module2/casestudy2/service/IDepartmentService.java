package casestudy2.service;

import casestudy2.entity.Department;

import casestudy2.service.IService;

public interface IDepartmentService extends IService<Department> {
        void changeManager(Department department,int manageId );
    }
