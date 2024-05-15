package functional;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalNode implements Node {
    private Predicate<Context> predicate;
    private Function<Context, Context> logic;
    private List<Node> nextNodes;

    public FunctionalNode() {
    }

    public FunctionalNode(Predicate<Context> predicate, Function<Context, Context> logic, List<Node> nextNodes) {
        this.predicate = predicate;
        this.logic = logic;
        this.nextNodes = nextNodes;
    }

    @Override
    public boolean evaluatePredicate(Context context) {
        return predicate.test(context);
    }

    @Override
    public Context executeLogic(Context context) {
        return logic.apply(context);
    }

    @Override
    public List<Node> getNextNodes() {
        return nextNodes;
    }
}
