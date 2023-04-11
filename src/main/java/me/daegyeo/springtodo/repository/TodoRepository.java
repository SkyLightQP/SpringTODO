package me.daegyeo.springtodo.repository;

import me.daegyeo.springtodo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
