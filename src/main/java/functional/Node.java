package functional;

import java.util.List;

public interface Node {
    boolean evaluatePredicate(Context context);

    Context executeLogic(Context context);

    List<Node> getNextNodes();
}
