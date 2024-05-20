package _2024_05_18_01;

import java.util.concurrent.CompletableFuture;

public class SimpleTask implements Task{
    private final String name;
    private final TaskPredicate predicate;

    public SimpleTask(String name, TaskPredicate predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    @Override
    public <T> CompletableFuture<T> accept(TaskVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public TaskPredicate getPredicate() {
        return this.predicate;
    }

    public String getName() {
        return name;
    }
}
