package casestudy.repository;

import casestudy.entity.Employee;
import casestudy.entity.JobRole;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private List<Employee> employees  = new ArrayList<>();


    public boolean add(Employee employee){
        return employees.add(employee);
    }
    public List<Employee> getAll(){
        return new ArrayList<>(employees);
    }
    public Employee getByID(int id){
        int n = employees.size();
        for(int i = 0 ; i< n;i++){
            if(employees.get(i).getId() == id ){
                return employees.get(i);
            }
        }
        return null;
    }
    public boolean update(Employee employee){
        int n = employees.size();
        for(int i = 0 ; i< n;i++){
            if(employees.get(i).getId() == employee.getId() ){
                employees.get(i).setName(employee.getName());
                employees.get(i).setEmail(employee.getEmail());
                employees.get(i).setDateOfBirth(employee.getDateOfBirth());
                employees.get(i).setPhoneNumber(employee.getPhoneNumber());
                employees.get(i).setJobRole(employee.getJobRole());
                employees.get(i).setAddress(employee.getAddress());
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id){
        return employees.removeIf( e -> e.getId() == id );
    }
    public List<Employee> getEmployeesByJobRole(JobRole jobRole){
        List<Employee> employeeList = new ArrayList<>();
        int n = employees.size();
        for(int i =0; i <n;i++){
            if(jobRole == employees.get(i).getJobRole()){
                employeeList.add(employeeList.get(i));
            }
        }
        return employeeList;
    }
    public List<Employee> getEmployeesByName(String name ){
        List<Employee> employeeList = new ArrayList<>();
        int n = employees.size();
        for(int i =0;i<n;i++){
            if(name.contains(employees.get(i).getName())){
                employeeList.add(employees.get(i));
            }
        }
        return employeeList;
    }



}
