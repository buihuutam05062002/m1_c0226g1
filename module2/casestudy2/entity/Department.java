package casestudy2.entity;

import java.util.List;

public class Department {
    private Integer id;
    private String name;
    private Integer managerId;


    public Department(int id, String name, int manager) {
        this.name = name;
        this.managerId = manager;
        this.id = id;
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

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }


    @Override
    public String toString() {
        return String.format(
                "| %-3d | %-20s | %-10d |",
                id,
                name,
                managerId
        );
    }
}
