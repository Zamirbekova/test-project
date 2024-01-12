package com.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDto {
    private String description;
    private boolean isDone;
}
