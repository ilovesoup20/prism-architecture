package _2024_05_19_04_annotation;

import java.util.function.Consumer;

public class ActionTask<T extends BaseContext> extends AbstractTask<T> {
    private final Consumer<T> action;

    public ActionTask(Consumer<T> action) {
        this.action = action;
    }

    @Override
    public void execute(T context) {
        action.accept(context);
        passToNext(context);
    }
}

