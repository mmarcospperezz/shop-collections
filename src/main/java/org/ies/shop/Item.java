package org.ies.shop;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private int productId;
    private int amount;
}
