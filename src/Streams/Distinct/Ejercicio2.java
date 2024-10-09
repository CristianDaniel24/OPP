package Streams.Distinct;

import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Java", "Streams", "ForEach", "Streams", "Java");

        List<String> newWords = words.stream()
                .distinct()
                .toList();

        System.out.println(newWords);
    }
}
