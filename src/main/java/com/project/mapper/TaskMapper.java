package com.project.mapper;

import com.project.dto.TaskRequestDto;
import com.project.dto.TaskResponseDto;
import com.project.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task save(TaskRequestDto dto) {
        Task task = new Task();
        task.setDescription(dto.getDescription());
        task.setDone(dto.isDone());
        return task;
    }

    public TaskResponseDto toResponse(Task task) {
        TaskResponseDto responseDto = new TaskResponseDto();
        responseDto.setDescription(task.getDescription());
        responseDto.setDone(task.isDone());
        responseDto.setId(task.getId());
        return responseDto;
    }


}
