package _2024_05_19_05_input_output.actions;

import java.util.function.Function;

public class InventoryCheckAction implements Function<Boolean, Integer> {
    @Override
    public Integer apply(Boolean validationPassed) {
        if (validationPassed) {
            System.out.println("Checking inventory...");
            return 10; // Assume 10 items in stock
        }
        return 0;
    }
}