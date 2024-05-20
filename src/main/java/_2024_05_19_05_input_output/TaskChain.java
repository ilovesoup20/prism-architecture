package _2024_05_19_05_input_output;

public class TaskChain<I, O, C extends BaseContext> {
    private final Task<I, O, C> startTask;

    public TaskChain(Task<I, O, C> startTask) {
        this.startTask = startTask;
    }

    public void execute(I input, C context) {
        startTask.execute(input, context);
    }

    public String visualize() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        startTask.visualize(sb, null);
        sb.append("}\n");
        return sb.toString();
    }
}
