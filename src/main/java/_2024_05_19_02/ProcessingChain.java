package _2024_05_19_02;

import _2024_05_19_02.Context;

public class ProcessingChain<T extends BaseContext> {
    private final ProcessingNode<T> startNode;

    public ProcessingChain(ProcessingNode<T> startNode) {
        this.startNode = startNode;
    }

    public void process(Context<T> context) {
        startNode.process(context);
    }
}