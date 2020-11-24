package models;

import interfaces.IAssignment;

public class Assignment implements IAssignment{

    private TitleName title;
    private String description;
    private long subDateTime;
    private int oralMark;
    private int totalMark;

    Assignment(TitleName title) {
        this.title = title;
    }

    Assignment(TitleName title, String description,
            long subDateTime) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(long subDateTime) {
        this.subDateTime = subDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        return "Assignment{" 
                + "title=" + title 
                + ", description=" + description 
                + ", subDateTime=" + ConvertDateLong.convertLong(subDateTime) 
                + ", oralMark=" + oralMark 
                + ", totalMark=" + totalMark + '}';
    }
    

}
