package _2024_05_19_01;

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
