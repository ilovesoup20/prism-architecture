package _2024_05_19_02.impl;

import java.util.function.Consumer;

public class OrderValidationAction implements Consumer<OrderContext> {
    @Override
    public void accept(OrderContext context) {
        // Validate order logic
        System.out.println("Validating order: " + context.getOrder());
    }
}