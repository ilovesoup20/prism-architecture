package _2024_05_19_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CompositeAction <T extends BaseContext> extends AbstractAction<T> {
    private final List<Action<T>> children = new ArrayList<>();
    private final ExecutionMode executionMode;
    private final ExecutorService executorService;

    public CompositeAction(ExecutionMode executionMode, ExecutorService executorService) {
        this.executionMode = executionMode;
        this.executorService = executorService;
    }

    public void addChild(Action<T> action) {
        children.add(action);
    }

    @Override
    public void process(T context) {
        if (executionMode == ExecutionMode.CONCURRENT) {
            // TODO: Make it functional. Use Stream API???
            List<Future<?>> futures = new ArrayList<>();
            for (Action<T> child : children) {
                Future<?> future = executorService.submit(() -> child.process(context));
                futures.add(future);
            }

            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    // TODO: Do something..
                    e.printStackTrace();
                }
            }
        } else {
            for (Action<T> child : children) {
                child.process(context);
            }
        }
        passToNext(context);
    }

}
