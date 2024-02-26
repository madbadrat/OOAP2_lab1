package ru.vorotov.ooap2_lab1;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    List<Task> tasks = new ArrayList<>();

    public void createTask(Task task) {
        tasks.add(task);
    }

    public void editTask(int id, String newType, String newTitle, String newDescription) {
        tasks.get(id).setType(newType);
        tasks.get(id).setDescription(newDescription);
        tasks.get(id).setTitle(newTitle);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }
}
