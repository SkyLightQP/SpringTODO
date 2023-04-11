package me.daegyeo.springtodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTodoApplication.class, args);
    }

}
