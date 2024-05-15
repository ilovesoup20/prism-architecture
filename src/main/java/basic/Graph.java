package basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Graph {
    private Node entryNode;

    public Graph(Node entryNode) {
        this.entryNode = entryNode;
    }

    public void execute(Context context) {
        Node currentNode = entryNode;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(currentNode);

        while(!stack.isEmpty()) {
            currentNode = stack.pop();
            if(currentNode.evaluatePredicate(context)) {
                currentNode.executeLogic(context);
                stack.addAll(currentNode.getNextNodes());
            }
        }
    }
}
