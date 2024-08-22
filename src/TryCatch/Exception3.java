package TryCatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exception3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter the number:");
            String input = reader.readLine();
            int number = Integer.parseInt(input);
            System.out.println("\nThe number " + number + " has been converted successfully");
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid number format. Please enter a valid integer.");
        }
    }
}
