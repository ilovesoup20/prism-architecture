package _2024_05_19_02;

public abstract class AbstractProcessingNode<T extends BaseContext> implements ProcessingNode<T> {
    protected ProcessingNode<T> nextNode;

    @Override
    public void setNext(ProcessingNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public void passToNext(T context) {
        if (nextNode != null) {
            nextNode.process(context);
        }
    }
}
