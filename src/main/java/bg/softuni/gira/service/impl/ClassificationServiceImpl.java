package bg.softuni.gira.service.impl;

import bg.softuni.gira.model.entity.Classification;
import bg.softuni.gira.model.entity.enumerated.ClassificationName;
import bg.softuni.gira.model.service.ClassificationServiceModel;
import bg.softuni.gira.repository.ClassificationRepository;
import bg.softuni.gira.service.ClassificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static bg.softuni.gira.constraint.Global.CLASSIFICATION_DESCRIPTION;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClassificationServiceImpl(ClassificationRepository classificationRepository, ModelMapper modelMapper) {
        this.classificationRepository = classificationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedClassification() {
        if (this.classificationRepository.count() == 0) {
            Arrays.stream(ClassificationName.values())
                    .forEach(classificationName -> {
                        Classification classification = new Classification();
                        classification.setClassificationName(classificationName);
                        classification.setDescription(String.format(CLASSIFICATION_DESCRIPTION, classificationName.getName()));
                        this.classificationRepository.saveAndFlush(classification);
                    });
        }
    }

    @Override
    public ClassificationServiceModel getClassificationByName(String classificationName) {

        Classification classification = this.classificationRepository
                .findByClassificationName(ClassificationName.valueOf(classificationName))
                .orElse(null);

        return classification != null ? this.modelMapper.map(classification, ClassificationServiceModel.class) : null;
    }
}
