package org.HW_211223.task_4.product;

public class ProductPart {
    private static int productPartCount = 0;

    private final int productPartID;

    public ProductPart() {
        this.productPartID = productPartCount++;
    }

    public int getProductPartID() {
        return productPartID;
    }
}
