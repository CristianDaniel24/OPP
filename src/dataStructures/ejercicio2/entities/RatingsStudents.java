package dataStructures.ejercicio2.entities;

import java.util.ArrayList;
import java.util.Scanner;

public class RatingsStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number to the Students: ");
        int size = scanner.nextInt();

        Student[] students = new Student[size];

        ArrayList<Student> studentArrayList = new ArrayList<>();
        //ADD
        add(studentArrayList, size, scanner);

        //HIGHEST NOTE
        higehstNote(studentArrayList);

        //CONVERT ARRAY TO ARRAYLIST
        //=(

        //DELETE DUPLICATES
        deleteNotes(students, studentArrayList, scanner);
    }

    public static void add(ArrayList<Student> studentArrayList, int size, Scanner scanner) {
        //ADD STUDENTS
        for (int i = 0; i < size; i++) {
            scanner.nextLine();
            System.out.println("Enter the name to the Student:");
            String name = scanner.nextLine();
            System.out.print("Enter the note: ");
            Double note = scanner.nextDouble();
            Student student = new Student(name, note);
            studentArrayList.add(student);
        }

        System.out.println("\nThe students and notes are:");
        for (Student studentss : studentArrayList) {
            System.out.println(studentss.getNombre() + " - " + studentss.getRatings());
        }
    }

    public static void higehstNote(ArrayList<Student> studentArrayList) {
        double noteMaximum = 0;
        String nameNoteMaxium = "";

        for (Student studentss : studentArrayList) {
            if (studentss.getRatings() > noteMaximum) {
                noteMaximum = studentss.getRatings();
                nameNoteMaxium = studentss.getNombre();
            }
        }
        System.out.println("\nThe Student " + nameNoteMaxium + " it has the highest note, and it is: " + noteMaximum);
    }

    public static void deleteNotes(Student[] student, ArrayList<Student> studentArrayList, Scanner scanner) {
        System.out.println("\nDELETED THE STUDENT");
        System.out.println("List to the Students:");
        for (Student studentss : studentArrayList) {
            System.out.println(studentss.getNombre() + " - " + studentss.getRatings());
        }
        scanner.nextLine();
        System.out.println("\nEnter the Student duplicate for delete:");
        String nameDelete = scanner.nextLine();
        for (Student studentss : studentArrayList) {
            if (studentss.getNombre().equalsIgnoreCase(nameDelete)) {
                studentArrayList.remove(nameDelete);
                System.out.println("The note duplicate he delete successfully");
                System.out.println("\nThe remaining Students are:");
                for (Student students : studentArrayList) {
                    System.out.println(students.getNombre() + " - " + students.getRatings());
                    break;
                }
            } else {
                System.out.println("The Student enter is invalid");
                break;
            }
        }
    }

}