package functional;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        Predicate<Context> isUserLoggedIn = context -> context.isUserLoggedIn();
        Predicate<Context> hasSufficientBalance = context -> context.getBalance() >= context.getRequiredAmount();

        Function<Context, Context> processPayment = context -> {
            return context.withUpdatedState();
        };

        Function<Context, Context> sendNotification = context -> {
            return context.withUpdatedState();
        };

        Node paymentNode = new FunctionalNode(hasSufficientBalance, processPayment, List.of(new FunctionalNode()));
        Node notificationNode = new FunctionalNode(context -> true, sendNotification, List.of(new FunctionalNode()));

        Graph businessLogicGraph = new Graph(paymentNode);
        Context context = new Context();
        Context resultContext = businessLogicGraph.execute(context);
    }
}
