package org.ies.shop;

import lombok.AllArgsConstructor;
import lombok.Data;

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


}
