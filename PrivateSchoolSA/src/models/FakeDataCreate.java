package models;

public class FakeDataCreate {

    FakeDataCreate() {
    }

    public static void intializeLists() {
        //Initialize Students
        Student s1 = new Student("Klemens", "Habgood",
                ConvertDateLong.convertDate("05/12/1994"), 5000);
        Student s2 = new Student("Rina", "Vasilchenko",
                ConvertDateLong.convertDate("06/06/1994"), 5000);
        Student s3 = new Student("Tabina", "Steinhammer",
                ConvertDateLong.convertDate("20/08/1992"), 5000);
        Student s4 = new Student("Johanna", "Stanislaw",
                ConvertDateLong.convertDate("27/03/1994"), 5000);
        Student s5 = new Student("Leila", "Pierce",
                ConvertDateLong.convertDate("04/10/1993"), 5000);
        Student s6 = new Student("Marten", "Kowalski",
                ConvertDateLong.convertDate("05/09/1995"), 5000);
        Student s7 = new Student("Elladine", "Shorrock",
                ConvertDateLong.convertDate("22/08/1996"), 5000);
        Student s8 = new Student("Sanderson", "Tankard",
                ConvertDateLong.convertDate("07/04/1992"), 5000);
        Student s9 = new Student("Lindsy", "Matches",
                ConvertDateLong.convertDate("10/02/1995"), 5000);
        Student s10 = new Student("Teador", "Middup",
                ConvertDateLong.convertDate("27/11/1995"), 5000);

        AddDataLists.AddStudentsLists(s1);
        AddDataLists.AddStudentsLists(s2);
        AddDataLists.AddStudentsLists(s3);
        AddDataLists.AddStudentsLists(s4);
        AddDataLists.AddStudentsLists(s5);
        AddDataLists.AddStudentsLists(s6);
        AddDataLists.AddStudentsLists(s7);
        AddDataLists.AddStudentsLists(s8);
        AddDataLists.AddStudentsLists(s9);
        AddDataLists.AddStudentsLists(s10);

        //Initialize Courses
        TitleName course1 = new TitleName("Course1");
        TitleName course2 = new TitleName("Course2");

        long fullTimeStartDate = ConvertDateLong.convertDate("01/01/2021");
        long fullTimeEndDate = ConvertDateLong.convertDate("31/03/2021");
        long partTimeStartDate = ConvertDateLong.convertDate("01/01/2021");
        long partTimeEndDate = ConvertDateLong.convertDate("31/05/2021");

        Course c1 = new Course(course2, "Javascript", true,
                fullTimeStartDate, fullTimeEndDate);
        Course c2 = new Course(course2, "Javascript", false,
                fullTimeStartDate, fullTimeEndDate);
        Course c3 = new Course(course2, "Go", true,
                partTimeStartDate, partTimeEndDate);
        Course c4 = new Course(course2, "Go", false,
                partTimeStartDate, partTimeEndDate);
        Course c5 = new Course(course1, "PostgreSql", true,
                partTimeStartDate, partTimeEndDate);
        Course c6 = new Course(course1, "PostgreSql", false,
                partTimeStartDate, partTimeEndDate);
        Course c7 = new Course(course1, "Mysql", true,
                partTimeStartDate, partTimeEndDate);
        Course c8 = new Course(course1, "Mysql", false,
                partTimeStartDate, partTimeEndDate);

        AddDataLists.AddCourseList(c1);
        AddDataLists.AddCourseList(c2);
        AddDataLists.AddCourseList(c3);
        AddDataLists.AddCourseList(c4);
        AddDataLists.AddCourseList(c5);
        AddDataLists.AddCourseList(c6);
        AddDataLists.AddCourseList(c7);
        AddDataLists.AddCourseList(c8);

        //Initialize Trainer
        Trainer t1 = new Trainer("Corissa", "Abrahim", "Backend");
        Trainer t2 = new Trainer("Judith", "Howatt", "DataBase");
        Trainer t3 = new Trainer("Merry", "Kenewell", "Backend");
        Trainer t4 = new Trainer("Isahella", "Gockelen", "DataBase");
        Trainer t5 = new Trainer("Judith", "Howatt", "Backend");
        Trainer t6 = new Trainer("Merry", "Kenewell", "DataBase");
        Trainer t7 = new Trainer("Denys", "Lambden", "Backend");
        Trainer t8 = new Trainer("Neal", "Hairsnape", "DataBase");

        AddDataLists.AddTrainer(t1);
        AddDataLists.AddTrainer(t2);
        AddDataLists.AddTrainer(t3);
        AddDataLists.AddTrainer(t4);
        AddDataLists.AddTrainer(t5);
        AddDataLists.AddTrainer(t6);
        AddDataLists.AddTrainer(t7);
        AddDataLists.AddTrainer(t8);

        //Initialize Assignment
        TitleName title1 = new TitleName("Assignment1");
        TitleName title2 = new TitleName("Assignment2");
        TitleName title3 = new TitleName("Assignment3");
        TitleName title4 = new TitleName("Assignment4");

        Assignment a1 = new Assignment(title1, "Create an Assignment1",
                ConvertDateLong.convertDate("08/01/2021"));
        Assignment a2 = new Assignment(title2, "Create an Assignment2",
                ConvertDateLong.convertDate("16/01/2021"));
        Assignment a3 = new Assignment(title3, "Create an Assignment3",
                ConvertDateLong.convertDate("24/01/2021"));
        Assignment a4 = new Assignment(title4, "Create an Assignment4",
                ConvertDateLong.convertDate("02/02/2021"));
        AddDataLists.AddAssignment(a1);
        AddDataLists.AddAssignment(a2);
        AddDataLists.AddAssignment(a3);
        AddDataLists.AddAssignment(a4);

        //----------------------
        //Set Students per Course
        //student1
        ControllerData.setStudentsPCourse(c1, s1);
        ControllerData.setCoursesPStudent(s1, c1);

        ControllerData.setStudentsPCourse(c2, s1);
        ControllerData.setCoursesPStudent(s1, c2);

        ControllerData.setStudentsPCourse(c3, s1);
        ControllerData.setCoursesPStudent(s1, c3);

        //student2
        ControllerData.setStudentsPCourse(c1, s2);
        ControllerData.setCoursesPStudent(s2, c1);

        ControllerData.setStudentsPCourse(c3, s2);
        ControllerData.setCoursesPStudent(s2, c3);

        //student3
        ControllerData.setStudentsPCourse(c4, s3);
        ControllerData.setCoursesPStudent(s3, c4);

        ControllerData.setStudentsPCourse(c2, s3);
        ControllerData.setCoursesPStudent(s2, c2);

        //student4
        ControllerData.setStudentsPCourse(c5, s4);
        ControllerData.setCoursesPStudent(s4, c5);

        ControllerData.setStudentsPCourse(c5, s4);
        ControllerData.setCoursesPStudent(s4, c5);

        //student5
        ControllerData.setStudentsPCourse(c6, s5);
        ControllerData.setCoursesPStudent(s5, c6);

        //student6
        ControllerData.setStudentsPCourse(c7, s6);
        ControllerData.setCoursesPStudent(s6, c7);

        ControllerData.setStudentsPCourse(c8, s6);
        ControllerData.setCoursesPStudent(s6, c8);

        //student7
        ControllerData.setStudentsPCourse(c3, s7);
        ControllerData.setCoursesPStudent(s7, c3);

        ControllerData.setStudentsPCourse(c8, s7);
        ControllerData.setCoursesPStudent(s7, c8);

        //student8
        ControllerData.setStudentsPCourse(c4, s8);
        ControllerData.setCoursesPStudent(s8, c4);

        //student9
        ControllerData.setStudentsPCourse(c5, s9);
        ControllerData.setCoursesPStudent(s2, c5);

        //student10
        ControllerData.setStudentsPCourse(c7, s10);
        ControllerData.setCoursesPStudent(s10, c7);

        //Set Trainers per Course
        ControllerData.setTrainersPCourse(c4, t5);
        ControllerData.setTrainersPCourse(c3, t7);
        ControllerData.setTrainersPCourse(c2, t1);
        ControllerData.setTrainersPCourse(c1, t3);
        ControllerData.setTrainersPCourse(c7, t4);
        ControllerData.setTrainersPCourse(c8, t2);
        ControllerData.setTrainersPCourse(c5, t8);
        ControllerData.setTrainersPCourse(c6, t6);

        //Set Assignment per Course
        ControllerData.setAssignmentsPCourse(c1, a1);
        ControllerData.setAssignmentsPCourse(c1, a2);
        ControllerData.setAssignmentsPCourse(c1, a3);
        ControllerData.setAssignmentsPCourse(c1, a4);
        ControllerData.setAssignmentsPCourse(c2, a1);
        ControllerData.setAssignmentsPCourse(c2, a2);
        ControllerData.setAssignmentsPCourse(c2, a3);
        ControllerData.setAssignmentsPCourse(c2, a4);
        ControllerData.setAssignmentsPCourse(c3, a1);
        ControllerData.setAssignmentsPCourse(c3, a2);
        ControllerData.setAssignmentsPCourse(c3, a3);
        ControllerData.setAssignmentsPCourse(c3, a4);
        ControllerData.setAssignmentsPCourse(c4, a1);
        ControllerData.setAssignmentsPCourse(c4, a2);
        ControllerData.setAssignmentsPCourse(c4, a3);
        ControllerData.setAssignmentsPCourse(c4, a4);
        ControllerData.setAssignmentsPCourse(c5, a1);
        ControllerData.setAssignmentsPCourse(c5, a2);
        ControllerData.setAssignmentsPCourse(c5, a3);
        ControllerData.setAssignmentsPCourse(c5, a4);
        ControllerData.setAssignmentsPCourse(c6, a1);
        ControllerData.setAssignmentsPCourse(c6, a2);
        ControllerData.setAssignmentsPCourse(c6, a3);
        ControllerData.setAssignmentsPCourse(c6, a4);
        ControllerData.setAssignmentsPCourse(c7, a1);
        ControllerData.setAssignmentsPCourse(c7, a2);
        ControllerData.setAssignmentsPCourse(c7, a3);
        ControllerData.setAssignmentsPCourse(c7, a4);
        ControllerData.setAssignmentsPCourse(c8, a1);
        ControllerData.setAssignmentsPCourse(c8, a2);
        ControllerData.setAssignmentsPCourse(c8, a3);
        ControllerData.setAssignmentsPCourse(c8, a4);

    }
}
