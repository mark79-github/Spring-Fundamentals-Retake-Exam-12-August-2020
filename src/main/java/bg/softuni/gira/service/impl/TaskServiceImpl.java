package bg.softuni.gira.service.impl;

import bg.softuni.gira.model.entity.Task;
import bg.softuni.gira.model.service.TaskServiceModel;
import bg.softuni.gira.repository.TaskRepository;
import bg.softuni.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel) {
        Task task = this.modelMapper.map(taskServiceModel, Task.class);

        this.taskRepository.saveAndFlush(task);
    }
}
