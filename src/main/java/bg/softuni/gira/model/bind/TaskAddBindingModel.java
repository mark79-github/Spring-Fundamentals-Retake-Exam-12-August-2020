package bg.softuni.gira.model.bind;

import bg.softuni.gira.model.entity.Classification;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static bg.softuni.gira.constraint.Global.*;

public class TaskAddBindingModel {

    @Length(min = 3, max = 20, message = NAME_LENGTH_MSG)
    private String name;
    @Length(min = 5, message = DESCRIPTION_LENGTH_MSG)
    private String description;
    @FutureOrPresent(message = DUE_DATE_VALIDATION_MSG)
    @NotNull(message = DUE_DATE_EMPTY_MSG)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @NotEmpty(message = CLASSIFICATION_NOT_NULL)
    private String classification;

    public TaskAddBindingModel() {
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
