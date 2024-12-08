public enum Gender {
    Male("man"),
    Female("female");


    private String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
