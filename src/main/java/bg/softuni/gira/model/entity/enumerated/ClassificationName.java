package bg.softuni.gira.model.entity.enumerated;

public enum ClassificationName {
    BUG("Bug"),
    FEATURE("Feature"),
    SUPPORT("Support"),
    OTHER("Other");

    private String name;

    ClassificationName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
