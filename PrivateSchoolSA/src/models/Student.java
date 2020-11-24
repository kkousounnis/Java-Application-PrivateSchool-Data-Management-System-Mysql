package models;

public class Student extends Person {

    private long dateOfBirth;
    private int tuitionFees;
    public CoursesPStudent coursesPStudent;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
        this.coursesPStudent = new CoursesPStudent();
    }

    public Student(String firstName, String lastName, long dateOfBirth, int tuitionFees) {
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
        this.coursesPStudent = new CoursesPStudent();
    }

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        return "Student{" +  super.getFirstName() + super.getLastName()
                + ", dateOfBirth=" + ConvertDateLong.convertLong(dateOfBirth)
                + ", tuitionFees=" + tuitionFees + '}';
    }

}
