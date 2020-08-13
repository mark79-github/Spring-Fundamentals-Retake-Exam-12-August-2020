package bg.softuni.gira.model.entity;

import bg.softuni.gira.model.entity.enumerated.ClassificaionName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{

    @Column(name = "classificaion_name", nullable = false)
    private ClassificaionName classificaionName;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Classification() {
    }

    public ClassificaionName getClassificaionName() {
        return classificaionName;
    }

    public void setClassificaionName(ClassificaionName classificaionName) {
        this.classificaionName = classificaionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
