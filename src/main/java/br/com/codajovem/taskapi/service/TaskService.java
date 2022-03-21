package br.com.codajovem.taskapi.service;

import br.com.codajovem.taskapi.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    Page<Task> getAllTasks(Pageable pageable);

    Task create(Task task);

    Task update(Task task);

    Task getTaskById(Long idTask);

    void deleteById(Long id);

    void changeStatus(Task task);
}
