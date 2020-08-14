package bg.softuni.gira.service;

import bg.softuni.gira.model.service.TaskServiceModel;

import java.util.List;

public interface TaskService {
    void addTask(TaskServiceModel taskServiceModel);

    List<TaskServiceModel> getAllTasks();

    TaskServiceModel getTaskById(String id);

    TaskServiceModel editProgress(TaskServiceModel taskServiceModel);
}

