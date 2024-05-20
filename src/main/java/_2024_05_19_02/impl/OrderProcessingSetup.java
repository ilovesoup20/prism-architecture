package _2024_05_19_02.impl;
import _2024_05_19_02.*;
import _2024_05_19_02.nodes.InventoryCheckNode;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class OrderProcessingSetup {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        ProcessingChainBuilder<OrderContext> builder = new ProcessingChainBuilder<>(executorService);
        ProcessingChain<OrderContext> processingChain = builder
                .addSequentialNode(new LeafProcessingNode<>(new OrderValidationAction()))
                .addSequentialNode(InventoryCheckNode.newInstance())
                .addCompositeNode(ExecutionMode.CONCURRENT, compositeNode -> {
                    compositeNode.addChild(new LeafProcessingNode<>(new InventoryCheckAction()));
                    compositeNode.addChild(new LeafProcessingNode<>(context -> {
                        System.out.println("1. Concurrent action for order: " + context.getOrder());
                    }));
                    compositeNode.addChild(new LeafProcessingNode<>(context -> {
                        System.out.println("2. Concurrent action for order: " + context.getOrder());
                    }));
                    compositeNode.addChild(new LeafProcessingNode<>(context -> {
                        System.out.println("3. Concurrent action for order: " + context.getOrder());
                    }));

                })
                .addSequentialNode(new LeafProcessingNode<>(new PaymentProcessingAction()))
                .addCompositeNode(ExecutionMode.CONCURRENT, compositeNode -> {
                    compositeNode.addChild(new LeafProcessingNode<>(context -> {
                        System.out.println("4. Concurrent action for order: " + context.getOrder());
                    }));
                    compositeNode.addChild(new LeafProcessingNode<>(context -> {
                        System.out.println("5. Concurrent action for order: " + context.getOrder());
                    }));

                })
                .build();

        // Example usage
        OrderContext orderContext = new OrderContext();
        orderContext.setOrder(new Order());
        processingChain.process(orderContext);

        executorService.shutdown();
    }
}
