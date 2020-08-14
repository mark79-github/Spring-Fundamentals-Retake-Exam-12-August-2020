package bg.softuni.gira.service;

import bg.softuni.gira.model.service.ClassificationServiceModel;

public interface ClassificationService {
    void seedClassification();

    ClassificationServiceModel getClassificationByName(String classificationName);
}
