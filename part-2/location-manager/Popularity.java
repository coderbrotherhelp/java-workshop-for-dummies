public enum Popularity {
    LOW("Low"), MEDIUM("Medium"), HIGH("High");

    private String description;

    Popularity(String description) {
        this.description = description;
    }

    public String describe() {
        return description;
    }

    @Override
    public String toString() {
        return describe();
    }
}
