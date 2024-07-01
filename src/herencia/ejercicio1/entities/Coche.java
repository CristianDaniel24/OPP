package herencia.ejercicio1.entities;

public class Coche extends Vehiculo{
    int puertas = 4;

    public Coche(int fecha, String modelo){
        super(fecha, modelo);
    }

    @Override
    public void detalles() {
        System.out.println("El coche tiene " + this.puertas+ " puertas");
    }
}