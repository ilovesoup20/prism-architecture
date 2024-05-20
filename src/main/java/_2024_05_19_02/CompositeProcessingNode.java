package _2024_05_19_02;

import _2024_05_19_02.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CompositeProcessingNode<T extends BaseContext> extends AbstractProcessingNode<T> {
    private final List<ProcessingNode<T>> children = new ArrayList<>();
    private final ExecutionMode executionMode;
    private final ExecutorService executorService;

    public CompositeProcessingNode(ExecutionMode executionMode, ExecutorService executorService) {
        this.executionMode = executionMode;
        this.executorService = executorService;
    }

    public void addChild(ProcessingNode<T> child) {
        children.add(child);
    }

    @Override
    public void process(Context<T> context) {
        if (executionMode == ExecutionMode.CONCURRENT) {
            List<Future<?>> futures = new ArrayList<>();
            for (ProcessingNode<T> child : children) {
                futures.add(executorService.submit(() -> child.process(context)));
            }
            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (ProcessingNode<T> child : children) {
                child.process(context);
            }
        }
        passToNext(context);
    }
}
