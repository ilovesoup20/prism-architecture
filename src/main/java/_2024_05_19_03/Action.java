package _2024_05_19_03;

public interface Action<T extends BaseContext> {

    void process(T context);

    void setNext(Action<T> nextNode);

    void visualize(StringBuilder sb, String parentId);

}
