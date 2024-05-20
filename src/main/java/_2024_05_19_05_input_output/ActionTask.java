package _2024_05_19_05_input_output;

import java.util.function.Function;

public class ActionTask<I, O, C extends BaseContext> extends AbstractTask<I, O, C> {
    private final Function<I, O> action;

    public ActionTask(Function<I, O> action) {
        this.action = action;
    }

    @Override
    public O execute(I input, C context) {
        O output = action.apply(input);
        passToNext(output, context);
        return output;
    }
}
