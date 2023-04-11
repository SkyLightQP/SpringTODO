package me.daegyeo.springtodo.controller;

import lombok.RequiredArgsConstructor;
import me.daegyeo.springtodo.entity.TodoEntity;
import me.daegyeo.springtodo.error.ErrorCode;
import me.daegyeo.springtodo.exception.ServiceException;
import me.daegyeo.springtodo.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/")
    public List<TodoEntity> getAllTodos() {
        return this.todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public TodoEntity getTodo(@PathVariable Long id) {
        return this.todoService.getTodoById(id).orElseThrow(() -> new ServiceException(ErrorCode.TODO_NOT_FOUND));
    }
}
