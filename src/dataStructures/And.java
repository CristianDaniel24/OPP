package dataStructures;

import java.util.Scanner;

public class And {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
    /*
    AND = &&
    OR = ||
    !! = !
     */
            System.out.println("Enter the year:");
            int minimumAge = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the city:");
            String city = scanner.nextLine();

            if (minimumAge >= 18 && city.equalsIgnoreCase("Bogota")){
                System.out.println("Puedes votar");
            }else {
                System.out.println("No puedes votar");
            }
        }
    }