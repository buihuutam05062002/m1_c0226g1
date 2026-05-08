package casestudy.controller;

import casestudy.entity.Department;
import casestudy.entity.Employee;
import casestudy.service.IDepartmentManager;
import casestudy.service.impl.DepartmentService;

import java.util.List;

public class DepartmentController {
    private IDepartmentManager iDepartmentManager = new DepartmentService();

    
    public void changeManager(Department department, Employee employee) {
         iDepartmentManager.changeManager(department,employee);
    }

    
    public void add(Department entity) {
        iDepartmentManager.add(entity);
    }

    
    public boolean update(Department entity) {
        return iDepartmentManager.update(entity);
    }

    
    public void delete(int id) {
        iDepartmentManager.delete(id);
    }

    
    public Department getById(int id) {
        return iDepartmentManager.getById(id);
    }

    
    public List<Department> getAll() {
        return iDepartmentManager.getAll();
    }
}
