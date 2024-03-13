package Esercizio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Libro1", "Libri", 149.99));
        productList.add(new Product(2L, "Libro2", "Libri", 90.0));
        productList.add(new Product(3L, "Pantaloni", "Boys", 39.99));
        productList.add(new Product(4L, "Frigorifero", "Elettrodomestici", 197.10));

        productList.stream()
                .filter(product -> product.getCategory().equals("Libri") && product.getPrice() > 100)
                .forEach(product -> System.out.println(product.getName() + " - " + product.getPrice()));

            List<Product> boysProduct = productList.stream()
                    .filter(product -> product.getCategory().equals("Boys"))
                    .collect(Collectors.toList());

            boysProduct.forEach(product -> product.applyDiscount(10.0));

            System.out.println("Prodotti nella categoria boys Boys scontati del 10%: ");
            for (Product product : boysProduct) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
    }
}
