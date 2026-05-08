package casestudy.repository;

import casestudy.entity.Department;
import casestudy.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {
    List<Department> departments = new ArrayList<>();

    public boolean add(Department department) {
        return departments.add(department);
    }

    public List<Department> getAll() {
        return new ArrayList<>(departments);
    }
    public Department getById(int id){
        int n = departments.size();
        for (int i = 0; i < n; i++) {
            if (departments.get(i).getId() == id) {
                return departments.get(i);
            }
        }
        return null;
    }

    public boolean changeManager(Department department, Employee employee) {
        int n = departments.size();
        for (int i = 0; i < n; i++) {
            if (departments.get(i).getId() == department.getId()) {
                departments.get(i).setManager(employee);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return departments.removeIf(e -> e.getId() == id);
    }


    public boolean update(Department department){
        int n = departments.size();
        for(int i = 0 ; i< n;i++){
            if(departments.get(i).getId() == department.getId() ){
                departments.get(i).setName(department.getName());
                return true;
            }
        }
        return false;
    }
}
