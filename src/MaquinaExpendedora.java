package parte1;

import java.util.Arrays;
import java.util.Scanner;

class MaquinaExpendedora {
        // Attributes
        private String machineName;
        private String[] items;
        private double[] prices;

        // Constructor to initialize attributes
        public MaquinaExpendedora(String machineName,String[] items,double[] prices){
            this.machineName = machineName;
            this.items = items;
            this.prices = prices;
        }
        // Method to display available items and prices
        public void mostrarItems(String[] items){
            System.out.println("Los items de la maquina expendedora son:");
            for (int i = 0; i < items.length;i++) {
                System.out.println(items[i]);
            }
        }
        // Method to purchase an item
        public void comprarArticulo(String[] items,double[] prices){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nIngresa el articulo que deseas comprar");
            String articuloCompra = scanner.nextLine();
            if (this.items.equals(articuloCompra)){
                System.out.println("Realizando compra...");
            }else {
                System.out.println("El articulo ingresado no existe");
            }
            System.out.println("Ingrese el dinero");
            double dinero = scanner.nextDouble();
            double total = 0.0;
            if (this.prices.equals(dinero)){
                for (int i = 0; i < articuloCompra.length(); i++){
                    int posicion = articuloCompra.indexOf(items[i]);
                    total -= prices[posicion];
                }
                System.out.println("Compra realizada con exito");
                System.out.println("Su cambio es de: "+prices);
            }else{
                System.out.println("El dinero ingresado es insuficiente");
            }
        }
        // Method to display machine details
        public void detalles(){
            System.out.println("El nombre de la maquina es: "+machineName);
            System.out.println("Los productos disponibles son");
            for (int i = 0; i < items.length;i++) {
                System.out.println((items[i]));
            }
        }
    }