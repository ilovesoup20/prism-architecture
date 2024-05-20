package _2024_05_19_02;

import _2024_05_19_02.Context;

import java.util.function.Consumer;

public class LeafProcessingNode<T extends BaseContext> extends AbstractProcessingNode<T> {
    private final Consumer<Context<T>> action;

    public LeafProcessingNode(Consumer<Context<T>> action) {
        this.action = action;
    }

    @Override
    public void process(Context<T> context) {
        action.accept(context);
        passToNext(context);
    }
}
