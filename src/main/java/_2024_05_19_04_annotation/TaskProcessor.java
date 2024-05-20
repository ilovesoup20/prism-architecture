package _2024_05_19_04_annotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public class TaskProcessor<T extends BaseContext> {
    private final Map<String, Task<T>> taskMap = new HashMap<>();
    private final ExecutorService executorService;

    public TaskProcessor(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public Task<T> buildTaskChain(Object annotatedObject) throws Exception {
        Method[] methods = annotatedObject.getClass().getMethods();
        Task<T> startTask = null;
        Task<T> previousTask = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(TaskAction.class)) {
                TaskAction taskAction = method.getAnnotation(TaskAction.class);
                Consumer<T> action = context -> {
                    try {
                        method.invoke(annotatedObject, context);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                };
                Task<T> currentTask = new ActionTask<>(action);
                taskMap.put(taskAction.value(), currentTask);

                if (startTask == null) {
                    startTask = currentTask;
                } else {
                    previousTask.setNext(currentTask);
                }
                previousTask = currentTask;
            } else if (method.isAnnotationPresent(CompositeTaskAction.class)) {
                CompositeTaskAction compositeTaskAction = method.getAnnotation(CompositeTaskAction.class);
                CompositeTask<T> compositeTask = new CompositeTask<>(compositeTaskAction.mode(), executorService);
                method.invoke(annotatedObject, compositeTask);

                if (startTask == null) {
                    startTask = compositeTask;
                } else {
                    previousTask.setNext(compositeTask);
                }
                previousTask = compositeTask;
            }
        }
        return startTask;
    }

    public Task<T> getTask(String name) {
        return taskMap.get(name);
    }
}
