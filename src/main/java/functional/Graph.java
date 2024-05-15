package functional;

import java.util.ArrayDeque;
import java.util.Deque;

public class Graph {
    private final Node entryNode;

    public Graph(Node entryNode) {
        this.entryNode = entryNode;
    }

    public Context execute(Context context) {
        Node currentNode = entryNode;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(currentNode);
        Context currentContext = context;

        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            if(currentNode.evaluatePredicate(currentContext)) {
                currentContext = currentNode.executeLogic(currentContext);
                stack.addAll(currentNode.getNextNodes());
            }
        }
        return currentContext;
    }
}
