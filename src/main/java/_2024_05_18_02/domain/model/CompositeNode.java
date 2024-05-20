package _2024_05_18_02.domain.model;

import java.util.ArrayList;
import java.util.List;

public class CompositeNode implements Node {
    private List<Node> children = new ArrayList<>();

    @Override
    public void accept(Visitor visitor) {
        for (Node child : children) {
            child.accept(visitor);
        }
    }

    @Override
    public List<Node> getChildren() {
        return children;
    }

    @Override
    public boolean evaluate(Predicate predicate) {
        for (Node child : children) {
            if (!child.evaluate(predicate)) {
                return false;
            }
        }
        return true;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public void removeChild(Node child) {
        children.remove(child);
    }
}
