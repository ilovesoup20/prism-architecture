package _20240518_02.domain.model;

import java.util.List;

public class BusinessLogicNode implements Node{
    private List<Node> children;
    private Predicate predicate;
    private Logic logic;

    public BusinessLogicNode(List<Node> children, Predicate predicate, Logic logic) {
        this.children = children;
        this.predicate = predicate;
        this.logic = logic;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for (Node child : children) {
            child.accept(visitor);
        }
    }

    @Override
    public List<Node> getChildren() {
        return this.children;
    }

    @Override
    public boolean evaluate(Predicate predicate) {
        return predicate.test();
    }
    public void executeLogic() {
        logic.execute();
    }

    public Predicate getPredicate() {
        return predicate;
    }
}
