package herencia.polimorfismo.ejercicio2.entities;

public class Computador {
    protected String marca;
    protected int año;
    protected Double coste;

    public Computador(String marca, int año, Double coste){
        this.marca = marca;
        this.año = año;
        this.coste = coste;
    }
    public String getMarca(){
        return marca;
    }
    public int getAño(){
        return año;
    }
    public Double getCoste(){
        return coste;
    }
    public Double calcularValor(){
        Double porcentaje = this.coste * 0.5;
        return porcentaje;
    }
    public String detallesComputador(){
        return "Los detalles del computador base son:"+
                "\nMarca: "+this.marca+
                "\nAño: "+this.año+
                "\nCoste general: "+this.coste;
    }
}
