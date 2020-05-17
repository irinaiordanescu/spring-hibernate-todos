package com.example.springhibernatetodo.dao;

import com.example.springhibernatetodo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("todo")
public class TodoDataAccessService implements TodoDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TodoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTask(UUID id, Todo todo) {
        final String sql = "INSERT INTO todo(idTask, name, description, duration) VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(sql, id, todo.getName(), todo.getDescription(), todo.getDuration());
    }

    @Override
    public List<Todo> selectAllTasks() {
        final String sql = "SELECT idTask, name, description, duration FROM todo";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID idTask = UUID.fromString(resultSet.getString("idTask"));
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            String duration = resultSet.getString("duration");
            return new Todo(idTask, name, description, duration);
        });
    }

    @Override
    public Optional<Todo> selectTaskById(UUID id) {
        final String sql = "SELECT idTask, name, description, duration FROM todo WHERE idTask =?";
        Todo todo = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID idTask = UUID.fromString(resultSet.getString("idTask"));
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            String duration = resultSet.getString("duration");
            return new Todo(idTask, name, description, duration);
        });
        return Optional.ofNullable(todo);
    }

    @Override
    public int deleteTaskById(UUID id) {
        final String sql = "DELETE FROM todo WHERE idTask = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateTaskById(UUID id, String duration) {
        final String sql = "UPDATE todo SET duration = ? WHERE idTask = ?";
        return jdbcTemplate.update(sql, duration, id);
    }
}
