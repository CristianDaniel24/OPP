package dataStructures;

import java.util.Scanner;

public class Or2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("BIENVENIDO A SU TIENDA DE JUEGOS DE CONFIANZA");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nLista de productos:");
            System.out.println("1. Consola xbox con/sin juegos");
            System.out.println("2. Consola PlayStation con/sin juegos");
            System.out.println("3. Exit");
            System.out.println("Ingrese una opcion:");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¿Deseas ordenar una consola xbox con juegos incluidos?true/false");
                    boolean juegosXboxSi = scanner.nextBoolean();
                    System.out.println("¿Tienes tarjeta de descuento?");
                    boolean tarjetaXbox = scanner.nextBoolean();
                    if (juegosXboxSi || tarjetaXbox){
                        System.out.println("Realizando pedido..");
                    }else {
                        System.out.println("Pedido invalido");
                    }
                    return;
                case 2:
                    System.out.println("¿Deseas ordenar una playStation con juegos incluidos?true/false");
                    boolean juegosPlayStationSi = scanner.nextBoolean();
                    System.out.println("¿Tienes tarjeta de descuento?");
                    boolean tarjetaPlay = scanner.nextBoolean();
                    if (juegosPlayStationSi || tarjetaPlay){
                        System.out.println("Realizando pedido..");
                    }else {
                        System.out.println("Pedido invalido");
                    }
                    return;
                case 3:
                    exit = true;
                    return;
                default:
                    System.out.println("La opcion ingresada es invalida");
            }
        }
    }
}