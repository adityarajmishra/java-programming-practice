package org.skillovilla.level2;

public class Task {
    private final String taskId;
    private final String description;
    private Priority priority;

    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.priority = Priority.MEDIUM;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void updatePriority(Priority newPriority) {
        this.priority = newPriority;
    }

}
