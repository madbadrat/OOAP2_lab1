package ru.vorotov.ooap2_lab1;

public class Task {
    private final int id;
    private String type;
    private String title;
    private String description;

    public Task(int id, String type, String title, String description) {
        this.type = type;
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return id + " " + type + " " + title + " " + description + "\n";
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
