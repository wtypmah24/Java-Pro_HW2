package org.HW_191223.task_2.product;

import org.HW_191223.task_2.id.generator.UniqueIdGenerator;

public class Product {
    private  int productId;

    public Product() {
        this.productId = UniqueIdGenerator.generateUniqueId();
    }

    public int getProductId() {
        return productId;
    }
}
