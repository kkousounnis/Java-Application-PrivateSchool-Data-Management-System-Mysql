package models;

import java.util.ArrayList;

public class AddDataLists {

    private static final ArrayList<Student> arrStudent = new ArrayList<Student>();
    private static final ArrayList<Trainer> arrTrainer = new ArrayList<Trainer>();
    private static final ArrayList<Course> arrCourse = new ArrayList<Course>();
    private static final ArrayList<Assignment> arrAssignment = new ArrayList<Assignment>();

    AddDataLists() {

    }

    public static ArrayList<Student> getArrStudent() {
        return arrStudent;
    }

    public static ArrayList<Trainer> getArrTrainer() {
        return arrTrainer;
    }

    public static ArrayList<Course> getArrCourse() {
        return arrCourse;
    }

    public static ArrayList<Assignment> getArrAssignment() {
        return arrAssignment;
    }

    public static void AddStudentsLists(Student s) {
        arrStudent.add(s);
    }

    public static void AddCourseList(Course c) {
        arrCourse.add(c);
    }

    public static void AddTrainer(Trainer t) {
        arrTrainer.add(t);
    }

    public static void AddAssignment(Assignment a) {
        arrAssignment.add(a);
    }

}
