package dataStructures;

import java.util.Scanner;

public class NegacionIgual2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        char letra = 'x';

        if (letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u') {
            System.out.println("La letra no es una vocal");
        } else {
            System.out.println("La letra si es una vocal");
        }
    }
}
