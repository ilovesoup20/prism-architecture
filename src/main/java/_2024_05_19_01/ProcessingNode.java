package _20240519_01;

public interface ProcessingNode<T> {
    void process(Context<T> context);

    void setNext(ProcessingNode<T> nextNode);

}
