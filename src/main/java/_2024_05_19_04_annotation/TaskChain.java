package _2024_05_19_04_annotation;

public class TaskChain<T extends BaseContext> {
    private final Task<T> startTask;

    public TaskChain(Task<T> startTask) {
        this.startTask = startTask;
    }

    public void execute(T context) {
        startTask.execute(context);
    }

    public String visualize() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        startTask.visualize(sb, null);
        sb.append("}\n");
        return sb.toString();
    }
}
