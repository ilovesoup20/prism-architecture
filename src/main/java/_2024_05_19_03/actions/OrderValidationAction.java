package _2024_05_19_03.actions;

import _2024_05_19_03.impl.OrderContext;

import java.util.function.Consumer;

public class OrderValidationAction implements Consumer<OrderContext> {
    @Override
    public void accept(OrderContext context) {
        // Validate order logic
        System.out.println("Validating order: " + context.getOrder());
    }
}