package _2024_05_19_05_input_output;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CompositeTask<I, O, C extends BaseContext> extends AbstractTask<I, O, C> {
    private final List<Task<I, O, C>> children = new ArrayList<>();
    private final ExecutionMode executionMode;
    private final ExecutorService executorService;

    public CompositeTask(ExecutionMode executionMode, ExecutorService executorService) {
        this.executionMode = executionMode;
        this.executorService = executorService;
    }

    public void addChild(Task<I, O, C> child) {
        children.add(child);
    }

    @Override
    public O execute(I input, C context) {
        if (executionMode == ExecutionMode.CONCURRENT) {
            List<Future<O>> futures = new ArrayList<>();
            for (Task<I, O, C> child : children) {
                Future<O> fut = executorService.submit(() -> child.execute(input, context));
                futures.add(fut);
            }

            for (Future<O> future : futures) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    // TODO: do something
                    e.printStackTrace();
                }
            }
        } else {
            for (Task<I, O, C> child : children) {
                child.execute(input, context);
            }
        }
        passToNext(null, context); // Adjust as necessary
        return null;
    }

    @Override
    public void visualize(StringBuilder sb, String parentId) {
        String taskId = Integer.toHexString(System.identityHashCode(this));
        sb.append(taskId).append(" [label=\"").append(this.getClass().getSimpleName()).append(" - ").append(executionMode).append("\"];\n");
        if (parentId != null) {
            sb.append(parentId).append(" -> ").append(taskId).append(";\n");
        }
        for (Task<I, O, C> child : children) {
            child.visualize(sb, taskId);
        }
        super.visualize(sb, taskId);
    }
}
