package basic;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConcreteNode implements Node {
    private Predicate<Context> predicate;
    private Consumer<Context> logic;
    private List<Node> nextNodes;

    public ConcreteNode() {
    }

    public ConcreteNode(Predicate<Context> predicate, Consumer<Context> logic, List<Node> nextNodes) {
        this.predicate = predicate;
        this.logic = logic;
        this.nextNodes = nextNodes;
    }

    @Override
    public boolean evaluatePredicate(Context context) {
        return predicate.test(context);
    }

    @Override
    public void executeLogic(Context context) {
        logic.accept(context);
    }

    @Override
    public List<Node> getNextNodes() {
        return nextNodes;
    }
}
