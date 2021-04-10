package Practice08.State;

public enum StatusName {
    NEW("новый"),
    SEND("отправлен"),
    DELIVERED("доставлен");

    private String statusName;

    private StatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
