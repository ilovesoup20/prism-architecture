package _2024_05_19_04_annotation;

import java.util.function.Consumer;

public interface Task<T extends BaseContext> {
    void execute(T context);
    void setNext(Task<T> nextTask);
    void visualize(StringBuilder sb, String parentId);
}
