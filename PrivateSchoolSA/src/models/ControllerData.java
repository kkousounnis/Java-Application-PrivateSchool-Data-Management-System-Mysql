package models;

import controller.WelcomeScreen;
import java.time.LocalDate;

public class ControllerData {

    ControllerData() {

    }

    public static void showStudents() {
        WelcomeScreen.clearConsole();
        System.out.println("---Students---");
        for (int i = 0; i < AddDataLists.getArrStudent().size(); i++) {
            System.out.println((i + 1) + ": " + AddDataLists.getArrStudent().get(i));
        }
    }

    public static void showCourses() {
        WelcomeScreen.clearConsole();
        System.out.println("---Courses---");
        for (int i = 0; i < AddDataLists.getArrCourse().size(); i++) {
            System.out.println((i + 1) + ": " + AddDataLists.getArrCourse().get(i));
        }
    }

    public static void showTrainers() {
        WelcomeScreen.clearConsole();
        System.out.println("Trainers");
        for (int i = 0; i < AddDataLists.getArrTrainer().size(); i++) {
            System.out.println((i + 1) + ": " + AddDataLists.getArrTrainer().get(i));
        }
    }

    public static void showAssignments() {
        WelcomeScreen.clearConsole();
        System.out.println("Assignments");
        for (int i = 0; i < AddDataLists.getArrAssignment().size(); i++) {
            System.out.println((i + 1) + ": " + AddDataLists.getArrAssignment().get(i));
        }
    }

}
