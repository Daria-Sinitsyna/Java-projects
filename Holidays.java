public enum Holidays {
    NewYear("New Year"),
    March8("8 March"),
    February23("23 February");

    private String title;

    Holidays(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
