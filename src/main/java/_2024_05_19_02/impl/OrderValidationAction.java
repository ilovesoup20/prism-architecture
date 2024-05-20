package _20240519_02.impl;

import _20240519_02.Context;

import java.util.function.Consumer;

public class OrderValidationAction implements Consumer<OrderContext> {
    @Override
    public void accept(OrderContext context) {
        // Validate order logic
        System.out.println("Validating order: " + context.getOrder());
    }
}