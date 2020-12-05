package menu;

import database.DataAccess;
import java.util.Scanner;
import models.*;

public class WelcomeScreen {

    public Scanner scan = new Scanner(System.in);
    private int choice = 0;

    public WelcomeScreen() {

        Menu();
    }

    public void Menu() {
        clearConsole();
        showWelcomeMenu();
        //i assigned to 2 because i only 1,2 choices 
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
        //i assigned to 6 because i only 1,2,3,4,5,6 choices 
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
        //i assigned to 6 because i only 1,2,3,4,5,6 choices 
        this.choice = checkIntegerInput(6);
        switch (this.choice) {
            case 1:
                UserInput.manualCourseList();
                pressAnyKeyToContinue();
                courseMenu();
                break;
            case 2:
                DataAccess.selectCourses();                 
                pressAnyKeyToContinue();
                courseMenu();
                break;
            case 3:
                //To do here i must call the proper query
                DataAccess.showFromDbStudentsPerCourse();
                pressAnyKeyToContinue();
                courseMenu();
                break;
            case 4:
                DataAccess.showFromDbTrainersPerCourse();
                pressAnyKeyToContinue();
                courseMenu();
                break;
            case 5:
                DataAccess.showFromDbAssignmentssPerCourse();
                pressAnyKeyToContinue();
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
        //i assigned to 6 because i only 1,2,3,4,5,6 choices 
        int courseIndex;
        int studentIndex;
        this.choice = checkIntegerInput(6);
        switch (this.choice) {
            case 1:
                clearConsole();
                UserInput.manualStudentsLists();
                pressAnyKeyToContinue();
                studentMenu();
                break;
            case 2:
                //clearConsole();
                DataAccess.selectSudents();
                //PrintListData.showStudents();
                pressAnyKeyToContinue();
                studentMenu();
                break;
            case 3:
                clearConsole();
                //AddDataLists.getArrStudent().size()
                if (DataAccess.selectCourses() > 0) {
                    clearConsole();
                    int length = DataAccess.selectSudents();
                    //PrintListData.showStudents();
                    System.out.println("Please specify student "
                            + " from List by typing number");
                    studentIndex = checkIntegerInput(length);
                    length = DataAccess.selectCourses();
                    System.out.println("Please tell me to which course"
                            + " will the student attend please type number of course.");
                    courseIndex = checkIntegerInput(length);

                    DataAccess.addDbStudentsPerCourse(courseIndex, studentIndex);

                } else {
                    System.out.println("\n---No courses have been assigned yet.---\n");
                }
                studentMenu();
                break;
            case 4:
                clearConsole();
                
                if (DataAccess.selectSudents() > 0) {                     
                      clearConsole();
                      DataAccess.showFromDbAssignmentssPerCoursePerStudent();
                } else {
                    System.out.println("\n---No student list"
                            + " have been assigned yet.---\n");
                }
                pressAnyKeyToContinue();
                studentMenu();
                break;

            case 5:
                clearConsole();
                if (DataAccess.selectCourses() > 1) {
                    // show students who attend in more than one course
                    clearConsole();
                    DataAccess.showStudentsMultipleCourses();
                    System.out.println("");
                } else {
                    System.out.println("\n---No multiple courses have"
                            + " been assigned yet.---\n");
                    DataAccess.selectCourses();
                    System.out.println("We must have more than two"
                            + " courses assigned.\n");
                    System.out.println(" PLease go to course menu"
                            + " and assign more than 1 course.Then go"
                            + " to student menu and assign students to more"
                            + " than one course");
                }
                pressAnyKeyToContinue();
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
                pressAnyKeyToContinue();
                trainerMenu();
                break;
            case 2:
                clearConsole();
                DataAccess.selectTrainers();
                //PrintListData.showTrainers();
                pressAnyKeyToContinue();
                trainerMenu();
                break;
            case 3:
                clearConsole();
                if (DataAccess.selectCourses() > 0) {
                    clearConsole();
                    int length = DataAccess.selectTrainers();
                    System.out.println("Please specify trainer "
                            + " from List by typing number");
                    int trainerIndex = checkIntegerInput(length);
                    length = DataAccess.selectCourses();
                    System.out.println("Please tell me to which course"
                            + " will the trainer attend please type number of course.");
                    int courseIndex = checkIntegerInput(length);

                    DataAccess.addTrainersPerCourse(courseIndex, trainerIndex);
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
        //i assigned to 4 because i only 1,2,3,4 choices 
        this.choice = checkIntegerInput(4);
        switch (this.choice) {
            case 1:
                clearConsole();
                UserInput.manualAssignment();
                pressAnyKeyToContinue();
                assignmentMenu();
                break;
            case 2:
                clearConsole();
                DataAccess.selectAssignments();
                //PrintListData.showAssignments();
                pressAnyKeyToContinue();
                assignmentMenu();
                break;
            case 3:
                clearConsole();
                if (DataAccess.selectCourses() > 0) {
                    clearConsole();
                    int length = DataAccess.selectAssignments();
                    System.out.println("Please specify assignments "
                            + " from List by typing number");
                    int assignmentIndex = checkIntegerInput(length);
                    length = DataAccess.selectCourses();
                    System.out.println("Please tell me to which course"
                            + " will the assignmetn attend please type number of course.");
                    int courseIndex = checkIntegerInput(length);

                    DataAccess.addAssignmentsPerCoursePerStudent(
                            courseIndex, assignmentIndex);
                } else {
                    System.out.println("\n---No courses have been assigned yet.---\n");
                }
                assignmentMenu();
                break;
            case 4:
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
        System.out.println("1: Proceed to Main Menu and Insert/Assign Data.");
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
        System.out.println("1: Course Manualy create and insert to Database.");
        System.out.println("2: Show a list of all courses.");
        System.out.println("3: Show all students per course.");
        System.out.println("4: Show all trainers per course.");
        System.out.println("5: Show all assignments per course.");
        System.out.println("6: Return.");
    }

    public void showStudentMenu() {
        System.out.println("       Student Menu      ");
        System.out.println("Please choose how would you like to proceed");
        System.out.println("1: Create Manually student and insert to Database.");
        System.out.println("2: Show a list of all the students.");
        System.out.println("3: Assign students per course.");
        System.out.println("4: Show assignments per course per student");
        System.out.println("5: Show students who attend in"
                + " more than one course.");
        System.out.println("6: Return.");
    }

    void showTrainerMenu() {
        System.out.println("       Trainer Menu      ");
        System.out.println("Please choos how would you like to proceed.");
        System.out.println("1: Create Manually trainer and insert to Database.");
        System.out.println("2: Show all trainers");
        System.out.println("3: Assign trainers per course.");
        System.out.println("4: Return.");
    }

    public void showAssignmentMenu() {
        System.out.println("       Assignment Menu      ");
        System.out.println("Please choose how would you like to proceed");
        System.out.println("1: Create manually assignment and insert to"
                + "Database.");
        System.out.println("2: Show all assignments.");
        System.out.println("3: Assign assignments per student per course.");
        System.out.println("4: Return.");

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
