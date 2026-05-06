package casestudy.entity;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private Integer id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private JobRole jobRole;
    private String address;

    private List<Absence> absences;

}
