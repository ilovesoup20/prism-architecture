package _20240519_01;

public class ProcessingChainBuilder<T> {
    private ProcessingNode<T> startNode;
    private ProcessingNode<T> currentNode;

    public ProcessingChainBuilder<T> addNode(ProcessingNode<T> node) {
        if (startNode == null) {
            startNode = node;
            currentNode = node;
        } else {
            currentNode.setNext(node);
            currentNode = node;
        }
        return this;
    }

    public ProcessingChain<T> build() {
        return new ProcessingChain<>(this.startNode);
    }
}
