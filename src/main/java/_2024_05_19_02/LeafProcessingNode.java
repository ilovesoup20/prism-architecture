package _2024_05_19_02;

import _2024_05_19_02.Context;

import java.util.function.Consumer;

public class LeafProcessingNode<T extends BaseContext> extends AbstractProcessingNode<T> {
    private final Consumer<T> action;

    public LeafProcessingNode(Consumer<T> action) {
        this.action = action;
    }

    @Override
    public void process(T context) {
        action.accept(context);
        passToNext(context);
    }
}
