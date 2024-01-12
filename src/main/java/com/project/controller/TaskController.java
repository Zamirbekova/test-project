package com.project.controller;

import com.project.dto.TaskRequestDto;
import com.project.dto.TaskResponseDto;
import com.project.entity.Task;
import com.project.service.TaskService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    private TaskService service;

    @PostMapping
    @ApiOperation("Add task")
    public TaskResponseDto save(@RequestBody TaskRequestDto requestDto) {
        return service.save(requestDto);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get task by id")
    public TaskResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    @ApiOperation("Get all tasks")
    public List<Task> getAllTasks() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public TaskResponseDto update(@PathVariable Long id, @RequestBody TaskRequestDto requestDto) {
        return service.update(id, requestDto);
    }
}
