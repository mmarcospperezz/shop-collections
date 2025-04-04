package org.ies.shop;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Data
@AllArgsConstructor
public class Shop {
    private String name;
    private Map<Integer, Product> productsById;
    private TreeSet<Customer> customers;

    public Customer findCustomer(String nif){
        for(Customer customer : customers){
            if(customer.getNif().equals(nif)){
                return customer;
            }
        } return null;
    }

    public Order orderByCustomer(String nif,  int orderId) {
        for (Customer customer : customers) {
            if (customer.getNif().equals(nif)) {
                return customer.findOrder(orderId);
            }
        }
        return null;
    }

    public List<Product> findOrderProducts(String nif, int orderId){
        Order order = orderByCustomer(nif, orderId);
        if(order != null){
            List<Product> products = new ArrayList<>();
            for(Item item : order.getItems()){
                Product product = productsById.get(item.getProductId());
                products.add(product);
            }
            return products;
        } else {
            return null;
        }
    }

    public List<Product> findProductsByTag(String tag) {
        List<Product> productsWithTag = new ArrayList<>();
        for (Product product : productsById.values()) {
            if (product.getTags().contains(tag)) {
                productsWithTag.add(product);
            }
        }
        return productsWithTag;
    }

    public double getTotalSpentByCustomer(String nif) {
        Customer customer = findCustomer(nif);
        if (customer == null) {
            return 0.0; // Customer not found, spent 0
        }

        double totalSpent = 0.0;
        for (Order order : customer.getOrders()) {
            totalSpent += order.getPrice();
        }
        return totalSpent;
    }


}
