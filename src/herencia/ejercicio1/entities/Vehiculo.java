package herencia.ejercicio1.entities;

public class Vehiculo {
    private int fecha;
    private String modelo;

    public Vehiculo(int fecha,String modelo){
        this.fecha = fecha;
        this.modelo = modelo;
    }
    public int getFecha() {
        return this.fecha;
    }
    public String getModelo(){
        return this.modelo;
    }

    public void detalles(){
        System.out.println("Los detalles del vehiculo son:");
        System.out.println(fecha+modelo);
    }
}