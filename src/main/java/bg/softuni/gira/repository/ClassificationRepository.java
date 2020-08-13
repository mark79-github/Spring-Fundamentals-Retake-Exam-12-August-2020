package bg.softuni.gira.repository;

import bg.softuni.gira.model.entity.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, String> {
}
