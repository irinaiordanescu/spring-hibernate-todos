package com.example.springhibernatetodo.service;

import com.example.springhibernatetodo.dao.TodoDao;
import com.example.springhibernatetodo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {
    private final TodoDao todoDao;

    @Autowired
    public TodoService(@Qualifier("todo") TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public int addTask(Todo todo) { return todoDao.insertTask(todo);
    }

    public List<Todo> getAllTasks() {
        return todoDao.selectAllTasks();
    }

    public Optional<Todo> getTaskById(UUID id) {
        return todoDao.selectTaskById(id);
    }

    public int deleteTaskById(UUID id) {
        return todoDao.deleteTaskById(id);
    }

    public int updateTaskByID(UUID id, String newDuration) {
        return todoDao.updateTaskById(id, newDuration);
    }
}
