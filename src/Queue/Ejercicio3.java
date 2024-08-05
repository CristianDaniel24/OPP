package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Customer> row = new LinkedList<Customer>();

        System.out.println("WELCOME TO THE WAITING LINE%n");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu to row");
            System.out.printf("1. Add to Customer%n");
            System.out.printf("2. Serve client%n");
            System.out.printf("3. Row details%n");
            System.out.printf("4. Exit%n");
            System.out.printf("Enter to option:%n");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    add(row, scanner);
                    break;
                case 2:
                    serve(row, scanner);
                    break;
                case 3:
                    details(row);
                    break;
                case 4:
                    System.out.println("Bye..");
                    exit = true;
                    break;
                default:
                    System.out.println("The option is invalid :(");
            }
        }
    }

    public static void add(Queue<Customer> row, Scanner scanner) {
        System.out.println("Enter the number of Customers");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            scanner.nextLine();
            System.out.printf("Enter the name to customer for add the row:%n");
            String name = scanner.nextLine();
            System.out.printf("Enter the age to Customer:%n");
            int age = scanner.nextInt();
            Customer customer = new Customer(name, age);
            row.add(customer);
        }
        System.out.printf("The Customer to add successfully..%n");
        details(row);
    }

    public static void serve(Queue<Customer> row, Scanner scanner) {
        if (!row.isEmpty()) {
            System.out.println("You want to server a client? true/false");
            boolean attend = scanner.nextBoolean();

            if (attend) {
                System.out.println("The client is: " + row.peek().getName());
                System.out.println("You want to attend to it? true/false");
                boolean attendCustomer = scanner.nextBoolean();
                if (attendCustomer) {
                    Customer customerPoll = row.poll();
                    System.out.println("\nThe client attend is: " + customerPoll.getName());
                    System.out.println("Remaining services: " + row.size());
                }
            }
        } else {
            System.out.println("The row is empty =(");
        }
    }

    public static void details(Queue<Customer> row) {
        boolean isEmpty = false;
        if (!row.isEmpty()) {
            System.out.printf("The row is:%n");
            for (Customer details : row) {
                System.out.println("-Name: " + details.getName() + "\n-Age: " + details.getAge());
            }
            isEmpty = true;
        } else {
            System.out.println("The row is empty =(");
        }
        if (isEmpty) {
            System.out.println("Remaining services: " + row.size());
        }
    }
}
