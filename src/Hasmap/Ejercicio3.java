package Hasmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, Estudiante> students = new HashMap<>();
        int id = 0;

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu to Students");
            System.out.println("1. Add Studnet");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Details of the Student");
            System.out.println("6. Exit");
            System.out.println("Enter the option:");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    id++;
                    add(students, id, scanner);
                    break;
                case 2:
                    delete(students, scanner);
                    break;
                case 3:
                    update(students, scanner);
                    break;
                case 4:
                    search(students, scanner);
                    break;
                case 5:
                    details(students);
                    break;
                case 6:
                    System.out.println("\nBye..");
                    exit = true;
                    break;
                default:
                    System.out.println("\nThe option is invalid");
            }
        }
    }

    public static void add(HashMap<Integer, Estudiante> students, int id, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter the name of Student:");
        String name = scanner.nextLine();
        System.out.println("Enter the grade of Student:");
        String grade = scanner.nextLine();
        students.put(id, new Estudiante(name, grade));
        System.out.println("\nThe Student add is: " + "\nName: " + name + " \nGrade: " + grade + " \nId: #" + id);

    }

    public static void delete(HashMap<Integer, Estudiante> students, Scanner scanner) {
        if (!students.isEmpty()) {
            scanner.nextLine();
            System.out.println("Enter the name of Student for delete:");
            String nameDelete = scanner.nextLine();
            boolean deleted = false;
            for (Estudiante estudiante : students.values()) {
                if (estudiante.getName().equalsIgnoreCase(nameDelete)) {
                    deleted = true;
                }
            }
            if (deleted) {
                for (Map.Entry<Integer, Estudiante> estudianteEntry : students.entrySet()) {
                    Integer key = estudianteEntry.getKey();       // Obtener la clave
                    Estudiante value = estudianteEntry.getValue();    // Obtener el valor
                    students.remove(key);
                    details(students);
                    break;
                }
            } else
                System.out.println("The Student is invalid or not exists");
        } else {
            System.out.println("Not exists Students =(");
        }
    }

    public static void update(HashMap<Integer, Estudiante> students, Scanner scanner) {
        if (!students.isEmpty()) {
            scanner.nextLine();
            boolean find = false;
            System.out.println("Enter the name of Student to Update:");
            String nameSearchUpdate = scanner.nextLine();
            for (Estudiante estudiante : students.values()) {
                if (estudiante.getName().equalsIgnoreCase(nameSearchUpdate)) {
                    find = true;
                }
            }
            if (find) {
                System.out.println("Enter the Id of the Student for Update:");
                int idUpdate = scanner.nextInt();
                scanner.nextLine();
                if (students.containsKey(idUpdate)) {
                    System.out.println("Enter the new Name of the Student:");
                    String nameUpdate = scanner.nextLine();
                    System.out.println("Enter the new Grade of the Student:");
                    String gradeUpdate = scanner.nextLine();
                    Estudiante estudiante1 = new Estudiante(nameUpdate, gradeUpdate);
                    students.put(idUpdate, estudiante1);
                    details(students);
                } else
                    System.out.println("The Id is invalid or not exists");
            }
        } else {
            System.out.println("Not exists Students =(");
        }
    }

    public static void search(HashMap<Integer, Estudiante> students, Scanner scanner) {
        if (!students.isEmpty()) {
            scanner.nextLine();
            System.out.println("Enter the Student to search:");
            String searchStudent = scanner.nextLine();
            boolean search = false;
            for (Estudiante estudiante : students.values()) {
                if (estudiante.getName().equalsIgnoreCase(searchStudent)) {
                    search = true;
                }
            }
            if (search) {
                System.out.println("The Student: " + searchStudent + " yes exists");
            } else {
                System.out.println("The Student " + searchStudent + " not exists or invalid");
            }
        } else
            System.out.println("Not exists Students =(");
    }

    public static void details(HashMap<Integer, Estudiante> students) {
        if (!students.isEmpty()) {
            System.out.printf("%nThe Students are:");
            for (Estudiante details : students.values()) {
                System.out.printf("%n-Name: " + details.getName() + "%n-Grade: " + details.getGrade());
            }
        } else {
            System.out.printf("%nNot exists Students =(");
        }
        System.out.printf("%n");
    }
}
