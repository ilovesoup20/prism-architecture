package _2024_05_19_05_input_output;

public interface Task<I, O, C extends BaseContext> {
    O execute(I input, C context);
    <P> void setNext(Task<O, P, C> nextTask);

    void visualize(StringBuilder sb, String parentId);
}
