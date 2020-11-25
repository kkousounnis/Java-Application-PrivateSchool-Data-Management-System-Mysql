package models;

public class TitleName {

    private String title;

    public TitleName(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return  title ;
    }

}
