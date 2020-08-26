package bg.softuni.gira.service.impl;

import bg.softuni.gira.model.entity.Task;
import bg.softuni.gira.model.entity.enumerated.Progress;
import bg.softuni.gira.model.service.TaskServiceModel;
import bg.softuni.gira.repository.TaskRepository;
import bg.softuni.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<TaskServiceModel> getAllTasks() {
        return this.taskRepository.findAll()
                .stream()
                .map(task -> this.modelMapper.map(task, TaskServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaskServiceModel getTaskById(String id) {
        return this.taskRepository
                .findById(id)
                .map(task -> this.modelMapper.map(task, TaskServiceModel.class))
                .orElse(null);
    }

    @Override
    public void editProgress(TaskServiceModel taskServiceModel) {
        Progress progress = taskServiceModel.getProgress();
        int nextOrdinal = (progress.ordinal() + 1) % Progress.values().length;
        List<Progress> progresses = Arrays.stream(Progress.values()).collect(Collectors.toList());
        taskServiceModel.setProgress(progresses.get(nextOrdinal));
        Task task = this.modelMapper.map(taskServiceModel, Task.class);
        if (task.getDueDate().compareTo(LocalDate.now()) < 0) {
            task.setDueDate(LocalDate.now());
        }
        if (nextOrdinal == Progress.values().length - 1) {
            this.taskRepository.deleteById(task.getId());
        } else {
            this.taskRepository.save(task);
        }
    }
}
