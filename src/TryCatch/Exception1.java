package TryCatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exception1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number 1");
        String input1 = reader.readLine();
        int number1 = Integer.parseInt(input1);
        System.out.println("Enter the number 2");
        String input2 = reader.readLine();
        int number2 = Integer.parseInt(input2);

        int reult = 0;
        try {
            reult = number1 / number2;
            System.out.println("The result is: " + reult);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is not allowed");
        }
    }
}
