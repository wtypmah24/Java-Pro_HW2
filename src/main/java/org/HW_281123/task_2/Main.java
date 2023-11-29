package org.HW_281123.task_2;

import org.HW_281123.task_2.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /*
     * Создайте класс Item с полями названия товара и стоимости товара.
     * Создайте мапу, хранящую товар и соответствующее ему число единиц товара.
     * С помощью метода forEach получите все товары, у которых осталось меньше 3 штук.*/
    public static void main(String[] args) {
        Item product1 = new Item("Phone", 10);
        Item product2 = new Item("Toaster", 2);
        Item product3 = new Item("Camera", 4);
        Item product4 = new Item("Watch", 1);

        Map<String, Integer> productToQuantity = new HashMap<>();

        productToQuantity.put(product1.name(), product1.quantity());
        productToQuantity.put(product2.name(), product2.quantity());
        productToQuantity.put(product3.name(), product3.quantity());
        productToQuantity.put(product4.name(), product4.quantity());

        System.out.println(getLimitedItems(productToQuantity));
    }

    private static List<String> getLimitedItems(Map<String, Integer> products) {
        List<String> limitedProducts = new ArrayList<>();
        products.forEach((k, v) -> {
            if (v < 3) limitedProducts.add(k);
        });
        return limitedProducts;
    }
}
