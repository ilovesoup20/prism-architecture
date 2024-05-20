package _20240519_02;

import _20240519_01.Context;

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
