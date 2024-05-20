package _2024_05_19_04_annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CompositeTask<T extends BaseContext> extends AbstractTask<T> {
    private final List<Task<T>> children = new ArrayList<>();
    private final ExecutionMode executionMode;
    private final ExecutorService executorService;

    public CompositeTask(ExecutionMode executionMode, ExecutorService executorService) {
        this.executionMode = executionMode;
        this.executorService = executorService;
    }

    public void addChild(Task<T> child) {
        children.add(child);
    }

    @Override
    public void execute(T context) {
        if (executionMode == ExecutionMode.CONCURRENT) {
            List<Future<?>> futures = new ArrayList<>();
            for (Task<T> child : children) {
                futures.add(executorService.submit(() -> child.execute(context)));
            }
            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (Task<T> child : children) {
                child.execute(context);
            }
        }
        passToNext(context);
    }

    @Override
    public void visualize(StringBuilder sb, String parentId) {
        String taskId = Integer.toHexString(System.identityHashCode(this));
        sb.append(taskId).append(" [label=\"").append(this.getClass().getSimpleName()).append(" - ").append(executionMode).append("\"];\n");
        if (parentId != null) {
            sb.append(parentId).append(" -> ").append(taskId).append(";\n");
        }
        for (Task<T> child : children) {
            child.visualize(sb, taskId);
        }
        super.visualize(sb, taskId);
    }
}
