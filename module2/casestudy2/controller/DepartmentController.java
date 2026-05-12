package casestudy2.controller;

import casestudy2.entity.Department;
import casestudy2.service.IDepartmentService;
import casestudy2.service.impl.DepartmentService;

import java.util.List;

public class DepartmentController {
    private IDepartmentService iDepartmentManager = new DepartmentService();


    public void changeManager(Department department, int managerId) {
        iDepartmentManager.changeManager(department, managerId);
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
