package _20240518_01;

import java.util.concurrent.CompletableFuture;

public interface Task {
    <T>CompletableFuture<T> accept(TaskVisitor<T> visitor);
    TaskPredicate getPredicate();
}