package casestudy2.repository;

import casestudy2.entity.Employee;
import casestudy2.entity.JobRole;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class    EmployeeRepository {

    private static EmployeeRepository instance; // ← thêm dòng này

    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }


    private String filePath = "D:\\module2\\src\\casestudy2\\data\\employees.csv";
    private List<Employee> employeeList;


    private EmployeeRepository() {
        this.employeeList = loadFromFile();
    }

    private List<Employee> loadFromFile() {
        List<Employee> employees = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return employees;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                Employee e = lineToEmployee(line);
                if (e != null) employees.add(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    private void saveToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee e : employeeList) {
                bufferedWriter.write(employeeToLine(e));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Employee lineToEmployee(String line) {
        try {
            String[] p = line.split(",");
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(p[0].trim()));
            employee.setName(p[1].trim());
            employee.setEmail(p[2].trim());
            employee.setDateOfBirth(LocalDate.parse(p[3].trim()));
            employee.setPhoneNumber(p[4].trim());
            employee.setJobRole(JobRole.valueOf(p[5].trim()));
            employee.setAddress(p[6].trim());
            employee.setIdDepartment(Integer.parseInt(p[7].trim()));
            return employee;
        } catch (Exception ex) {
            System.out.println("Dòng lỗi");
            return null;
        }
    }

    private String employeeToLine(Employee e) {
        return String.join(","
                , String.valueOf(e.getId()), e.getName(), e.getEmail(), e.getDateOfBirth().toString(), e.getPhoneNumber(), e.getJobRole().name(), e.getAddress(), String.valueOf(e.getIdDepartment()), e.getIdDepartment() != null ? String.valueOf(e.getIdDepartment()) : "0");
    }


    public boolean add(Employee employee) {
        boolean added = employeeList.add(employee);
        if (added) {
            saveToFile();
        }
        return added;

    }

    public List<Employee> getAll() {
        return new ArrayList<>(employeeList);
    }

    public Employee getById(int id) {
        int n = employeeList.size();
        for (int i = 0; i < n; i++) {
            if (employeeList.get(i).getId() == id) {
                return employeeList.get(i);
            }
        }
        return null;
    }

    public boolean update(Employee employee) {
        int n = employeeList.size();
        for (int i = 0; i < n; i++) {
            if (employeeList.get(i).getId() == employee.getId()) {
                employeeList.get(i).setName(employee.getName());
                employeeList.get(i).setEmail(employee.getEmail());
                employeeList.get(i).setDateOfBirth(employee.getDateOfBirth());
                employeeList.get(i).setPhoneNumber(employee.getPhoneNumber());
                employeeList.get(i).setJobRole(employee.getJobRole());
                employeeList.get(i).setAddress(employee.getAddress());
                employeeList.get(i).setIdDepartment(employee.getIdDepartment());
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        boolean delete = employeeList.removeIf(e -> e.getId() == id);
        if (delete) {
            saveToFile();
        }
        return delete;
    }

    public List<Employee> getEmployeesByJobRole(JobRole jobRole) {
        List<Employee> employeeList1 = new ArrayList<>();
        int n = employeeList.size();
        for (int i = 0; i < n; i++) {
            if (jobRole.equals(employeeList.get(i).getJobRole())) {
                employeeList1.add(employeeList.get(i));
            }
        }
        return employeeList1;
    }

    public List<Employee> getEmployeesByName(String name) {
        List<Employee> employeeList1 = new ArrayList<>();
        int n = employeeList.size();
        for (int i = 0; i < n; i++) {
            if (employeeList.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                employeeList1.add(employeeList.get(i));
            }
        }
        return employeeList1;
    }


}
