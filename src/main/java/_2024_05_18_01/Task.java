package _2024_05_18_01;

import java.util.concurrent.CompletableFuture;

public interface Task {
    <T>CompletableFuture<T> accept(TaskVisitor<T> visitor);
    TaskPredicate getPredicate();
}