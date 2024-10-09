package Streams.Sorted;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(9, 6, 5, 3, 7, 2, 1);

        List<Integer> numbersOrder = numbers.stream()
                .sorted() //Orden ascendente
                .collect(Collectors.toList());
        System.out.println(numbersOrder);
    }
}
