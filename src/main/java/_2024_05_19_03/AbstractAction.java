package _2024_05_19_03;

public abstract class AbstractAction<T extends BaseContext> implements Action<T> {
    protected Action<T> nextAction;

    @Override
    public void setNext(Action<T> next) {
        this.nextAction = next;
    }

    public void passToNext(T context) {
        if (this.nextAction != null) {
            this.nextAction.process(context);
        }
    }
}
