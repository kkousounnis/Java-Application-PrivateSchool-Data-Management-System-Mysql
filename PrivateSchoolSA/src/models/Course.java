package models;

public class Course {

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

    public TitleName getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

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
