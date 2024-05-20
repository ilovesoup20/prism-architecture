package _20240518_02.domain.model;

import java.util.List;

public interface Node {
    void accept(Visitor visitor);
    List<Node> getChildren();
    boolean evaluate(Predicate predicate);
}
