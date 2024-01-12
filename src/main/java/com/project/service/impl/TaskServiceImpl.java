package com.project.service.impl;

import com.project.dto.TaskRequestDto;
import com.project.dto.TaskResponseDto;
import com.project.entity.Task;
import com.project.exceptions.NotFoundException;
import com.project.mapper.TaskMapper;
import com.project.repository.TaskRepository;
import com.project.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskMapper mapper;
    private TaskRepository repository;

    @Override
    public TaskResponseDto save(TaskRequestDto dto) {
        return mapper.toResponse(repository.save(mapper.save(dto)));

    }

    @Override
    public TaskResponseDto getById(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new NotFoundException("not found")));
    }

    @Override
    public TaskResponseDto update(Long id, TaskRequestDto dto) {
        Task task = repository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
        ;

        task.setDescription(dto.getDescription());
        task.setDone(dto.isDone());
        return mapper.toResponse(repository.save(task));
    }

    @Override
    public List<Task> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
        repository.delete(task);
    }
}
