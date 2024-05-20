package _20240519_02.impl;

import java.util.function.Consumer;

public class InventoryCheckAction implements Consumer<OrderContext> {
    @Override
    public void accept(OrderContext context) {
        // Inventory check logic
        System.out.println("Checking inventory for order: " + context.getOrder());
    }
}