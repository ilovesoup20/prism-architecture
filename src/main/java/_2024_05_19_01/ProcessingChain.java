package _2024_05_19_01;

public class ProcessingChain<T> {
    private ProcessingNode<T> startNode;

    public ProcessingChain(ProcessingNode<T> startNode) {
        this.startNode = startNode;
    }

    public void process(T data) {
        Context<T> context = new Context();
        context.setData(data);
        startNode.process(context);
    }
}
