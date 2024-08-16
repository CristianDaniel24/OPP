package HackerRankPractica;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int num = scanner.nextInt();
            numbers.add(num);
        }
        int sum = 0;
        for (Integer numer : numbers) {
            sum += numer;
        }
        System.out.println(sum);
    }
}
