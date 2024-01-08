package org.HW_211223.task_4;

import org.HW_211223.task_4.product.ProductPart;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Conveyor {
    /*
     * На производственной линии роботы выполняют
     * несколько этапов обработки продукции.
     * Используйте CyclicBarrier, чтобы синхронизировать
     * работу роботов и переходить к следующему этапу после завершения предыдущего.*/

    private static final int TOTAL_PRODUCTION_STAGE = 3;
    private static final int PRODUCT_PARTS_COUNT = 3;
    private static final CyclicBarrier barrier = new CyclicBarrier(PRODUCT_PARTS_COUNT);

    public static void main(String[] args) {


        Arrays.stream(new int[PRODUCT_PARTS_COUNT]).mapToObj(e -> new Thread(() -> {
            ProductPart productPart = new ProductPart();
            System.out.println("Part: " + productPart.getProductPartID() + " started production.");

            for (int stage = 1; stage <= TOTAL_PRODUCTION_STAGE; stage++) {
                System.out.println("Part: "+ productPart.getProductPartID() + " on the stage: " + stage);
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException ex) {
                    throw new RuntimeException(ex);
                }
            }

            System.out.println("Part: " + productPart.getProductPartID() + " is ready!");
        })).forEach(Thread::start);
    }
}
