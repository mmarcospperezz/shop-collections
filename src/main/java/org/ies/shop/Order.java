package org.ies.shop;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private LocalDate date;
    private double price;
    private List<Item> items;

}
