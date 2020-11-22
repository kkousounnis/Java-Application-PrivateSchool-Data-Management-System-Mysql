package models;

import java.util.ArrayList;

public class CoursesPStudent {

    private Student student;
    private ArrayList<Course> arrCoursesPStudent;

    CoursesPStudent() {
        arrCoursesPStudent = new ArrayList<>();
    }

    CoursesPStudent(Student student) {
        this.student = student;
        this.arrCoursesPStudent = new ArrayList<>();
    }

    public ArrayList<Course> getArrCoursesPStudent() {
        return arrCoursesPStudent;
    }

    public void AddStudentsPCourse(Course c) {
        //arrCoursesPStudent = new ArrayList<>();
        this.arrCoursesPStudent.add(c);
    }

}
