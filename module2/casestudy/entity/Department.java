package casestudy.entity;

import java.util.List;

public class Department {
    private int id;
    private String name;
    private Employee manager;

    private List<Employee> employees;


    public Department(String name, Employee manager, int id, List<Employee> employees) {
        this.name = name;
        this.manager = manager;
        this.id = id;
        this.employees = employees;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Department{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", manager=").append(manager);
        sb.append(", employees=").append(employees);
        sb.append('}');
        return sb.toString();
    }
}
