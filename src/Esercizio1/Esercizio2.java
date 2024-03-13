package Esercizio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio2 {

    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1L, "Disponibile", LocalDate.now(), LocalDate.now(),
                List.of(new Product(1L, "Ciuccio", "Baby", 5.0)), new Customer(1L, "Marco", 3)));

        List<Order> babyOrders = orderList.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals("Baby")))
                .collect(Collectors.toList());

        System.out.println("Ordini con prodotti nella categoria Baby:");
        for (Order order : babyOrders) {
            System.out.println("Order ID: " + order.getId());
            System.out.println("Status: " + order.getStatus());
        }
    }
}



