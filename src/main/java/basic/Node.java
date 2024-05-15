package basic;

import java.util.List;

public interface Node {
    boolean evaluatePredicate(Context context);

    void executeLogic(Context context);

    List<Node> getNextNodes();
}
