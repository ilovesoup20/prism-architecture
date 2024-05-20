package _2024_05_19_03.actions;

import _2024_05_19_03.impl.OrderContext;

import java.util.function.Consumer;

public class InventoryCheckAction implements Consumer<OrderContext> {
    @Override
    public void accept(OrderContext context) {
        // Inventory check logic
        System.out.println("Checking inventory for order: " + context.getOrder());
    }
}