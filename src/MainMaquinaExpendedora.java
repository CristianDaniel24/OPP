package parte1;

import java.util.Scanner;

public class MainMaquinaExpendedora {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Define items and prices
            String[] items = {"soda", "chips", "candy"};
            double[] prices = {1.50, 2.00, 1.25};
            System.out.println("Ingresa el nombre de la maquina expendedora:");
            String machineName = scanner.nextLine();
            // Create a VendingMachine object
            MaquinaExpendedora expendedora = new MaquinaExpendedora(machineName,items,prices);
            // Display initial machine details
            expendedora.mostrarItems(items);
            // Purchase an item
            expendedora.comprarArticulo(items,prices);
            expendedora.detalles();
        }
    }
