package _2024_05_19_05_input_output.actions;

import java.util.function.Function;

public class PaymentProcessingAction implements Function<Integer, String> {
    @Override
    public String apply(Integer stockCount) {
        if (stockCount > 0) {
            System.out.println("Processing payment...");
            return "Payment Successful";
        }
        return "Payment Failed";
    }
}