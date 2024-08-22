package TryCatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exception2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] number = new int[5];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < number.length; i++) {
            String index = reader.readLine();
            number[i] = Integer.parseInt(index);
        }
        System.out.println("\nThe numbers in the array are");
        for (int numbers : number) {
            System.out.println(numbers);
        }
        try {
            System.out.println("\nEnter the index to Array:");
            String indexReader = reader.readLine();
            int index = Integer.parseInt(indexReader);
            for (int i = 0; i < number.length; i++) {
                System.out.println(number[index]);
                break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nIndex out of bounds. Please enter a valid index");
        }
    }
}
