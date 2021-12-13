package com.example.hackathonendava.config;


import com.example.hackathonendava.model.Task;
import com.example.hackathonendava.repository.TaskRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataSetup implements ApplicationRunner {

    private final TaskRepository taskRepository;

    public DataSetup(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private void saveTask(String name, String description, LocalDate deadline, String stage) {
        Task task = new Task();

        task.setName(name);
        task.setDescription(description);
        task.setDeadline(deadline);
        task.setStage(stage);

        taskRepository.save(task);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveTask("Watch tutorial", "Watch tutorial about Spring", LocalDate.parse("2021-11-01"), "To do");
        saveTask("Solve AI homework", "Solve the problem using A*", LocalDate.parse("2021-11-01"), "To do");

    }
}
