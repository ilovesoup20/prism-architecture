package _20240519_02;

import _20240519_01.Context;
import _20240519_01.ProcessingNode;

public abstract class AbstractProcessingNode<T> implements ProcessingNode<T> {
    protected ProcessingNode<T> nextNode;

    @Override
    public void setNext(ProcessingNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public void passToNext(Context<T> context) {
        if (nextNode != null) {
            nextNode.process(context);
        }
    }
}
