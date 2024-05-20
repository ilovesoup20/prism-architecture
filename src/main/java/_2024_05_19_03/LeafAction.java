package _2024_05_19_03;

import java.util.function.Consumer;

public class LeafAction<T extends BaseContext> extends AbstractAction<T> {
    private final Consumer<T> action;

    public LeafAction(Consumer<T> action) {
        this.action = action;
    }

    @Override
    public void process(T context) {
        action.accept(context);
        passToNext(context);
    }
}
