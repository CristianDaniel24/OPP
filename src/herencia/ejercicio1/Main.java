package herencia.ejercicio1;

import herencia.ejercicio1.entities.Bicicleta;
import herencia.ejercicio1.entities.Coche;
import herencia.ejercicio1.entities.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Coche coche1 = new Coche(2005,"bmw");
            System.out.println("El coche es del " + coche1.getFecha()+" y su modelo es "+coche1.getModelo());
        coche1.detalles();
        Bicicleta bicicleta1 = new Bicicleta(2010, "Specialized");
        System.out.println("\nLa bicicleta es del " +bicicleta1.getFecha()+" y su modelo es "+bicicleta1.getModelo());
        bicicleta1.detalles();


    }
}