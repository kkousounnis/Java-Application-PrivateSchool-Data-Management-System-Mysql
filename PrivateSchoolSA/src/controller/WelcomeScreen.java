package controller;

import dao.UserDao;
import java.util.Scanner;
import models.*;

public class WelcomeScreen {

    public Scanner scan = new Scanner(System.in);
    private int choice = 0;
    UserDao ud = new UserDao();

    public WelcomeScreen() {

        Menu();
    }

    public void Menu() {
        clearConsole();
        showWelcomeMenu();
        //i assigned to 3 because i only 1,2 choices 
        this.choice = checkIntegerInput(2);
        switch (this.choice) {
            case 1:
                mainMenu();
                break;
            case 2:
                System.out.println("Goodbey!!!");
                break;
        }
    }

    public void mainMenu() {
        clearConsole();
        showMainMenu();
        //i assigned to 3 because i only 1,2,3,4,5 choices 
        this.choice = checkIntegerInput(6);
        switch (this.choice) {
            case 1:
                clearConsole();
                courseMenu();
                break;
            case 2:
                clearConsole();
                studentMenu();
                break;
            case 3:
                clearConsole();
                trainerMenu();
                break;
            case 4:
                clearConsole();
                assignmentMenu();
                break;
            case 5:
                clearConsole();
                Menu();
                break;
            case 6:
                System.out.println("Goodbey!!!");
                break;
        }

    }

    public void courseMenu() {

        showCourseMenu();
        //i assigned to 3 because i only 1,2,3,4,5,6 choices 
        this.choice = checkIntegerInput(6);
        switch (this.choice) {
            case 1:
                UserInput.manualCourseList();
                courseMenu();
                break;
            case 2:
                ControllerData.showCourses();
                courseMenu();
                break;
            case 3:
                ControllerData.showStudentsPCourse();
                courseMenu();
                break;
            case 4:
                ControllerData.showTrainersPCourse();
                courseMenu();
                break;
            case 5:
                ControllerData.showAssignmentsPCourse();
                courseMenu();
                break;
            case 6:
                clearConsole();
                mainMenu();
                break;
        }

    }

    public void studentMenu() {

        showStudentMenu();
        //i assigned to 3 because i only 1,2,3,4,5,6 choices 
        int courseIndex;
        int studentIndex;
        this.choice = checkIntegerInput(6);
        switch (this.choice) {
            case 1:
                clearConsole();
                UserInput.manualStudentsLists();
                studentMenu();
                break;
            case 2:
                clearConsole();
                ud.showSudents();
                ControllerData.showStudents();
                studentMenu();
                break;
            case 3:
                clearConsole();
                if (AddDataLists.getArrCourse().size() > 0) {
                    ControllerData.showStudents();
                    System.out.println("Please specify student "
                            + " from List by typing number");
                    studentIndex = checkIntegerInput(AddDataLists.getArrStudent().size());
                    ControllerData.showCourses();
                    System.out.println("Please tell me to which course"
                            + " will the student attend please type number of course.");
                    courseIndex = checkIntegerInput(AddDataLists.getArrCourse().size());
                    ControllerData.setStudentsPCourse(AddDataLists.getArrCourse().get(courseIndex - 1),
                            AddDataLists.getArrStudent().get(studentIndex - 1));
                    ControllerData.setCoursesPStudent(AddDataLists.getArrStudent().get(studentIndex - 1), AddDataLists.getArrCourse().get(courseIndex - 1));
                } else {
                    System.out.println("\n---No courses have been assigned yet.---\n");
                }
                studentMenu();
                break;
            case 4:
                clearConsole();
                //assignment to do show student assignments
                clearConsole();
                if (AddDataLists.getArrStudent().size() > 0) {
                    ControllerData.showStudents();
                    System.out.println("Please specify student from List"
                            + "  in order to see his assignments "
                            + "by typing number");
                    studentIndex = checkIntegerInput(AddDataLists.getArrStudent().size());
                    System.out.println("Assignments");
                    ControllerData.showStudentAssignments(AddDataLists.getArrStudent().get(studentIndex - 1));
                } else {
                    System.out.println("\n---No student list"
                            + " have been assigned yet.---\n");
                }
                studentMenu();
                break;

            case 5:
                clearConsole();
                if (AddDataLists.getArrCourse().size() > 1) {
                    // show students who attend in more than one course                
                    ControllerData.showStudentsMultipleCourses();
                    System.out.println("");
                } else {
                    System.out.println("\n---No multiple courses have"
                            + " been assigned yet.---\n");
                    ControllerData.showCourses();
                    System.out.println("We must have more than two"
                            + " courses assigned.\n");
                    System.out.println(" PLease go to course menu"
                            + " and assign more than 1 course.Then go"
                            + " to student menu and assign students to more"
                            + " than one course");
                }
                studentMenu();
                break;
            case 6:
                clearConsole();
                mainMenu();
                break;
        }

    }

    public void trainerMenu() {

        showTrainerMenu();
        //i assigned to 3 because i only 1,2,3,4,5,6 choices 
        this.choice = checkIntegerInput(6);
        switch (this.choice) {
            case 1:
                clearConsole();
                UserInput.manualTrainer();
                trainerMenu();
                break;
            case 2:
                clearConsole();
                ControllerData.showTrainers();
                trainerMenu();
                break;
            case 3:
                clearConsole();
                if (AddDataLists.getArrCourse().size() > 0) {
                    ControllerData.showTrainers();
                    System.out.println("Please specify trainer "
                            + " from List by typing number");
                    int trainerIndex = checkIntegerInput(AddDataLists.getArrTrainer().size());
                    ControllerData.showCourses();
                    System.out.println("Please tell me to which course"
                            + " will the trainer attend please type number of course.");
                    int courseIndex = checkIntegerInput(AddDataLists.getArrCourse().size());
                    ControllerData.setTrainersPCourse(AddDataLists.getArrCourse().get(courseIndex - 1),
                            AddDataLists.getArrTrainer().get(trainerIndex - 1));
                } else {
                    System.out.println("\n---No courses have been assigned yet.---\n");
                }
                trainerMenu();
                break;
            case 4:
                clearConsole();
                mainMenu();
                break;
        }

    }

    public void assignmentMenu() {

        showAssignmentMenu();
        //i assigned to 3 because i only 1,2,3,4 choices 
        this.choice = checkIntegerInput(6);
        switch (this.choice) {
            case 1:
                clearConsole();
                UserInput.manualAssignment();
                assignmentMenu();
                break;
            case 2:
                clearConsole();
                ControllerData.showAssignments();
                assignmentMenu();
                break;
            case 3:
                clearConsole();
                if (AddDataLists.getArrCourse().size() > 0) {
                    ControllerData.showAssignments();
                    System.out.println("Please specify trainer "
                            + " from List by typing number");
                    int assignmentIndex = checkIntegerInput(AddDataLists.getArrAssignment().size());
                    ControllerData.showCourses();
                    System.out.println("Please tell me to which course"
                            + " will the assignmetn attend please type number of course.");
                    int courseIndex = checkIntegerInput(AddDataLists.getArrCourse().size());
                    ControllerData.setAssignmentsPCourse(AddDataLists.getArrCourse().get(courseIndex - 1),
                            AddDataLists.getArrAssignment().get(assignmentIndex - 1));
                } else {
                    System.out.println("\n---No courses have been assigned yet.---\n");
                }
                assignmentMenu();
                break;
            case 4:
                clearConsole();
                //UserInput.getArrayCalendarWeekFromUserDate();
                if (AddDataLists.getArrCourse().size() > 0) {
                    ControllerData.showStudentsAssignmentsRelevantToGivenDate();
                } else {
                    System.out.println("\n---No courses have been assigned yet.---\n");
                }
                assignmentMenu();
                break;
            case 5:
                clearConsole();
                mainMenu();
                break;
        }

    }

    public void showWelcomeMenu() {
        System.out.println("---Welcome to Privete SchoolSA"
                + " where every dream becomes a reality---");
        for (int i = 0; i < 2; i++) {
            System.out.println("---                              "
                    + "                                 ---");
        }
        System.out.println("\nDescription of School");
        System.out.println("This is a private school which offers"
                + " intensive lessons for someone who desires"
                + " to learn.");
        System.out.println("Please choose how would you like to proceed.");
        System.out.println("1: Proceed Insert/Assign Main Menu.");
        System.out.println("2: Terminate.");
    }

    public void showMainMenu() {
        System.out.println("       Main Menu      ");
        System.out.println("Please choose how would you like to proceed");
        System.out.println("1: Proceed to Course Menu.");
        System.out.println("2: Proceed to Student Menu.");
        System.out.println("3: Proceed to Trainer Menu.");
        System.out.println("4: Proceed to Assignment Menu.");
        System.out.println("5: Return to strat Menu.");
        System.out.println("6: Terminate.");

    }

    public void showCourseMenu() {
        System.out.println("       Course Menu      ");
        System.out.println("Please choose how would you like to proceed");
        System.out.println("1: Course Manualy create.");
        System.out.println("2: Show all courses.");
        System.out.println("3: Show students per course.");
        System.out.println("4: Show trainers per course.");
        System.out.println("5: Show assignments per course.");
        System.out.println("6: Return.");
    }

    public void showStudentMenu() {
        System.out.println("       Student Menu      ");
        System.out.println("Please choose how would you like to proceed");
        System.out.println("1: Create Manually student.");
        System.out.println("2: Show all students.");
        System.out.println("3: Choose student which lessons will attend.");
        System.out.println("4: Show student assignments");
        System.out.println("5: Show students who attend in"
                + " more than one course.");
        System.out.println("6: Return.");
    }

    void showTrainerMenu() {
        System.out.println("       Trainer Menu      ");
        System.out.println("Please choos how would you like to proceed.");
        System.out.println("1: Create Manually trainer.");
        System.out.println("2: Show all trainers");
        System.out.println("3: Choose trainer which course teaches.");
        System.out.println("4: Return.");
    }

    public void showAssignmentMenu() {
        System.out.println("       Assignment Menu      ");
        System.out.println("Please choose how would you like to proceed");
        System.out.println("1: Create manually assignment.");
        System.out.println("2: Show all assignments.");
        System.out.println("3: Choose course for assignment.");
        System.out.println("4: Give date and show students with"
                + " all relevant student assignments.");
        System.out.println("5: Return.");

    }

    public int checkIntegerInput(int x) {
        boolean catchexception = false;
        this.choice = 0;
        do {
            System.out.print("Enter a number to proceed : ");
            if (scan.hasNextInt()) {

                choice = scan.nextInt();
                if (choice >= 1 & choice <= x) {
                    catchexception = true;
                } else {
                    scan.nextLine();
                    System.out.println("Enter a valid Integer value");
                }
            } else {
                scan.nextLine();
                System.out.println("Enter a valid Integer value");
            }
        } while (!catchexception);
        return choice;
    }

    public static void clearConsole() {
        for (int i = 0; i < 80; i++) // Default Height of cmd is 300 and Default width is 80
        {
            System.out.println("");
        }
    }

    public static void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}
