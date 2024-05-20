package _2024_05_19_03;

public class ActionChain <T extends BaseContext> {

    private final Action<T> startAction;

    public ActionChain(Action<T> startAction) {
        this.startAction = startAction;
    }

    public void process(T context) {
        this.startAction.process(context);
    }

    public String visualize() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        this.startAction.visualize(sb, null);
        sb.append("}\n");
        return sb.toString();
    }
}
