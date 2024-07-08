package herencia.abstraccion.ejercicio2.entities;

public class CreditCardPayment extends Payment{
    private String cardNumber;
    private String cardHolderName;

public CreditCardPayment(Double coste, String cardNumber,String cardHolderName){
    super(coste);
    this.cardNumber = cardNumber;
    this.cardHolderName = cardHolderName;
}

    public void processPayment(){
        System.out.println("Procesando Pago...");
}
    public void displayPaymentDetails(){
        System.out.println("Los datos del usuario son:"+
                "\nNombre del titular: "+cardHolderName+
                "\nNumero de tarjeta: "+cardNumber+
                "\nDinero: "+monto);
    }
}
