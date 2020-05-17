package com.example.springhibernatetodo.api;

import com.example.springhibernatetodo.model.Todo;
import com.example.springhibernatetodo.service.TodoService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/todo")
@RestController
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public int addTask(@NotNull @RequestBody Todo todo) {
        return todoService.addTask(todo);
    }

    @GetMapping
    public List<Todo> getAllTask() {
        return todoService.getAllTasks();
    }

    @GetMapping(path = "{idTask}")
    public Todo getTaskById(@PathVariable("idTask")UUID id) {
        return todoService.getTaskById(id).orElse(null);
    }

    @GetMapping(path = "/duration")
    public String getDuration(){
        return "";
    }

    @DeleteMapping(path = "{idTask}")
    public void deleteTaskById(@PathVariable("idTask") UUID id) {
        todoService.deleteTaskById(id);
    }

    @PutMapping(path = "{idTask}")
    public void updateTaskById(@PathVariable("idTask") UUID id, @NotNull @RequestBody String durationToUpdate) {
        todoService.updateTaskByID(id, durationToUpdate);
    }
}
