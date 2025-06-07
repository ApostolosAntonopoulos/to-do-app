package com.portfolio.to_do_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    public List<TodoItem> getTodos(){
        return todoRepository.findAll();
    }

    @PostMapping("/todos")
    public TodoItem createTodo(@RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }

    @PutMapping("/todos/{id}")
    public TodoItem updateTodo(@PathVariable Long id, @RequestBody TodoItem updatedTodo) {
        return todoRepository.findById(id).map(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setStatus(updatedTodo.getStatus());
            return todoRepository.save(todo);
        }).orElseThrow();
    }
}
