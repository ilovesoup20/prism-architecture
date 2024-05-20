package _2024_05_19_04_annotation.impl;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import _2024_05_19_04_annotation.Task;
import _2024_05_19_04_annotation.TaskChain;
import _2024_05_19_04_annotation.TaskProcessor;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.Format;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        OrderProcessingTasks orderProcessingTasks = new OrderProcessingTasks();
        TaskProcessor<OrderContext> taskProcessor = new TaskProcessor<>(executorService);

        Task<OrderContext> taskChain = taskProcessor.buildTaskChain(orderProcessingTasks);

        // Generate the visualization
        TaskChain<OrderContext> taskChainWrapper = new TaskChain<>(taskChain);
//        String dot = taskChainWrapper.visualize();
//        try {
//            Graphviz.fromString(dot).render(Format.PNG).toFile(new File("task-chain.png"));
//            System.out.println("Visualization generated: task-chain.png");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Example usage
        OrderContext orderContext = new OrderContext();
        orderContext.setOrder(new Order());
        taskChainWrapper.execute(orderContext);

        executorService.shutdown();
    }
}
