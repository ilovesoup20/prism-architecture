package _20240519_02;

import _20240519_01.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ProcessingChainBuilder<T extends BaseContext> {
    private ProcessingNode<T> startNode;
    private ProcessingNode<T> currentNode;
    private final ExecutorService executorService;

    public ProcessingChainBuilder() {
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public ProcessingChainBuilder(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public ProcessingChainBuilder<T> addSequentialNode(ProcessingNode<T> node) {
        if (startNode == null) {
            startNode = node;
            currentNode = node;
        } else {
            currentNode.setNext(node);
            currentNode = node;
        }
        return this;
    }

    public ProcessingChainBuilder<T> addCompositeNode(ExecutionMode executionMode, Consumer<CompositeProcessingNode<T>> configurator) {
        CompositeProcessingNode<T> compositeNode = new CompositeProcessingNode<>(executionMode, executorService);
        configurator.accept(compositeNode);
        addSequentialNode(compositeNode);
        return this;
    }

    public ProcessingChain<T> build() {
        return new ProcessingChain<>(startNode);
    }
}
