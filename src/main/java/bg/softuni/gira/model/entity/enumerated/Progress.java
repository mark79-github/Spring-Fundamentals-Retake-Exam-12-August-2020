package bg.softuni.gira.model.entity.enumerated;

public enum Progress {
    OPEN("Open"),
    IN_PROGRESS("In progress"),
    COMPLETED("Completed"),
    OTHER("Other");

    private String type;

    Progress(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
