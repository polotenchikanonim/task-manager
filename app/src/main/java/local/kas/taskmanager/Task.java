package local.kas.taskmanager;

import java.io.Serializable;

public class Task implements Serializable {
    private final String name;
    private final String description;
    private final String date;

    public Task(String name, String description, String date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
