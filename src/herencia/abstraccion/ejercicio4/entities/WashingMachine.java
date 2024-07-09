package herencia.abstraccion.ejercicio4.entities;

public class WashingMachine extends Appliance{

    private int loadCapacity;

    public WashingMachine(String marca, String modelo,int loadCapacity){
        super(marca,modelo);
        this.loadCapacity = loadCapacity;
    }
    public void turnOn(){
        System.out.println("Encender");
    }
    public void turnOff(){
        System.out.println("Apagar");
    }
    public void displayDetails(){
        System.out.println("Los detalles de la lavadora son:"+
                "\nMarca: "+this.marca+
                "\nModelo: "+this.modelo+
                "\nCapacidad: "+this.loadCapacity);
    }
}
