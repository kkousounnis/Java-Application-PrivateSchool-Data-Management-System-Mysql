package models;

import controller.WelcomeScreen;
import dao.UserDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class UserInput {
   
    UserInput() {

    }

    public static void manualStudentsLists() {
        WelcomeScreen.clearConsole();
        Scanner sc = new Scanner(System.in);
        Person p = new Person();
        Student s;
        String[] student;
        if (multipleOrStepBystepInput()) {

            System.out.println("Please give me students first name.");
            p.setFirstName(checkStringInputLength());
            System.out.println("Please give me students last name.");
            p.setLastName(checkStringInputLength());
            System.out.println("Please give me students date of birth."
                    + "Type date of birth like this (DD/MM/YYY).");
            s = new Student(p.getFirstName(), p.getLastName());
            s.setDateOfBirth(checkDateInput());
            System.out.println("Please give me the tuition fees of student.");
            s.setTuitionFees(checkIntInput());
        } else {
            do {
                System.out.println("Give inputs with this priority \n-> "
                        + "[firsname lastname (DD/MM/YYY) tuitionfees]:");
                System.out.println("Warning there must be absolutely"
                        + " four inputs if not the system will"
                        + " ask you to retype all four inputs");
                System.out.println("Warning in third input below please"
                        + " enter DoB like this (DD/MM/YYY)\n");

                String allInputs = sc.nextLine();
                student = allInputs.split(" ");
            } while (student.length != 4);
            p.setFirstName(student[0]);
            p.setLastName(student[1]);
            s = new Student(p.getFirstName(), p.getLastName());

            s.setDateOfBirth(checkMultipleDateInput(student[2]));
            s.setTuitionFees(checkMultimpleIntInput(student[3]));

        }
        
        UserDao.addDbStudents(s);
        

    }

    public static void manualCourseList() { 
        Scanner sc = new Scanner(System.in);
        char tmp;
        TitleName t1;
        Course c;
        if (multipleOrStepBystepInput()) {
            WelcomeScreen.clearConsole();
            System.out.println("Please give the title of course.");
            t1 = new TitleName(checkStringInputLength());
            c = new Course(t1);
            System.out.println("Please give the name of course");
            c.setStream(checkStringInputLength());
//            do {
            System.out.println("Please type (f) if it is FullTime"
                    + " or type (p) if it is PartTime");
            tmp = sc.next().charAt(0);
//            } while (checkInputType(tmp) == false);
            c.setType(checkPartTimeFullTimeInput(tmp));
            System.out.println("Please give me the start date of the course");
            c.setStartDate(checkDateInput());
            System.out.println("Please give me the ending date of the course");
            c.setEndDate(checkDateInput());
        } else {
            String[] course;
            WelcomeScreen.clearConsole();
            do {
                System.out.println("[coursetitle stream (f)/(p) "
                        + "startdate enddate]");
                System.out.println("Warning there must be absolutely"
                        + " five inputs if not the system will"
                        + " ask you to retype all five inputs");
                System.out.println("Warning for third input."
                        + "Please type (f) if it is FullTime"
                        + " or type (p) if it is PartTime");
                String allInputs = sc.nextLine();
                course = allInputs.split(" ");
            } while (course.length != 5);
            t1 = new TitleName(course[0]);
            c = new Course(t1);
            c.setStream(course[1]);
            c.setType(checkPartTimeFullTimeInput(course[2].charAt(0)));
            c.setStartDate(checkMultipleDateInput(course[3]));
            c.setEndDate(checkMultipleDateInput(course[4]));

        }
        UserDao.addDbCourses(c);
        //AddDataLists.AddCourseList(c);
        

    }

    public static void manualTrainer() {
        Scanner sc = new Scanner(System.in);
        Person p = new Person();
        Trainer t;
        if (multipleOrStepBystepInput()) {

            System.out.println("Please give me trainers first name.");
            p.setFirstName(checkStringInputLength());
            System.out.println("Please give me trainers last name.");
            p.setLastName(checkStringInputLength());
            t = new Trainer(p.getFirstName(), p.getLastName());
            System.out.println("Please give me what subject the trainer teaches");
            t.setSubject(checkStringInputLength());
        } else {
            String[] trainer;
            do {
                System.out.println("[firstname lastname subject]");
                System.out.println("Warning there must be absolutely"
                        + " three inputs if not the system will"
                        + " ask you to retype all three inputs");
                String allInputs = sc.nextLine();
                trainer = allInputs.split(" ");
            } while (trainer.length != 3);
            p.setFirstName(trainer[0]);
            p.setLastName(trainer[1]);
            t = new Trainer(p.getFirstName(), p.getLastName());
            t.setSubject(trainer[2]);

        }

        AddDataLists.AddTrainer(t);
        if (AddDataLists.getArrCourse().size() > 0) {
            ControllerData.showCourses();
            System.out.println("Please tell me which course"
                    + " will the trainer teach");
            ControllerData.setTrainersPCourse(AddDataLists.getArrCourse().get(sc.nextInt() - 1), t);
        } else {
            System.out.println("\n---No courses have been assigned yet.---\n");
        }
    }

    public static void manualAssignment() {
        Scanner sc = new Scanner(System.in);
        TitleName title1;
        Assignment a;
        if (multipleOrStepBystepInput()) {
            System.out.println("Please give me the title of assignment");
            title1 = new TitleName(checkStringInputLength());

            a = new Assignment(title1);
            System.out.println("Please give me a description of assignment");
            a.setDescription(sc.nextLine());
            System.out.println("Please give me a date to assign ");
            a.setSubDateTime(checkDateInput());
        } else {
            String[] assignment;
            do {

                System.out.print("\nType like this ->");
                System.out.println("[assignmenttitle assignmentdate"
                        + " description(sentence) ]");
                System.out.println("");
                System.out.println("Warning there must be "
                        + " three inputs but in third input"
                        + " we can have a sentence consisted of 12 words.\n"
                        + "So you are allowed to type maximum 15 words.\n"
                        + "If they are more than fifteen words the system will"
                        + " ask you to retype all three inputs consisted of"
                        + " fifiteen words.\n"
                        + "For exampe type: --> Assignment1 01/01/2021"
                        + " Create a simple java program that prints"
                        + " hello world.");
                String allInputs = sc.nextLine();
                assignment = allInputs.split(" ");
            } while (assignment.length > 15);
            title1 = new TitleName(assignment[0]);
            a = new Assignment(title1);
            a.setSubDateTime(checkMultipleDateInput(assignment[1]));
            String s = "";
            for (int i = 2; i < assignment.length; i++) {
                s = s + " " + assignment[i];
            }

            a.setDescription(s);

        }
        AddDataLists.AddAssignment(a);
        if (AddDataLists.getArrCourse().size() > 0) {
            ControllerData.showCourses();
            System.out.println("Please tell to which course assignment belongs");
            ControllerData.setAssignmentsPCourse(AddDataLists.getArrCourse().get(sc.nextInt() - 1), a);
        } else {
            System.out.println("\n---No courses have been assigned yet.---\n");
        }
    }

    //------------
    //checks
    public static boolean checkInputType(char s) {
        switch (s) {
            case 'f':
                return true;
            case 'p':
                return true;
        }
        return false;
    }

    public static boolean decidePartFullTime(char s) {
        return (s == 'f');
    }

    public static boolean multipleOrStepBystepInput() {
        System.out.println("Choose the way you want to insert "
                + " your values");
        System.out.println("Type 1 for step by step input Press 2 "
                + "for multiple inputs");

        return (checkIntegerInput(2) == 1);
    }

    public static int checkIntegerInput(int x) {
        Scanner scan = new Scanner(System.in);
        boolean catchexception = false;
        int choice = 0;
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

    public static long checkDateInput() {
        Scanner scan = new Scanner(System.in);
        boolean correctFormat = false;
        String dateOB = "";
        do {
            System.out.println(" please enter date like this (DD/MM/YYY)");
            dateOB = scan.next();
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOB);
                //if date hase a correct format the program shall continue
                correctFormat = true;

            } catch (ParseException e) {

                correctFormat = false;
            }
        } while (!correctFormat);
        //i return date of birth as a string and 
        return ConvertDateLong.convertDate(dateOB);
    }

    public static LocalDate askUserDateToShowStudentsWeekAssignments() {
        Scanner scan = new Scanner(System.in);
        boolean correctFormat = false;
        String stringdate = "";
        DateTimeFormatter formatter;
        LocalDate localDate = null;
        Date date;
        do {
            System.out.println("Please enter the date you wish to see "
                    + "all relevant student assignments"
                    + "\nDate must be typed like this (DD/MM/YYY)");
            stringdate = scan.next();
            try {
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                date = new SimpleDateFormat("dd/MM/yyyy").parse(stringdate);
                localDate = LocalDate.parse(stringdate, formatter);

                //if date hase a correct format the program shall continue
                correctFormat = true;

            } catch (ParseException e) {

                correctFormat = false;
            }
        } while (!correctFormat);
        //i return date of birth as a string and 

        return localDate;
    }

    public static long checkMultipleDateInput(String dateOfBirth) {
        Scanner scan = new Scanner(System.in);
        boolean correctFormat = false;
        String dateOB = dateOfBirth;
        boolean firstTimePass = false;
        do {

            if (firstTimePass == true) {
                System.out.println(" please enter date like this (DD/MM/YYY)");
                dateOB = scan.next();
            }
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOB);
                //if date hase a correct format the program shall continue

                correctFormat = true;

            } catch (ParseException e) {
                firstTimePass = true;
                correctFormat = false;
            }
        } while (!correctFormat);
        //i return date of birth as a string and 
        return ConvertDateLong.convertDate(dateOB);
    }

    public static String checkStringInputLength() {
        Scanner scan = new Scanner(System.in);
        boolean correctFormat = false;

        String stringInput = "";
        do {
            stringInput = scan.nextLine();
            String[] stringSplit = stringInput.split(" ");

            if (stringSplit.length == 1) {
                correctFormat = true;
            } else {
                System.out.println("There must be only one word,"
                        + " spaces aren't allowed.Try again.");

            }

        } while (!correctFormat);

        return stringInput;
    }

    public static int checkIntInput() {
        Scanner in = new Scanner(System.in);

        // INPUT VALIDATION FOR INTEGERS AND POSITIVE NUMBERS
        int input = 0;
        boolean validationSuccessful = false;
        do {

            // validate that the input is an integer
            if (in.hasNextInt() == true) {
                input = in.nextInt();
            } else {
                System.out.print("Please enter an integer value: ");
                in.next();
                continue;
            }

            // validate that the input is positive
            if (input < 0) {
                System.out.print("Please print a POSITIVE integer: ");
                continue;
            } else {
                validationSuccessful = true;
            }
            System.out.println("The input is: " + input);
        } while (validationSuccessful == false);
        return input;
    }

    public static int checkMultimpleIntInput(String integerUserInput) {
        Scanner in = new Scanner(System.in);

        // INPUT VALIDATION FOR INTEGERS AND POSITIVE NUMBERS
        boolean validationSuccessful = false;
        do {

            // validate that the input is an integer
            try {
                Integer.parseInt(integerUserInput);
                validationSuccessful = true;
            } catch (NumberFormatException e) {
                System.out.print("Wrong input tuition fees. Please enter"
                        + " a correct integer value for tuition"
                        + " fees of student: ");
                integerUserInput = String.valueOf(checkIntInput());
                validationSuccessful = true;
            }

            System.out.println("The input is: " + Integer.parseInt(integerUserInput));
        } while (validationSuccessful == false);
        return Integer.parseInt(integerUserInput);
    }

    public static boolean checkPartTimeFullTimeInput(char c) {
        Scanner sc = new Scanner(System.in);
        while (checkInputType(c) == false) {
            System.out.println("Please type (f) if it is FullTime"
                    + " or type (p) if it is PartTime");
            c = sc.next().charAt(0);
        }
        return decidePartFullTime(c);
    }

    public static LocalDate[] getArrayCalendarWeekFromUserDate() {
        LocalDate[] arrayCalendarWeekFromUserDate = new LocalDate[2];
        LocalDate localdate = askUserDateToShowStudentsWeekAssignments();

        switch (localdate.getDayOfWeek()) {
            case MONDAY:
                arrayCalendarWeekFromUserDate[0] = localdate;

                arrayCalendarWeekFromUserDate[1] = localdate.plusDays(6);

                break;
            case TUESDAY:
                arrayCalendarWeekFromUserDate[0] = localdate.minusDays(1);

                arrayCalendarWeekFromUserDate[1] = localdate.plusDays(5);

                break;
            case WEDNESDAY:
                arrayCalendarWeekFromUserDate[0] = localdate.minusDays(2);

                arrayCalendarWeekFromUserDate[1] = localdate.plusDays(4);

                break;
            case THURSDAY:
                arrayCalendarWeekFromUserDate[0] = localdate.minusDays(3);

                arrayCalendarWeekFromUserDate[1] = localdate.plusDays(3);

                break;
            case FRIDAY:
                arrayCalendarWeekFromUserDate[0] = localdate.minusDays(4);

                arrayCalendarWeekFromUserDate[1] = localdate.plusDays(2);

                break;
            case SATURDAY:
                arrayCalendarWeekFromUserDate[0] = localdate.minusDays(5);

                arrayCalendarWeekFromUserDate[1] = localdate.plusDays(1);

                break;
            case SUNDAY:
                arrayCalendarWeekFromUserDate[0] = localdate.minusDays(6);

                arrayCalendarWeekFromUserDate[1] = localdate;

                break;
        }

        return arrayCalendarWeekFromUserDate;
    }

}
