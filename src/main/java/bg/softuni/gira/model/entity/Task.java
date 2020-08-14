package bg.softuni.gira.model.entity;

import bg.softuni.gira.model.entity.enumerated.Progress;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

import static bg.softuni.gira.constraint.Global.*;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

    @Column(name = "name", nullable = false)
    @Length(min = 3, max = 20, message = NAME_LENGTH_MSG)
    private String name;
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    @Length(min = 5, message = DESCRIPTION_LENGTH_MSG)
    private String description;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "progress", nullable = false)
    private Progress progress;
    @Column(name = "due_date", nullable = false)
    @FutureOrPresent(message = DUE_DATE_VALIDATION_MSG)
    private LocalDate dueDate;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    private Classification classification;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    private User user;

    public Task() {
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

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
