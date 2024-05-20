package _2024_05_19_04_annotation.impl;

import _2024_05_19_04_annotation.*;

public class OrderProcessingTasks {
    @TaskAction("validateOrder")
    public void validateOrder(OrderContext context) {
        System.out.println("Validating order: " + context.getOrder());
    }

    @TaskAction("checkInventory")
    public void checkInventory(OrderContext context) {
        System.out.println("Checking inventory for order: " + context.getOrder());
    }

    @TaskAction("processPayment")
    public void processPayment(OrderContext context) {
        System.out.println("Processing payment for order: " + context.getOrder());
    }

    @CompositeTaskAction(mode = ExecutionMode.CONCURRENT)
    public void concurrentTasks(CompositeTask<OrderContext> compositeTask) {
        compositeTask.addChild(new ActionTask<>(context -> {
            System.out.println("Concurrent task 1 for order: " + context.getOrder());
        }));
        compositeTask.addChild(new ActionTask<>(context -> {
            System.out.println("Concurrent task 2 for order: " + context.getOrder());
        }));
    }
}
