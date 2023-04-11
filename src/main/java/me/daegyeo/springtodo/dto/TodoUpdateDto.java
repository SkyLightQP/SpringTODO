package me.daegyeo.springtodo.dto;

import lombok.Data;

@Data
public class TodoUpdateDto {
    private String title;
    private String content;
    private Boolean isCompleted;
}
