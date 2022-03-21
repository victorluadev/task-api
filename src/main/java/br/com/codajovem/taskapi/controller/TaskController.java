package br.com.codajovem.taskapi.controller;

import br.com.codajovem.taskapi.controller.dtos.TaskChangeStatusRequest;
import br.com.codajovem.taskapi.controller.dtos.TaskCreateRequest;
import br.com.codajovem.taskapi.controller.dtos.TaskUpdateRequest;
import br.com.codajovem.taskapi.model.Task;
import br.com.codajovem.taskapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping()
    public Page<Task> getTasks(@PageableDefault(size = 30) Pageable pageable) {
        return service.getAllTasks(pageable);
    }

    @PostMapping()
    @ResponseStatus(CREATED)
    public Task createTask(@RequestBody @Valid TaskCreateRequest dto) {
        Task task = Task.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .build();
        return service.create(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody @Valid TaskUpdateRequest dto) {
        Task task = Task.builder()
                .id(id)
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        return service.update(task);
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable("id") Long idTask) {
        return service.getTaskById(idTask);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PatchMapping(value = "/{id}/status")
    @ResponseStatus(NO_CONTENT)
    public void changeStatus(@PathVariable Long id, @RequestBody @Valid TaskChangeStatusRequest dto) {
        Task task = Task.builder()
                .id(id)
                .status(dto.getStatus())
                .build();
        service.changeStatus(task);
    }



}
