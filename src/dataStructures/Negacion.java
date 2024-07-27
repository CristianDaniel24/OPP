package dataStructures;

import java.util.Scanner;

public class Negacion {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String texto = "Hello World";

        if (!texto.isEmpty()) {
            System.out.println("El texto no esta vacío");
        } else {
            System.out.println("El texto esta vacio");
        }
    }
}
