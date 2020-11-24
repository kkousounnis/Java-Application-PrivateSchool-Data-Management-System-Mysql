package models;

import interfaces.ICourse;

public class Course implements ICourse{

    private TitleName title;
    private String stream;
    private boolean type;
    private long startDate;
    private long endDate;
    public StudentsPCourse studentsPerCourse;
    public TrainersPCourse trainerPerCourse;
    public AssignmentsPCourse assignmentPerCourse;

    Course(TitleName title) {
        this.title = title;
        this.studentsPerCourse = new StudentsPCourse();
        this.trainerPerCourse = new TrainersPCourse();
        this.assignmentPerCourse = new AssignmentsPCourse();
    }

    Course(TitleName title, String stream, boolean type,
            long startDate, long endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentsPerCourse = new StudentsPCourse();
        this.trainerPerCourse = new TrainersPCourse();
        this.assignmentPerCourse = new AssignmentsPCourse();

    }

    @Override
    public TitleName getTitle() {
        return title;
    }

    @Override
    public String getStream() {
        return stream;
    }

    @Override
    public void setStream(String stream) {
        this.stream = stream;
    }

    @Override
    public boolean getType() {
        return type;
    }

    @Override
    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public long getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    @Override
    public long getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public static String checkType(boolean b) {
        return (b == true) ? "FullTime" : "PartTime";
    }

    @Override
    public String toString() {
        return "Course{" + " title=" + title
                + ", stream=" + stream
                + ", type=" + checkType(type)
                + ", startDate=" + ConvertDateLong.convertLong(startDate)
                + ", endDate=" + ConvertDateLong.convertLong(endDate) + '}';
    }
}
