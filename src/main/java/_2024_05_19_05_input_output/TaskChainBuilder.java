package _2024_05_19_05_input_output;

import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public class TaskChainBuilder<I, O, C extends BaseContext> {
    private Task<I, O, C> startTask;
    private Task<?, ?, C> currentTask;
    private final ExecutorService executorService;

    public TaskChainBuilder(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public <P> TaskChainBuilder<I, O, C> addSequentialTask(Task<I, O, C> task) {
        if (startTask == null) {
            startTask = task;
            currentTask = task;
        } else {
//            currentTask.setNext(task);
            currentTask = task;
        }
        return this;
    }

    public <P> TaskChainBuilder<I, O, C> addCompositeTask(ExecutionMode executionMode, Consumer<CompositeTask<I, O, C>> configurator) {
        CompositeTask<I, O, C> compositeTask = new CompositeTask<>(executionMode, executorService);
        configurator.accept(compositeTask);
        this.<P>addSequentialTask(compositeTask);
        return this;
    }

    public TaskChain<I, O, C> build() {
        return new TaskChain<>(startTask);
    }
}
