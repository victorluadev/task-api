package br.com.codajovem.taskapi.repository.impl;

import br.com.codajovem.taskapi.model.Task;
import br.com.codajovem.taskapi.repository.TaskRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
@Repository
@Profile("Mock")
public class TaskRepositoryImpl implements TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    @PostConstruct
    public void initDB() {
        tasks.add(
                new Task(1l, "tarefa1", "desc1", "TODO"));
        tasks.add(
                new Task(2l, "tarefa2", "desc2", "TODO"));
        tasks.add(new Task(3l, "tarefa3", "desc3", "TODO"));
    }

    public List<Task> findAll() {
        return this.tasks;
    }

    public Task save(Task task) {
        if(task.getId() == null) {
            task.setId(this.tasks.size()+1l);
            this.tasks.add(task);
        }else {
            this.tasks.stream().forEach(x -> {
                if(x.getId() == task.getId()) {
                    x = task;
                }
            });
        }

        return task;
    }

    @Override
    public Task findById(Long id) {
        return this.tasks.stream().filter(x -> x.getId() == id).findFirst().orElse(new Task());
    }

    @Override
    public void delete(Task taskSaved) {
        List<Task> collect = this.tasks.stream().filter(x -> x.getId() != taskSaved.getId()).collect(Collectors.toList());
        this.tasks.clear();
        this.tasks.addAll(collect);
    }
}*/
