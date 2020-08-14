package bg.softuni.gira.model.service;

import bg.softuni.gira.model.entity.enumerated.Progress;

import java.time.LocalDate;

public class TaskServiceModel extends BaseServiceModel {

    private String name;
    private String description;
    private Progress progress;
    private LocalDate dueDate;
    private ClassificationServiceModel classification;
    private UserServiceModel user;

    public TaskServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ClassificationServiceModel getClassification() {
        return classification;
    }

    public void setClassification(ClassificationServiceModel classification) {
        this.classification = classification;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }
}
