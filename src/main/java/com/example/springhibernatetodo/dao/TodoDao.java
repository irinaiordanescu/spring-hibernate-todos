package com.example.springhibernatetodo.dao;

import com.example.springhibernatetodo.model.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoDao {
    int insertTask(UUID id, Todo todo);

    default int insertTask (Todo todo) {
        UUID id = UUID.randomUUID();
        return insertTask(id, todo);
    }

    List<Todo> selectAllTasks();

    Optional<Todo> selectTaskById(UUID id);

    int deleteTaskById(UUID id);

    int updateTaskById(UUID id, String duration);
}
