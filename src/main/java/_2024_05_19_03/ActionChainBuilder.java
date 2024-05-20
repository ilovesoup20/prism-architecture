package _2024_05_19_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ActionChainBuilder<T extends BaseContext> {
    private Action<T> startAction;
    private Action<T> currentAction;
    private final ExecutorService executorService;

    public ActionChainBuilder() {
        this.executorService = Executors.newSingleThreadExecutor();
    }
    public ActionChainBuilder(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public ActionChainBuilder<T> addSequentialAction(Action<T> action) {
        if (startAction == null) {
            this.startAction = action;
            this.currentAction = action;
        } else {
            currentAction.setNext(action);
            currentAction = action;
        }
        return this;
    }

    public ActionChainBuilder<T> addCompositeAction(ExecutionMode executionMode, Consumer<CompositeAction<T>> configurator) {
        CompositeAction<T> action = new CompositeAction<>(executionMode, this.executorService);
        configurator.accept(action);
        addSequentialAction(action);
        return this;
    }

    public ActionChain<T> build() {
        return new ActionChain<>(this.startAction);
    }
}
