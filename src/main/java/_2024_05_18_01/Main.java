package _20240518_01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException, ExecutionException {
        TaskPredicate alwaysTrue = task -> true;
        TaskPredicate containsOne = task -> task instanceof SimpleTask && ((SimpleTask) task).getName().contains("1");

        SimpleTask task1 = new SimpleTask("Task 1", alwaysTrue);
        SimpleTask task2 = new SimpleTask("Task 2", alwaysTrue);
        SimpleTask task3 = new SimpleTask("Task 3", containsOne);
        SimpleTask task4 = new SimpleTask("Task 4", alwaysTrue);

        CompositeTask serialTasks = new CompositeTask(alwaysTrue);
        serialTasks.addTask(task1);
        serialTasks.addTask(task2);

        CompositeTask concurrentTasks = new CompositeTask(alwaysTrue);
        concurrentTasks.addTask(task3);
        concurrentTasks.addTask(task4);

        CompositeTask allTasks = new CompositeTask(alwaysTrue);
        allTasks.addTask(serialTasks);
        allTasks.addTask(concurrentTasks);

        TaskExecutor executor = new TaskExecutor();
        CompletableFuture<String> result = allTasks.accept(executor);

        System.out.println(result.get());
    }
}
