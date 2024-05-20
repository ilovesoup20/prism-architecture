package _2024_05_19_05_input_output;

public abstract class AbstractTask<I, O, C extends BaseContext> implements Task<I, O, C> {
    protected Task<O, ?, C> nextTask;

    @Override
    public <P> void setNext(Task<O, P, C> nextTask) {
        this.nextTask = nextTask;
    }

    protected void passToNext(O output, C context) {
        if (this.nextTask != null) {
            this.nextTask.execute(output, context);
        }
    }

    @Override
    public void visualize(StringBuilder sb, String parentId) {
        String taskId = Integer.toHexString(System.identityHashCode(this));
        sb.append(taskId).append(" [label=\"").append(this.getClass().getSimpleName()).append("\"];\n");
        if (parentId != null) {
            sb.append(parentId).append(" -> ").append(taskId).append(";\n");
        }
        if (nextTask != null) {
            nextTask.visualize(sb, taskId);
        }
    }
}
