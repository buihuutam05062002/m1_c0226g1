package casestudy.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private Integer id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private JobRole jobRole;
    private String address;




    public Employee(Integer id, String name, String email, LocalDate dateOfBirth, String phoneNumber, JobRole jobRole, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.jobRole = jobRole;
        this.address = address;

    }

    public Employee() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobRole getJobRole() {
        return jobRole;
    }

    public void setJobRole(JobRole jobRole) {
        this.jobRole = jobRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", jobRole=").append(jobRole);
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
