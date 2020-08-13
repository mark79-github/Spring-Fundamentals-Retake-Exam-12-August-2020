package bg.softuni.gira.model.entity.enumerated;

public enum ClassificaionName {
    BUG("Bug"),
    FEATURE("Feature"),
    SUPPORT("Support"),
    OTHER("Other");

    private String name;

    ClassificaionName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
