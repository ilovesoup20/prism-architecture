package _20240519_02.impl;
import _20240519_02.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class OrderProcessingSetup {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        ProcessingChainBuilder<OrderContext> builder = new ProcessingChainBuilder<>(executorService);
        ProcessingChain<OrderContext> processingChain = builder
                .addSequentialNode(new LeafProcessingNode<>(new OrderValidationAction()))
                .addCompositeNode(ExecutionMode.CONCURRENT, compositeNode -> {
                    compositeNode.addChild(new LeafProcessingNode<>(new InventoryCheckAction()));
                    compositeNode.addChild(new LeafProcessingNode<>(context -> {
                        System.out.println("Another concurrent action for order: " + context.getOrder());
                    }));
                })
                .addSequentialNode(new LeafProcessingNode<>(new PaymentProcessingAction()))
                .build();

        // Example usage
        OrderContext orderContext = new OrderContext();
        orderContext.setOrder(new Order());
        processingChain.process(orderContext);

        executorService.shutdown();
    }
}
