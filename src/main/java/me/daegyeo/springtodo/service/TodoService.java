package me.daegyeo.springtodo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.daegyeo.springtodo.dto.TodoUpdateDto;
import me.daegyeo.springtodo.dto.TodoUpdateMapper;
import me.daegyeo.springtodo.entity.TodoEntity;
import me.daegyeo.springtodo.error.ErrorCode;
import me.daegyeo.springtodo.exception.ServiceException;
import me.daegyeo.springtodo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoUpdateMapper todoUpdateMapper;

    public TodoEntity createTodo(TodoEntity todoEntity) {
        log.info("Created new todo successfully. id={}", todoEntity.getId());
        return todoRepository.save(todoEntity);
    }

    public TodoEntity updateTodo(Long todoId, TodoUpdateDto dto) {
        log.info("Updated todo successfully. id={}", todoId);
        TodoEntity todo = this.getTodoById(todoId).orElseThrow(() -> new ServiceException(ErrorCode.TODO_NOT_FOUND));
        todoUpdateMapper.updateTodoFromDto(dto, todo);
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long todoId) {
        log.info("Deleted todo successfully. id={}", todoId);
        Optional<TodoEntity> todo = this.getTodoById(todoId);
        todoRepository.delete(todo.orElseThrow(() -> new ServiceException(ErrorCode.TODO_NOT_FOUND)));
    }

    public Optional<TodoEntity> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public List<TodoEntity> getAllTodos() {
        return todoRepository.findAll();
    }
}
