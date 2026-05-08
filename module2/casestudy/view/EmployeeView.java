package casestudy.view;

import casestudy.controller.EmployeeController;
import casestudy.entity.Employee;
import casestudy.entity.JobRole;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeView {
    private EmployeeController employeeController = new EmployeeController();
    private Scanner sc = new Scanner(System.in);


    public void run(){
        while(true){
            int choice = menu();
        }
    }


    private int menu(){
        System.out.println("\n 1.Add 2.Update 3.Delete 4.Show 5.Search");
        System.out.print("Choose: ");
        return Integer.parseInt(sc.nextLine());
    }
    private Employee inputEmployee(){
        System.out.println("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Name: ");
        String name = sc.nextLine();

        System.out.println("email");
        String email = sc.nextLine();

        System.out.println("Born dd/MM/yyyy");
        String birth = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate born = LocalDate.parse(birth,formatter);

        System.out.println("Number phone");
        String phoneNumber = sc.nextLine();

        System.out.println();

//        JobRole jobRole = JobRole.valueOf() ;

        return new Employee();

    }
}
