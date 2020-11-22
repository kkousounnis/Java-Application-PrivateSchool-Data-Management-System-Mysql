package models;

import java.util.ArrayList;

public class AssignmentsPCourse {

    private Course course;
    private final ArrayList<Assignment> arrAssignmentPCourse;

    AssignmentsPCourse() {
        arrAssignmentPCourse = new ArrayList<>();
    }

    AssignmentsPCourse(Course course) {
        this.course = course;
        arrAssignmentPCourse = new ArrayList<>();
    }

    public ArrayList<Assignment> getArrAssignmentPCourse() {
        return arrAssignmentPCourse;
    }

    public void addAssignmentPCourse(Assignment assignment) {
        this.arrAssignmentPCourse.add(assignment);
    }
}
