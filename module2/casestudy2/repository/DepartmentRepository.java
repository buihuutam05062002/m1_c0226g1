package casestudy2.repository;

import casestudy2.entity.Department;
import casestudy2.entity.Employee;
import casestudy2.entity.JobRole;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {
    List<Department> departments;
    private String filePath = "src/casestudy2/data/department.csv";


    private static DepartmentRepository instance;

    private DepartmentRepository() {
        this.departments = loadFromFile();
    }

    public static DepartmentRepository getInstance() {
        if (instance == null) instance = new DepartmentRepository();
        return instance;
    }

    private List<Department> loadFromFile() {
        List<Department> deEmployeeList = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return deEmployeeList;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                Department e = lineToDepartment(line);
                if (e != null) deEmployeeList.add(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return deEmployeeList;
    }

    private void saveToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Department e : departments) {
                bufferedWriter.write(departmentToLine(e));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Department lineToDepartment(String line) {
        try {
            String[] p = line.split(",");
            Department department = new Department();
            department.setId(Integer.parseInt(p[0].trim()));
            department.setName(p[1].trim());
            department.setManagerId(Integer.parseInt(p[2].trim()));
            return department;
        } catch (Exception ex) {
            System.out.println("dòng lỗi");
            return null;
        }
    }

    private String departmentToLine(Department e) {
        return String.join(","
                , String.valueOf(e.getId()), e.getName(), String.valueOf(e.getManagerId()));
    }


    public boolean add(Department department) {

        boolean added = departments.add(department);
        if (added) {
            saveToFile();
        }
        return added;
    }

    public List<Department> getAll() {
        return new ArrayList<>(departments);
    }

    public Department getById(int id) {
        int n = departments.size();
        for (int i = 0; i < n; i++) {
            if (departments.get(i).getId() == id) {
                return departments.get(i);
            }
        }
        return null;
    }

    public boolean changeManager(Department department, int manageId) {
        int n = departments.size();
        for (int i = 0; i < n; i++) {
            if (departments.get(i).getId() == department.getId()) {
                departments.get(i).setManagerId(manageId);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        boolean delete = departments.removeIf(e -> e.getId() == id);
        if (delete) {
            saveToFile();
        }
        return delete;
    }


    public boolean update(Department department) {
        int n = departments.size();
        for (int i = 0; i < n; i++) {
            if (departments.get(i).getId() == department.getId()) {
                departments.get(i).setName(department.getName());
                saveToFile();
                return true;
            }
        }
        return false;
    }
}
