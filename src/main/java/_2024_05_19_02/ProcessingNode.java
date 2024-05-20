package _20240519_02;

import _20240519_01.Context;

public interface ProcessingNode<T extends BaseContext> {
    void process(Context<T> context);
    void setNext(ProcessingNode<T> nextNode);
}