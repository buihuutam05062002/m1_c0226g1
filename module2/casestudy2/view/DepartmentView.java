package casestudy2.view;

import casestudy2.controller.DepartmentController;
import casestudy2.entity.Department;

import java.util.List;
import java.util.Scanner;

public class DepartmentView {

    private DepartmentController departmentController = new DepartmentController();
    private Scanner sc = new Scanner(System.in);


    public void run() {
        while (true) {
            int choice = choice();
            switch (choice) {
                case 1:
                    departmentController.add(input());
                    break;
                case 2:
                    departmentController.update(input());
                    break;
                case 3:
                    departmentController.delete(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    display(departmentController.getAll());
                    break;
                default:
                    return;
            }
        }

    }

    public int choice() {
        System.out.println("\n 1.Add 2.Update 3.Delete 4.Show 5.Search");
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

    public void display(List<Department> departments) {
        System.out.println("""
+-----+----------------------+------------+
| ID  | Department Name      | Manager ID |
+-----+----------------------+------------+
""");
        int n = departments.size();
        for (int i = 0; i < n; i++) {
            System.out.println(departments.get(i));
        }
    }

    public Department input() {
        int id = inputId("Nhập mã phòng ban: ");
        String name = inputString("Nhập tên phòng ban: ");
        int managerId = inputId("Nhập mã quản lý: ");
        return new Department(id, name, managerId);
    }

    private int inputId(String id) {
        while (true) {
            System.out.print("ID: ");
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

    private String inputString(String name) {
        while (true) {
            System.out.print("Name: ");
            String input = sc.nextLine();
            if (!input.isBlank()) {
                return input;
            }
            System.out.println("tên đang bị trống vui lòng nhập");
        }
    }
}
