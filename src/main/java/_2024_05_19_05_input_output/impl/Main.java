package _2024_05_19_05_input_output.impl;

import _2024_05_19_05_input_output.*;
import _2024_05_19_05_input_output.actions.InventoryCheckAction;
import _2024_05_19_05_input_output.actions.OrderValidationAction;
import _2024_05_19_05_input_output.actions.PaymentProcessingAction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//        TaskChainBuilder<OrderContext, Boolean, GenericContext> builder = new TaskChainBuilder<>(executorService);
//        TaskChain<OrderContext, Boolean, GenericContext> taskChain = builder
//                .addSequentialTask(new ActionTask<>(new OrderValidationAction()))
//                .addCompositeTask(ExecutionMode.CONCURRENT, compositeTask -> {
//                    compositeTask.addChild(new ActionTask<>(new InventoryCheckAction()));
//                    compositeTask.addChild(new ActionTask<>(context -> {
//                        System.out.println("Another composite task..");
//                        return "Concurrent result";
//                    }));
//                })
//                .addSequentialTask(new ActionTask<>(new PaymentProcessingAction()))
//                .build();
//
//        TaskChain<OrderContext, Boolean, GenericContext> taskChainWrapper = new TaskChain<>(taskChain);
//
//
//        OrderContext orderContext = new OrderContext();
//        GenericContext context = new GenericContext();
//
//        taskChainWrapper.execute(orderContext, context);
//
//        executorService.shutdown();
    }
}
