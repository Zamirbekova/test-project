package com.project.service;

import com.project.dto.TaskRequestDto;
import com.project.dto.TaskResponseDto;
import com.project.entity.Task;

import java.util.List;

public interface TaskService {
    TaskResponseDto save(TaskRequestDto dto);

    TaskResponseDto getById(Long id);

    TaskResponseDto update(Long id, TaskRequestDto dto);

    List<Task> getAll();

    void delete(Long id);
}
