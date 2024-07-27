package dataStructures;

import java.util.Scanner;

public class And2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();

        System.out.println("¿Eres mayor de edad?true/false");
        boolean mayorEdad = scanner.nextBoolean();

        System.out.println("¿Tienes licencia para conducir?true/false");
        boolean licencia = scanner.nextBoolean();

        if (mayorEdad && licencia){
            System.out.println(nombre+" puedes conducir");
        }else {
            System.out.println(nombre+" no puedes conducir");
        }
    }
}
