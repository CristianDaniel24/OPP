package dataStructures;

import java.util.Scanner;

public class IgualIgual2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String cadena1 = "Hello";
        String cadena2 = "Hello";

        if (cadena1 == cadena2) {
            System.out.println("Los textos son iguales");
        } else {
            System.out.println("Los textos no son iguales");
        }
    }
}
