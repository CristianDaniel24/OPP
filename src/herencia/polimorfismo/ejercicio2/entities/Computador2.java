package herencia.polimorfismo.ejercicio2.entities;

public class Computador2 extends Computador{
    private String color;

    public Computador2(String marca,int año, String color, Double coste){
        super(marca,año,coste);
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    @Override
    public Double calcularValor(){
        Double porcentaje = this.getCoste() + this.getCoste() * 0.2;
        return porcentaje;
    }
    @Override
    public String detallesComputador(){
        return "Detalles del computador Vivobook-pro son:"+
                "\nMarca: "+this.marca+
                "\nAño: "+this.año+
                "\nColor: "+this.color+
                "\nCoste total: "+calcularValor();
    }
}
