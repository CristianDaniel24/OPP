package dataStructures;

import java.util.Scanner;

public class Or {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBIENVENIDO A SU RESTAURANTE DE CONFIANZA");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu del dia:");
            System.out.println("1. pasta y caldo");
            System.out.println("2. bandeja paisa y caldo");
            System.out.println("3. Exit");
            System.out.println("Ingrese una opcion:");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¿Deseas la pasta?true/false");
                    boolean ordenPasta = scanner.nextBoolean();
                    System.out.println("¿Desea el caldo?true/false");
                    boolean ordenPastaCaldo = scanner.nextBoolean();
                    if (ordenPasta || ordenPastaCaldo)
                        System.out.println("Realizando pedido..");
                    else {
                        System.out.println("Pedido no disponible o invalido");
                    }
                    return;
                case 2:
                    System.out.println("¿Desea pedir la bandeja paisa?");
                    boolean ordenBandejaPaisa = scanner.nextBoolean();
                    System.out.println("¿Deseas pedirla con un caldo?");
                    boolean ordenBandejaCaldo = scanner.nextBoolean();
                    if (ordenBandejaPaisa || ordenBandejaCaldo)
                        System.out.println("Realizando pedido..");
                    else
                        System.out.println("Pedido agotado o invalido");
                    return;
                case 3:
                    exit = true;
                    return;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}