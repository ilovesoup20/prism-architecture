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

    @Override
    public void visualize(StringBuilder sb, String parentId) {
        String nodeId = Integer.toHexString(System.identityHashCode(this));
        sb.append(nodeId).append(" [label=\"").append(this.getClass().getSimpleName()).append("\"];\n");
        if (parentId != null) {
            sb.append(parentId).append(" -> ").append(nodeId).append(";\n");
        }
        if (this.nextAction != null) {
            this.nextAction.visualize(sb, nodeId);
        }
    }
}
