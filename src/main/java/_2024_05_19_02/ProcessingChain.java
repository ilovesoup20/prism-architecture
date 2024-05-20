package _20240519_02;

import _20240519_01.Context;

public class ProcessingChain<T extends BaseContext> {
    private final ProcessingNode<T> startNode;

    public ProcessingChain(ProcessingNode<T> startNode) {
        this.startNode = startNode;
    }

    public void process(Context<T> context) {
        startNode.process(context);
    }
}