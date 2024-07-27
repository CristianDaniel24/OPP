package dataStructures;

import java.util.Scanner;

public class Negacion2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = 5;

        if (!(numero < 0)) {
            System.out.println("El numero no es negativo");
        } else {
            System.out.println("El numero es negativo");
        }
    }
}
