package _2024_05_19_04_annotation;

public abstract class AbstractTask<T extends BaseContext> implements Task<T> {
    protected Task<T> nextTask;

    @Override
    public void setNext(Task<T> nextTask) {
        this.nextTask = nextTask;
    }

    protected void passToNext(T context) {
        if (nextTask != null) {
            nextTask.execute(context);
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
