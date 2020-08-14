package bg.softuni.gira.model.service;

import bg.softuni.gira.model.entity.enumerated.ClassificationName;

public class ClassificationServiceModel extends BaseServiceModel {

    private ClassificationName classificationName;
    private String description;

    public ClassificationServiceModel() {
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
