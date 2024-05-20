package _2024_05_19_02;

import _2024_05_19_02.Context;

public interface ProcessingNode<T extends BaseContext> {
    void process(Context<T> context);
    void setNext(ProcessingNode<T> nextNode);
}