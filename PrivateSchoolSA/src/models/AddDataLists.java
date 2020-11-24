package models;

import java.util.ArrayList;

public class AddDataLists {

    private static ArrayList<Student> arrStudent = new ArrayList<>();
    private static final ArrayList<Trainer> arrTrainer = new ArrayList<>();
    private static final ArrayList<Course> arrCourse = new ArrayList<>();
    private static final ArrayList<Assignment> arrAssignment = new ArrayList<>();

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
