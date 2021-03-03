package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controller.Controller;

import java.time.LocalDate;
import java.util.Scanner;

public class MyApplication {
    private final Controller controller;

    Scanner scanner = new Scanner(System.in);

    public MyApplication(Controller controller) {
        this.controller = controller;
    }

    public void Start() {
        while (true) {
            System.out.println("Choose one option:\n 1) Search for any employee by name in FrontendDeveloper\n " +
                    "2)Search for any employee by name in BackendDeveloper\n " +
                    "3)Get employee by ID\n " +
                    "4)Add employee in FrontendDeveloper \n " +
                    "5)Add employee in BackendDeveloper\n " +
                    "6)Remove employee by ID\n " +
                    "7)Show all employee in FrontendDeveloper\n "+
                    "8)Show all employee in BackendDeveloper\n "+
                    "9)Show the salary costs of Backend developers\n "+
                    "10)Show the salary costs of Frontend developers\n "+
                    "11)Stop choosing");
            int number = scanner.nextInt();
            if (number == 1) {
                System.out.println("Write the name of employee:");
                String name = scanner.next();
                System.out.println(controller.searchFrontendByName(name));

            } else if (number == 2) {
                System.out.println("Write the name of employee:");
                String name = scanner.next();
                System.out.println(controller.searchBackendByName(name));

            } else if (number == 3) {
                System.out.println("Write the ID of employee");
                int id = scanner.nextInt();
                System.out.println(controller.searchEmployeeByID(id));

            } else if (number == 4) {
                System.out.println("Write the employee's name:");
                String name = scanner.next();
                System.out.println("Write the employee's surname:");
                String surname = scanner.next();
                System.out.println("Write the employee's age:");
                int age = scanner.nextInt();
                System.out.println("Write the start date of employee(format of date must to be yyyy-mm-dd):");
                String date = scanner.next();
                LocalDate start_date = LocalDate.parse(date);
                System.out.println("Write the salary:");
                int salary = scanner.nextInt();
                System.out.println(controller.AddFrontend(name, surname, age, start_date, salary));

            } else if (number == 5) {
                System.out.println("Write the employee's name:");
                String name = scanner.next();
                System.out.println("Write the employee's surname:");
                String surname = scanner.next();
                System.out.println("Write the employee's age:");
                int age = scanner.nextInt();
                System.out.println("Write the start date of employee(format of date must to be yyyy-mm-dd):");
                String date = scanner.next();
                LocalDate start_date = LocalDate.parse(date);
                System.out.println("Write the salary:");
                int salary = scanner.nextInt();
                System.out.println(controller.AddBackend(name, surname, age, start_date, salary));

            } else if (number == 6) {
                System.out.println("Write the employee's ID:");
                int id = scanner.nextInt();
                System.out.println(controller.RemoveMedByID(id));
                break;
            }else if(number == 7){
                System.out.println(controller.ShowAllFrontend());
            }else if(number == 8){
                System.out.println(controller.ShowAllBackend());
            }else if(number == 9){
                System.out.println(controller.ShowSumMoneyBackend());
            }else if(number == 10) {
                System.out.println(controller.ShowSumMoneyFrontend());
            }
            else if(number == 11){
                System.out.println("Bye!!");
                break;
            }
            else {
                System.out.println("There is no such option here");
                continue;
            }
            System.out.println("---------------------------------------------------------------");
        }
    }
}
