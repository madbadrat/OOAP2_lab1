package ru.vorotov.ooap2_lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Task {
    private final int id;

    @Setter
    @Getter
    private String type;

    @Setter
    @Getter
    private String title;

    @Getter
    private String description;

    @Setter
    @Getter
    private List<String> descriptionHistory;

    public Task(int id, String type, String title, String description) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;

        this.descriptionHistory = new ArrayList<>();
        this.descriptionHistory.add(description);
    }

    public void setDescription(String description) {
        this.description = description;
        this.descriptionHistory.add(description);
    }

    @Override
    public String toString() {
        return id + " " + type + " " + title + " " + description + "\n";
    }

}
