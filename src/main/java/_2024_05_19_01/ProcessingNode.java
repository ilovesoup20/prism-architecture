package _2024_05_19_01;

public interface ProcessingNode<T> {
    void process(Context<T> context);

    void setNext(ProcessingNode<T> nextNode);

}
