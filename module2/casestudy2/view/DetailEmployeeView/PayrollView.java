package casestudy2.view.DetailEmployeeView;

import casestudy2.controller.EmployeeController;
import casestudy2.controller.PayrollController;
import casestudy2.entity.Absence;
import casestudy2.entity.Payroll;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PayrollView {
    private PayrollController payrollController = new PayrollController();
    private EmployeeController employeeController = new EmployeeController();
    private Scanner sc = new Scanner(System.in);


    public void run() {
        while (true) {
            int choice = choice();
            switch (choice) {
                case 1:
                    System.out.println("Thêm mới bảng lương: ");
                    payrollController.add(input());
                    break;
                case 2:
                    payrollController.update(input());
                {
                    int idPayroll = inputId("Nhập id bảng lương");
                    Payroll payroll = payrollController.getById(idPayroll);
                    if (payroll == null) {
                        System.out.println("bảng lương không tồn tại");
                    } else {
                        int employeeId;
                        while (true) {
                            employeeId = inputId("Nhập id nhân viên: ");
                            if (employeeController.getById(employeeId) != null) {
                                break;
                            }
                            System.out.println("Nhân viên không tồn tại, vui lòng nhập lại!");
                        }

                        BigDecimal baseSalary = inputBigDecimal("Nhập lương cơ bản: ");
                        BigDecimal bonus = inputBigDecimal("Nhập thưởng: ");


                        List<Payroll> payrolls = payrollController.getByEmployee(employeeId);
                        int n = payrolls.size();
                        YearMonth period;
                        while (true) {
                            period = inputYearMonth("Nhập tháng/năm (MM/yyyy): ");
                            boolean isCheck = false;
                            for (int i = 0; i < n; i++) {
                                if (payrolls.get(i).getPeriod().equals(period)) {
                                    System.out.println("Đã tồn tại 1 bảng lương của nhân viên vào tháng đó");
                                    isCheck = true;
                                    break;
                                }
                            }
                            if (!isCheck) {
                                break;
                            }
                        }
                        payrollController.update(new Payroll(idPayroll, employeeId, baseSalary, bonus, period));
                    }
                    break;
                }
                case 3: {
                    System.out.print("Nhập mã phiếu xóa cần xóa: ");
                    while (true) {
                        Payroll payroll = payrollController.getById(inputId("Nhập id bảng lương"));
                        if (payroll != null) {
                            System.out.println("Bạn có chắc chắn muốn xóa, nhấn y để xóa; hoặc bất kỳ để thoát");
                            if (sc.nextLine().matches("y")) {
                                payrollController.delete(payroll.getId());
                                System.out.println("Đã xóa thành công");
                                break;
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("bảng lương không tồn tại");
                        }
                    }
                    break;
                }
                case 4:
                    display(payrollController.getAll());
                    break;
                case 5:
                    Payroll payroll = payrollController.getById(inputId("Nhập id bảng lương: "));
                    if (payroll == null) {
                        System.out.println("Không tìm thấy bảng lương!");
                    } else {
                        System.out.println(payroll);
                    }
                    break;
                default:
                    return;
            }
        }
    }


    private int choice() {
        System.out.println("\n 1.Add 2.Update 3.Delete 4.Show 5.Search Nhấn bất kì để thoát");
        System.out.print("Nhập lựa chọn của mình:");
        String numb = sc.nextLine();

        while ((numb.isBlank() || numb.isEmpty())) {
            System.out.println("vui long khong duoc de trong");
            System.out.print("Choose: ");
            numb = sc.nextLine();
            ;
        }


        return Integer.parseInt(numb);
    }

    private Payroll input() {
        int id = inputId("Nhập id bảng lương: ");
        int employeeId;
        while (true) {
            employeeId = inputId("Nhập id nhân viên: ");
            if (employeeController.getById(employeeId) != null) {
                break;
            }
            System.out.println("Nhân viên không tồn tại, vui lòng nhập lại!");
        }

        BigDecimal baseSalary = inputBigDecimal("Nhập lương cơ bản: ");
        BigDecimal bonus = inputBigDecimal("Nhập thưởng: ");


        List<Payroll> payrolls = payrollController.getByEmployee(employeeId);
        int n = payrolls.size();
        YearMonth period;
        while (true) {
            period = inputYearMonth("Nhập tháng/năm (MM/yyyy): ");
            boolean isCheck = false;
            for (int i = 0; i < n; i++) {
                if (payrolls.get(i).getPeriod().equals(period)) {
                    System.out.println("Đã tồn tại 1 bảng lương của nhân viên vào tháng đó");
                    isCheck = true;
                    break;
                }
            }
            if (!isCheck) {
                break;
            }
        }


        return new Payroll(id, employeeId, baseSalary, bonus, period);
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

    private YearMonth inputYearMonth(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            if (input.matches("\\d{2}/\\d{4}")) {
                return YearMonth.parse(input, formatter);
            }
            System.out.println("Vui lòng nhập đúng định dạng MM/yyyy");
        }
    }

    private BigDecimal inputBigDecimal(String message) {
        while (true) {
            System.out.print(message);
            BigDecimal value = new BigDecimal(sc.nextLine());
            if (value.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("Không được nhập số âm!");
                continue;
            }
            return value;
        }
    }


    private void display(List<Payroll> payrolls) {
        System.out.println("""
+-----+------------+-----------------+--------------+------------+-----------------+-----------------+
| ID  | EmployeeID | Base Salary     | Bonus        | Period     | Gross Salary    | Net Salary      |
+-----+------------+-----------------+--------------+------------+-----------------+-----------------+
""");
        int n = payrolls.size();
        for (int i = 0; i < n; i++) {
            System.out.println(payrolls.get(i));
        }
    }
}
