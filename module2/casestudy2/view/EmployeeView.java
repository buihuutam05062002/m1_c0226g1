package casestudy2.view;

import casestudy2.controller.DepartmentController;
import casestudy2.controller.EmployeeController;
import casestudy2.entity.Department;
import casestudy2.entity.Employee;
import casestudy2.entity.JobRole;

import casestudy2.view.DetailEmployeeView.AbsenceView;
import casestudy2.view.DetailEmployeeView.PayrollView;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private EmployeeController employeeController = new EmployeeController();
    private DepartmentController departmentController = new DepartmentController();
    private Scanner sc = new Scanner(System.in);
    private Employee employee;


    public void run() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    System.out.println("Thêm mới nhân viên: ");
                    employeeController.add(inputEmployee());
                    break;
                case 2:
                    System.out.println("Nhập nhân viên cần cập nhật: ");

                    int idEmployee = inputId("Nhập id nhân viên");
                    employee = employeeController.getById(idEmployee);
                    if (employee == null) {
                        System.out.println("nhân viên không tồn tại");
                    } else {
                        String name = inputString("Name: ");
                        String email = inputEmail("Email: ");
                        LocalDate born = inputDate("Born dd/MM/yyyy: ");
                        String phone = inputPhone("Number phone: ");
                        JobRole jobRole = inputJobRole("Job: ");
                        String address = inputString("Address: ");
                        int idDepartment = inputId("ID Phong ban: ");
                        employeeController.update(new Employee(employee.getId(), idDepartment, name, email, born, phone, jobRole, address));
                        System.out.println("cập nhật thành công");
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã nhân viên cần xóa: ");
                    while (true) {
                        employee = employeeController.getById(inputId("Nhập id nhân viên"));
                        if (employee != null) {
                            System.out.println("Bạn có chắc chắn muốn xóa, nhấn y để xóa; hoặc bất kỳ để thoát");
                            if (sc.nextLine().matches("y")) {
                                employeeController.delete(employee.getId());
                                System.out.println("Đã xóa thành công");
                                break;
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("nhân viên không tồn tại");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Danh sách tất cả nhân viên: ");
                    display(employeeController.getAll());
                    break;
                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    display(employeeController.findByName(sc.nextLine()));
                    break;
                case 6:
                    System.out.print("Nhập  theo job: ");
                    display(employeeController.findByJob(inputJobRole("JobRole: ")));
                    break;
                case 7:
                    System.out.println("Vắng mặt: ");
                    Employee employee1 = employeeController.getById(inputId("Nhập id nhân viên"));
                    if (employee1 == null) {
                        System.out.println("nhân viên không tồn tại");
                    } else {
                        (new AbsenceView()).run(employee1.getId());
                    }
                    break;

                case 8:
                    System.out.print("Lương: ");
                    (new PayrollView()).run();
                    break;

                case 9:
                    System.out.println("Phòng ban");
                    (new DepartmentView()).run();
                    break;


                case 10:
                    System.out.println("Nhập phòng ban cần sẻt");
                    Department Phongban = departmentController.getById(inputId("Id phòng ban"));
                    if (Phongban == null) {
                        System.out.println("Phòng ban không tồn tại");
                    } else {
                        employee = employeeController.getById(inputId("nhập id nhân viên"));
                        if (employee != null) {
                            employee.setIdDepartment(Phongban.getId());
                            employeeController.update(employee);
                        } else {
                            System.out.println("nhân viên không tồn tại");
                        }
                    }
                    break;

                default:
                    return;
            }
        }
    }


    private int menu() {
        System.out.println("\n 1.Add 2.Update 3.Delete 4.Show 5.Search 6.SearchByJob 7.Absence 8.Payroll 9 Department, Nhấn bất kì để thoát");
        System.out.print("Choose: ");

        String numb = sc.nextLine();

        while ((numb.isBlank() || numb.isEmpty())) {
            System.out.println("vui long khong duoc de trong");
            System.out.print("Choose: ");
            numb = sc.nextLine();
            ;
        }


        return Integer.parseInt(numb);
    }



    private Employee inputEmployee() {
        List<Employee> employees = employeeController.getAll();
        int id;
        while (true){
            id = inputId("ID: ");
            boolean isFlag = false;

            int n = employees.size();
            for(int i = 0 ; i < n; i++){
                if(employees.get(i).getId().equals(id)){
                    System.out.println("Id đã tồn tại, vui lòng nhập id khác");
                    isFlag = true;
                    break;
                }
            }
            if(!isFlag){
                break;
            }

        }



        String name = inputString("Name: ");
        String email = inputEmail("Email: ");
        LocalDate born = inputDate("Born dd/MM/yyyy: ");
        String phone = inputPhone("Number phone: ");
        JobRole jobRole = inputJobRole("Job: ");
        String address = inputString("Address: ");
        int idDepartment = inputId("ID Phong ban: ");

        return new Employee(id, idDepartment, name, email, born, phone, jobRole, address);
    }

    private int inputId(String mes) {
        while (true) {
            System.out.print(mes);
            String input = sc.nextLine();
            if (input.matches("-?\\d+")) {
                if (input.matches("-\\d+")) {
                    System.out.println("Hãy nhập số dương");
                } else {
                    return Integer.parseInt(input);
                }
            }
        }
    }

    private String inputString(String mes) {
        while (true) {
            System.out.print(mes);
            String input = sc.nextLine();
            if (!input.isBlank()) {
                return input;
            }
            System.out.println("tên đang bị trống vui lòng nhập");
        }
    }

    private String inputEmail(String mes) {
        while (true) {
            System.out.print(mes);
            String input = sc.nextLine();
            if (input.matches("^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                return input;
            }
            System.out.println("Nhập email chưa đúng ");
        }
    }

    private String inputPhone(String mes) {
        while (true) {
            System.out.print(mes);
            String input = sc.nextLine();
            if (input.matches("^(0[3|5|7|8|9])\\d{8}$")) {
                return input;
            }
            System.out.println("Số điện thoại không hợp lệ ");
        }
    }

    private JobRole inputJobRole(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            try {
                return JobRole.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("JobRole không hợp lệ! Vui lòng nhập lại.");
            }
        }
    }

    private LocalDate inputDate(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = null;
        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine();
                if (!input.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    System.out.println("Vui lòng nhập đúng định dạng dd/MM/yyyy!");
                }
                date = LocalDate.parse(input, formatter);

            } catch (DateTimeException ex) {
                System.out.println("Sai định dạng ngày/ tháng / năm");
            }
            if (date != null) {
                return date;
            }
        }
    }


    private void display(List<Employee> employees) {
        int n = employees.size();
        System.out.println("""
+----+--------------+----------------------+----------------------+------------+---------------+-----------+------------------+
| ID | DepartmentID | Name                 | Email                | BirthDate | Phone         | Role      | Address          |
+----+--------------+----------------------+----------------------+------------+---------------+-----------+------------------+
""");

        for (int i = 0; i < n; i++) {
            System.out.println(employees.get(i));
        }
    }

}
