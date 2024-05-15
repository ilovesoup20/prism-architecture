package basic;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        Predicate<Context> isUserLoggedIn = context -> context.isUserLoggedIn();
        Predicate<Context> hasSufficientBalance = context -> context.getBalance() >= context.getRequiredAmount();

        Consumer<Context> processPayment = context -> {
            // insert logic
        };

        Consumer<Context> sendNotification = context -> {
            // insert logic
        };

        Node paymentNode = new ConcreteNode(hasSufficientBalance, processPayment, List.of(new ConcreteNode()));
        Node notificationNode = new ConcreteNode(context -> true, sendNotification, List.of(new ConcreteNode()));

        Graph businessLogicGraph = new Graph(paymentNode);
        Context context = new Context();
        businessLogicGraph.execute(context);
    }
}
