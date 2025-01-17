package bg.softuni.gira.model.entity;

import bg.softuni.gira.model.entity.enumerated.ClassificationName;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{

    @Column(name = "classification_name", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ClassificationName classificationName;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Classification() {
    }

    public ClassificationName getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationName classificationName) {
        this.classificationName = classificationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
