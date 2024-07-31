package dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PlayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> playList = new ArrayList<>();

        playList.add("song2");
        playList.add("song1");
        playList.add("song3");
        playList.add("song3");
        System.out.println("Current songs are:");
        for (String list : playList) {
            System.out.println(list);
        }
        boolean exit = false;
        while (!exit) {
            System.out.println("\nSongs Menu");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Search");
            System.out.println("4. Order");
            System.out.println("5. Deleted duplicate");
            System.out.println("6. Exit");
            System.out.println("Enter the option:");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    //ADD
                    add(playList, scanner);
                    break;
                case 2:
                    //REMOVE
                    delete(playList, scanner);
                    break;
                case 3:
                    //SEARCH
                    search(playList, scanner);
                    break;
                case 4:
                    //ORDER
                    order(playList);
                    break;
                case 5:
                    //DUPLICATE
                    duplicate(playList, scanner);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Enter the option invalid");
            }
        }
    }

    public static void add(ArrayList<String> playList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter the song for add");
        String add = scanner.nextLine();
        playList.add(add);
        System.out.println("The " + add + " was successfully add");
        System.out.println("\nThe remaining song are:");
        for (String adds : playList) {
            System.out.println(adds);
        }
    }

    public static void delete(ArrayList<String> playList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter the song to the remove");
        String remove = scanner.nextLine();
        if (playList.contains(remove)) {
            playList.remove(remove);
            System.out.println("The " + remove + " was successfully removed");
            System.out.println("\nThe remaining song are:");
            for (String delete : playList) {
                System.out.println(delete);
            }
        } else {
            System.out.println("The song is invalid or not exist");
        }
    }

    public static void search(ArrayList<String> playList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter your search:");
        String search = scanner.nextLine();

        if (playList.contains(search)) {
            System.out.println("The " + search + " yes exist in the list");
        } else {
            System.out.println("The " + search + " not exit in the list");
        }
    }

    public static void order(ArrayList<String> playList) {
        System.out.println("ORDER");
        Collections.sort(playList);
        System.out.println("Upward list");
        for (String arrayList : playList) {
            System.out.println(arrayList);
        }
        //FALLING
        playList.sort(Comparator.reverseOrder());
        System.out.println("\nFalling list");
        for (String arrayList : playList) {
            System.out.println(arrayList);
        }
    }

    public static void duplicate(ArrayList<String> playList, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter the song to the remove duplicate");
        String duplicate = scanner.nextLine();
        if (playList.contains(duplicate)) {
            playList.remove(duplicate);
            System.out.println("The " + duplicate + " duplicate was successfully removed");
            System.out.println("\nThe remaining song are:");
            for (String duplicates : playList) {
                System.out.println(duplicates);
            }
        } else {
            System.out.println("The song duplicate is invalid or not exist");
        }
    }
}