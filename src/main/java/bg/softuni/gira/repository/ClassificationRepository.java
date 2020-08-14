package bg.softuni.gira.repository;

import bg.softuni.gira.model.entity.Classification;
import bg.softuni.gira.model.entity.enumerated.ClassificationName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, String> {
    Optional<Classification> findByClassificationName(ClassificationName classificationName);
}
