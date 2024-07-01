package herencia.ejercicio1.entities;

public class Bicicleta extends Vehiculo {
    String pitido = "si";

    public Bicicleta(int fecha, String modelo){
         super(fecha, modelo);
    }

    @Override
    public void detalles() {
        System.out.println("La bicicleta " + this.pitido + " tiene pitido");
    }
}