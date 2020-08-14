package bg.softuni.gira.init;

import bg.softuni.gira.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppData implements CommandLineRunner {

    private final ClassificationService classificationService;

    @Autowired
    public AppData(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.classificationService.seedClassification();
    }
}
