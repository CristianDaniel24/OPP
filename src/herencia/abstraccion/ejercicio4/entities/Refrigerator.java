package herencia.abstraccion.ejercicio4.entities;

public class Refrigerator extends Appliance{

    private int capacity;

    public Refrigerator(String marca, String modelo,int capacity){
        super(marca,modelo);
        this.capacity = capacity;
    }
    public void turnOn(){
        System.out.println("Encender");
    }
    public void turnOff(){
        System.out.println("Apagar");
    }
    public void displayDetails(){
        System.out.println("Los detalles del refrigerador son:"+
                "\nMarca: "+this.marca+
                "\nModelo: "+this.modelo+
                "\nCapacidad: "+this.capacity);
    }
}
