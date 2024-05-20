package _2024_05_18_01;

import java.util.concurrent.CompletableFuture;

public interface TaskVisitor<T> {
    CompletableFuture<T> visit(SimpleTask task);
    CompletableFuture<T> visit(CompositeTask task);
}
