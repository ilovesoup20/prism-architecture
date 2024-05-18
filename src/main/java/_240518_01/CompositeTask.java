package _240518_01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompositeTask implements Task, Iterable<Task> {
    private final List<Task> tasks = new ArrayList<>();
    private final TaskPredicate predicate;

    public CompositeTask(TaskPredicate predicate) {
        this.predicate = predicate;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public <T> CompletableFuture<T> accept(TaskVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public TaskPredicate getPredicate() {
        return this.predicate;
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
