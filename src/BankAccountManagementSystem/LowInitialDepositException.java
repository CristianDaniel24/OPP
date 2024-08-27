package BankAccountManagementSystem;

public class LowInitialDepositException extends Exception {

    public LowInitialDepositException(String mensaje) {
        super(mensaje);
    }
}
