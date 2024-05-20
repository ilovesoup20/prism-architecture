package _2024_05_19_03.actions;

import _2024_05_19_03.impl.OrderContext;

import java.util.function.Consumer;

public class PaymentProcessingAction implements Consumer<OrderContext> {
    @Override
    public void accept(OrderContext context) {
        // Process payment logic
        System.out.println("Processing payment for order: " + context.getOrder());
    }
}