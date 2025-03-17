package org.ies.shop;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.text.html.HTML;
import java.util.Set;
import java.util.TreeSet;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private double price;
    private Set<String> tags;
}
