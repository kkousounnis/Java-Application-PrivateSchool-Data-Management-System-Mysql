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

    public static void setStudentsPCourse(Course c, Student s) {
        c.studentsPerCourse.AddStudentsPCourse(s);
    }

    public static void setTrainersPCourse(Course c, Trainer t) {
        c.trainerPerCourse.addTrainersPCourse(t);
    }

    public static void setAssignmentsPCourse(Course c, Assignment a) {
        c.assignmentPerCourse.addAssignmentPCourse(a);
    }

    public static void setCoursesPStudent(Student s, Course c) {
        s.coursesPStudent.AddStudentsPCourse(c);
    }

    public static void showStudentsPCourse() {
        WelcomeScreen.clearConsole();
        System.out.println("---Students Per Course---");
        for (Course c : AddDataLists.getArrCourse()) {
            System.out.println(c);
            System.out.println(c.studentsPerCourse.getArrStudentsPCourse());
        }
    }

    public static void showTrainersPCourse() {
        WelcomeScreen.clearConsole();
        System.out.println("---Trainer Per Course---");
        for (Course c : AddDataLists.getArrCourse()) {
            System.out.println(c);
            System.out.println(c.trainerPerCourse.getTrainersPCourseList());
            System.out.println(" ");
        }
    }

    public static void showAssignmentsPCourse() {
        WelcomeScreen.clearConsole();
        System.out.println("---Assignments Per Course---");
        for (Course c : AddDataLists.getArrCourse()) {
            System.out.println(c);
            System.out.println(c.assignmentPerCourse.getArrAssignmentPCourse());
            System.out.println("");
        }
    }
    public static void showStudentAssignments(Student s) {
        WelcomeScreen.clearConsole();
        System.out.println("---Students Per Assignment---");
        System.out.println(s);
        for (Course c : s.coursesPStudent.getArrCoursesPStudent()) {
            System.out.println(c);
            System.out.println(c.assignmentPerCourse.getArrAssignmentPCourse());
            System.out.println(" ");
        }
    }

    public static void showStudentsMultipleCourses() {
        WelcomeScreen.clearConsole();
        System.out.println("---Students who Attend Multiple Courses---");
        for (Student student : AddDataLists.getArrStudent()) {
            if (student.coursesPStudent.getArrCoursesPStudent().size() > 1) {
                System.out.println(student);
                System.out.println("Attends the courses below:");
                System.out.println(student.coursesPStudent.getArrCoursesPStudent());
                System.out.println(" ");
            }
        }

    }
    public static void showStudentsAssignmentsRelevantToGivenDate(){
        WelcomeScreen.clearConsole();
        LocalDate[] userdate = UserInput.getArrayCalendarWeekFromUserDate();
        
        for(Student s : AddDataLists.getArrStudent()){
            
            for (Course c : s.coursesPStudent.getArrCoursesPStudent()) {                 
                 for (Assignment a : c.assignmentPerCourse.getArrAssignmentPCourse()) {
                     String tmpDate = ConvertDateLong.convertLongToOriginalFormat(a.getSubDateTime());
//                     
                     if( ConvertDateLong.convertStringToLocaleDate(tmpDate).isAfter(userdate[0]) 
                             && ConvertDateLong.convertStringToLocaleDate(tmpDate).isBefore(userdate[1])){
                         System.out.println(s);
                         System.out.println(c);
                         System.out.println("During period "+userdate[0]
                                 +" to "+ userdate[1]);                         
                         System.out.println(s.getFirstName()+" "+s.getLastName()
                                 + " has to deliver the "
                                 + "assignments bellow.");
                         System.out.println(a);
                         System.out.println("");
                     
                     }
                 }
                
            }
            
        }
    }    

}
