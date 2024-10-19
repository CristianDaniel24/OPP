package Streams.practice.practice2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> textLine = Files.readAllLines(Paths.get("src/Streams/practice/practice2/Product"));

        List<Product> products = textLine.stream()
                .map(p -> {
                    String[] data = p.split(", ");
                    return new Product(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                })
                .toList();

        Map<String, Double> productsGroup = products.stream()
                .collect(Collectors.groupingBy(Product::getName, Collectors.summingDouble(Product::getQuantity)));

        productsGroup.forEach((name, total) -> {
            System.out.printf("\nProduct: \nName: %s\nTotal: $%f\n", name, total);
        });

        Optional highest = productsGroup.values().stream()
                .reduce((p1, p2) -> p1 > p2 ? p1 : p2);

        if (highest.isPresent()) {
            System.out.println("\nThe number highest is: " + highest.get());
        } else {
            System.out.println("\nError, values were not found =(");
        }
    }
}
