package casestudy2.view.DetailEmployeeView;

import casestudy2.controller.AbsenceController;
import casestudy2.entity.Absence;
import casestudy2.entity.Employee;
import casestudy2.entity.JobRole;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Scanner;

public class AbsenceView {
    private AbsenceController absenceController = new AbsenceController();
    private Scanner sc = new Scanner(System.in);

    public void run(int id) {

        while (true) {
            int choice = choice();
            switch (choice) {
                case 1:
                    absenceController.add(input(id));
                    break;
                case 2: {
                    int idEmployee = inputId("Nhập id nhân viên");
                    Absence absence = absenceController.getById(idEmployee);
                    if (absence == null) {
                        System.out.println("bảng vắng không tồn tại");
                    } else {
                        LocalDate startDay = inputDate("Nhập ngày bắt đầu (dd/MM/yyyy): ");
                        LocalDate endDay = inputDateAfter("Nhập ngày kết thúc (dd/MM/yyyy): ", startDay);
                        String reason = inputString("Nhập lý do: ");
                        absenceController.update(new Absence(absence.getId(), idEmployee, startDay, endDay, reason));
                        System.out.println("cập nhật thành công");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Nhập mã phiếu xóa cần xóa: ");
                    while (true) {
                        Absence absence = absenceController.getById(inputId("Nhập id phiếu vắng"));
                        if (absence != null) {
                            System.out.println("Bạn có chắc chắn muốn xóa, nhấn y để xóa; hoặc bất kỳ để thoát");
                            if (sc.nextLine().matches("y")) {
                                absenceController.delete(absence.getId());
                                System.out.println("Đã xóa thành công");
                                break;
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("phiếu vắng không tồn tại không tồn tại");
                        }
                    }
                    break;
                }
                case 4:
                    System.out.println("hiển thị danh sách ngày nghỉ theo nhân viên");
                    display(absenceController.getByEmployee(id));
                    break;
                case 5:
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
                    YearMonth period = YearMonth.parse(sc.nextLine(), formatter);


                    System.out.println("Tổng số ngày nghỉ là: " + absenceController.countAbsent(id, period));
                    break;
                default:
                    return;
            }
        }
    }

    public int choice() {
        System.out.println("\n 1.Add 2.Update 3.Delete 4.Show 5.Search Nhấn bất kì để thoát");
        System.out.println("Nhập lựa chọn của mình: ");
        String numb = sc.nextLine();

        while ((numb.isBlank() || numb.isEmpty())) {
            System.out.println("vui long khong duoc de trong");
            System.out.print("Choose: ");
            numb = sc.nextLine();
            ;
        }


        return Integer.parseInt(numb);
    }

    public Absence input(int idEmployee) {
        int id = inputId("Nhập id phiếu nghỉ: ");
        LocalDate startDay = inputDate("Nhập ngày bắt đầu (dd/MM/yyyy): ");
        LocalDate endDay = inputDateAfter("Nhập ngày kết thúc (dd/MM/yyyy): ", startDay);
        String reason = inputString("Nhập lý do: ");
        return new Absence(id, idEmployee, startDay, endDay, reason);
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

    private LocalDate inputDate(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            if (input.matches("\\d{2}/\\d{2}/\\d{4}")) {
                return LocalDate.parse(input, formatter);
            }
            System.out.println("Vui lòng nhập đúng định dạng dd/MM/yyyy!");
        }
    }

    private LocalDate inputDateAfter(String message, LocalDate startDate) {
        while (true) {
            LocalDate endDate = inputDate(message);
            if (!endDate.isBefore(startDate)) {
                return endDate;
            }
            System.out.println("Ngày kết thúc phải sau hoặc bằng ngày bắt đầu!");
        }
    }

    public void display(List<Absence> absences) {
        System.out.println("""
+-----+------------+--------------+--------------+---------------------------+
| ID  | EmployeeID | Start Date   | End Date     | Reason                    |
+-----+------------+--------------+--------------+---------------------------+
""");
        int n = absences.size();
        for (int i = 0; i < n; i++) {
            System.out.println(absences.get(i));
        }
    }
}
