package _2024_05_19_03.impl;

import _2024_05_19_03.ActionChain;
import _2024_05_19_03.ActionChainBuilder;
import _2024_05_19_03.ExecutionMode;
import _2024_05_19_03.LeafAction;
import _2024_05_19_03.actions.InventoryCheckAction;
import _2024_05_19_03.actions.OrderValidationAction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);

        ActionChainBuilder<OrderContext> builder = new ActionChainBuilder<>(es);

        ActionChain<OrderContext> chain = builder
                .addSequentialAction(new LeafAction<>(new OrderValidationAction()))
                .addCompositeAction(ExecutionMode.CONCURRENT, compositeAction -> {
                    compositeAction.addChild(new LeafAction<>(new InventoryCheckAction()));
                    compositeAction.addChild(new LeafAction<>(context -> {
                        // Do something..
                        System.out.println("Another composite action");
                    }));
                })
                .addSequentialAction(new LeafAction<>(context -> {
                    // Final action
                    System.out.println("Final action");
                }))
                .build();

        OrderContext orderContext = new OrderContext();
        orderContext.setOrder(new Order());
        chain.process(orderContext);
        es.shutdown();
    }
}
