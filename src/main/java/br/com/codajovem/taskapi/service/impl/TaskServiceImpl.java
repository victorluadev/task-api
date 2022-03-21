package br.com.codajovem.taskapi.service.impl;

import br.com.codajovem.taskapi.exception.BusinessException;
import br.com.codajovem.taskapi.exception.ResourceNotFoundException;
import br.com.codajovem.taskapi.model.Task;
import br.com.codajovem.taskapi.repository.TaskRepository;
import br.com.codajovem.taskapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public Page<Task> getAllTasks(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Task create(Task task) {
        if (task.getStatus().equalsIgnoreCase("DONE")) {
            throw new BusinessException("Task cannot be DONE");
        }
        return repository.save(task);
    }

    @Override
    public Task update(Task task) {
        Task taskSaved = repository.findById(task.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Task not found by id: "+task.getId())
        );
        taskSaved.setName(task.getName());
        taskSaved.setDescription(task.getDescription());
        return repository.save(taskSaved);
    }

    @Override
    public Task getTaskById(Long idTask) {
        Task taskSaved = repository.findById(idTask).orElseThrow(
                () -> new ResourceNotFoundException("Task not found by id: "+idTask)
        );
        return taskSaved;
    }

    @Override
    public void deleteById(Long id) {
        Task taskSaved = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task not found by id: "+id)
        );
        repository.delete(taskSaved);
    }

    @Override
    public void changeStatus(Task task) {
        Task taskSaved = repository.findById(task.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Task not found by id: "+task.getId())
        );

        if (!taskSaved.getStatus().equalsIgnoreCase(task.getStatus())) {
            taskSaved.setStatus(task.getStatus());
            repository.save(taskSaved);
        }
    }
}
