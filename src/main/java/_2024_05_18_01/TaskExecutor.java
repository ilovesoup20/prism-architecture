package _2024_05_18_01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TaskExecutor implements TaskVisitor<String> {
    @Override
    public CompletableFuture<String> visit(SimpleTask task) {
        if (task.getPredicate().test(task)) {
            return CompletableFuture.supplyAsync(() -> {
                sleep(1000);
                return task.getName();
            });
        }
        return CompletableFuture.completedFuture("");
    }

    @Override
    public CompletableFuture<String> visit(CompositeTask compositeTask) {
        List<CompletableFuture<String>> futures = new ArrayList<>();
        for (Task task : compositeTask) {
            futures.add(task.accept(this));
        }

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .filter(result -> !result.isEmpty())
                        .reduce((a, b) -> a + " & " + b)
                        .orElse("")
                );
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
