package com.example.springhibernatetodo.model;

import java.util.UUID;

public class Todo {
    private final UUID id;
    String name;
    String description;
    String duration;

    public Todo(UUID id, String name, String description, String duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
