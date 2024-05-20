package _2024_05_19_05_input_output.actions;

import _2024_05_19_05_input_output.impl.OrderContext;

import java.util.function.Function;

public class OrderValidationAction implements Function<OrderContext, Boolean> {
    @Override
    public Boolean apply(OrderContext context) {
        System.out.println("Validating order: " + context.getOrder());
        return true; // Assume validation passed
    }
}
