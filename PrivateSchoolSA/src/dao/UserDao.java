package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.AddDataLists;
import models.Assignment;
import models.ConvertDateLong;
import models.Course;
import models.Student;
import models.TitleName;
import models.Trainer;
import util.DbUtil;

public class UserDao {

    private static Connection connection = DbUtil.getConnection();

    public UserDao() {

    }

    //add to database students
    public static void addDbStudents(Student s) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO `students`"
                    + "(`firstname`,"
                    + "`lastname`,"
                    + " `dateofbirth`,"
                    + " `tuitionfees`)"
                    + " VALUES (?,?,?,?)");

            preparedStatement.setString(1, s.getFirstName());
            preparedStatement.setString(2, s.getLastName());
            preparedStatement.setObject(
                    3, ConvertDateLong.convertLongToDataBaesFormat(
                            s.getDateOfBirth()));
            preparedStatement.setInt(4, s.getTuitionFees());

            preparedStatement.executeUpdate();
            System.out.println("Value of sstudent succesfully inserted "
                    + "to Database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //add to database courses
    public static void addDbCourses(Course c) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO `courses`"
                    + "(`title`,"
                    + "`stream`,"
                    + " `type`,"
                    + " `startdate`,"
                    + " `enddate`)"
                    + " VALUES (?,?,?,?,?)");

            preparedStatement.setObject(1, String.valueOf(c.getTitleName()));
            preparedStatement.setString(2, c.getStream());
            preparedStatement.setString(3, c.getType() ? "Fulltime" : "Parttime");
            preparedStatement.setObject(
                    4, ConvertDateLong.convertLongToDataBaesFormat(
                            c.getStartDate()));
            preparedStatement.setObject(
                    5, ConvertDateLong.convertLongToDataBaesFormat(
                            c.getEndDate()));

            preparedStatement.executeUpdate();
            System.out.println("Value of course succesfully inserted "
                    + "to Database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //add to database trainers
    public static void addDbTrainers(Trainer t) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO `trainers`"
                    + "(`firstname`,"
                    + "`lastname`,"
                    + " `subject`)"
                    + " VALUES (?,?,?)");

            preparedStatement.setString(1, t.getFirstName());
            preparedStatement.setString(2, t.getLastName());
            preparedStatement.setString(3, t.getSubject());

            preparedStatement.executeUpdate();
            System.out.println("Value of trainer succesfully inserted "
                    + "to Database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //add to database assignments
    public static void addDbAssignments(Assignment a) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO `assignments`"
                    + "(`title`,"
                    + "`description`,"
                    + " `subdatetime`,"
                    + "`oralmark`,"
                    + "`totalmark`)"
                    + " VALUES (?,?,?,?,?)");

            preparedStatement.setString(1, String.valueOf(a.getTitle()));
            preparedStatement.setString(2, a.getDescription());
            preparedStatement.setString(
                    3, ConvertDateLong.convertLongToDataBaesFormat(
                            a.getSubDateTime()));
            preparedStatement.setInt(4, a.getOralMark());
            preparedStatement.setInt(5, a.getTotalMark());

            preparedStatement.executeUpdate();
            System.out.println("Value of assignment succesfully inserted "
                    + "to Database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //take from database students
    public static void takeSudentsDb() {
        Student s;
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();

            rs = statement.executeQuery("SELECT * FROM `students`");

            while (rs.next()) {

                s = new Student(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        ConvertDateLong.convertDbDate(
                                rs.getDate("dateofbirth")),
                        rs.getInt("tuitionfees"));
                /*
                    Since the array list is static i add the new values one
                    time otherwise the array list would add the same values
                    again and again and we would have multiple times the same 
                    values.
                 */
                if (rs.getInt("Sid") > AddDataLists.getArrStudent().size()) {
                    AddDataLists.AddStudentsLists(s);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }

    //take from database courses
    public static void takeCoursesDb() {
        Course c;
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();

            rs = statement.executeQuery("SELECT * FROM `courses`");
            while (rs.next()) {
                c = new Course(
                        new TitleName(rs.getString("title")),
                        rs.getString("stream"),
                        (rs.getString("type").charAt(0) == 'F') ? true : false,
                        ConvertDateLong.convertDbDate(
                                rs.getDate("startdate")),
                        ConvertDateLong.convertDbDate(
                                rs.getDate("enddate")));
                /*
                    Since the array list is static i add the new values one
                    time otherwise the array list would add the same values
                    again and again and we would have multiple times the same 
                    values.
                 */
                if (rs.getInt("Cid") > AddDataLists.getArrCourse().size()) {
                    AddDataLists.AddCourseList(c);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    //take from database trainers
    public static void takeTrainersDb() {
        Trainer t;
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();

            rs = statement.executeQuery("SELECT * FROM `trainers`");
            while (rs.next()) {

                t = new Trainer(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("subject"));
                /*
                    Since the array list is static i add the new values one
                    time otherwise the array list would add the same values
                    again and again and we would have multiple times the same 
                    values.
                 */
                if (rs.getInt("Tid") > AddDataLists.getArrTrainer().size()) {
                    AddDataLists.AddTrainer(t);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    //take from database Assignments    
    public static void takeAssignmentsDb() {
        Assignment a;
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();

            rs = statement.executeQuery("SELECT * FROM `assignments`");
            while (rs.next()) {

                a = new Assignment(
                        new TitleName(rs.getString("title")),
                        rs.getString("description"),
                        ConvertDateLong.convertDbDate(rs.getDate("subdatetime")));
                /*
                    Since the array list is static i add the new values one
                    time otherwise the array list would add the same values
                    again and again and we would have multiple times the same 
                    values.
                 */
                if (rs.getInt("Aid") > AddDataLists.getArrAssignment().size()) {
                    AddDataLists.AddAssignment(a);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    //Insert to Database Students per Course
    public static void addDbStudentsPerCourse(int courseid, int studentid) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO `studentspercourses`"
                    + "(`id_course`,"
                    + "`id_student`)"
                    + " VALUES (?,?)");

            preparedStatement.setInt(1, courseid);
            preparedStatement.setInt(2, studentid);

            preparedStatement.executeUpdate();
            System.out.println("Assignment of students per course succesfully "
                    + "inserted to Database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Insert to Database Trainers per Course
    public static void addTrainersPerCourse(int courseid, int trainerid) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO `trainerspercourse`"
                    + "(`id_course`,"
                    + "`id_trainer`)"
                    + " VALUES (?,?)");

            preparedStatement.setInt(1, courseid);
            preparedStatement.setInt(2, trainerid);

            preparedStatement.executeUpdate();
            System.out.println("Assignment of trainers per course succesfully "
                    + "inserted to Database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Insert to Database Assignments per Course Per Student
    public static void addAssignmentsPerCoursePerStudent(int courseid, int assignmentid) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO `assignmentspercourse`"
                    + "(`id_course`,"
                    + "`id_assignment`)"
                    + " VALUES (?,?)");

            preparedStatement.setInt(1, courseid);
            preparedStatement.setInt(2, assignmentid);

            preparedStatement.executeUpdate();
            System.out.println("Assignment of assignments per course succesfully "
                    + "inserted to Database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Show students per Course from Database
    public static void showFromDbStudentsPerCourse() {
        Student student;
        Course course = null;
        Statement statement = null;
        ResultSet rs = null;
        int tmpcourseid = 0;
        try {
            statement = connection.createStatement();

            rs = statement.executeQuery(
                    "SELECT "
                    + "    `courses`.`Cid`,"
                    + "    `courses`.`title`,"
                    + "    `courses`.`stream`,"
                    + "    `courses`.`type`,"
                    + "     `courses`.`startdate`,"
                    + "     `courses`.`enddate`,"
                    + "    `students`.`firstname`,"
                    + "    `students`.`lastname`,"
                    + "    `students`.`dateofbirth`,"
                    + "    `students`.`tuitionfees`"
                    + "FROM"
                    + "    `studentspercourses`"
                    + "        INNER JOIN"
                    + "    `students` ON `students`.`Sid` = `studentspercourses`.`id_student`"
                    + "        INNER JOIN"
                    + "    `courses` ON `courses`.`Cid` = `studentspercourses`.`id_course`"
                    + "ORDER BY `courses`.`Cid`;");
            while (rs.next()) {

                if ((tmpcourseid != rs.getInt("Cid")) || tmpcourseid == 0) {
                    course = new Course(
                            new TitleName(rs.getString("title")),
                            rs.getString("stream"),
                            (rs.getString("type").charAt(0) == 'F') ? true : false,
                            ConvertDateLong.convertDbDate(
                                    rs.getDate("startdate")),
                            ConvertDateLong.convertDbDate(
                                    rs.getDate("enddate")));

                    System.out.println("\n\n" + course);

                    tmpcourseid = rs.getInt("Cid");
                }

                student = new Student(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        ConvertDateLong.convertDbDate(
                                rs.getDate("dateofbirth")),
                        rs.getInt("tuitionfees"));

                System.out.print(student);
            }
            System.out.println("");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    //Show trainers per Course from Database
    public static void showFromDbTrainersPerCourse() {
        Trainer trainer;
        Course course = null;
        Statement statement = null;
        ResultSet rs = null;
        int tmpcourseid = 0;
        try {
            statement = connection.createStatement();

            rs = statement.executeQuery(
                    "SELECT "
                    + "    `courses`.`Cid`,"
                    + "    `courses`.`title`,"
                    + "    `courses`.`stream`,"
                    + "    `courses`.`type`,"
                    + "    `courses`.`startdate`,"
                    + "    `courses`.`enddate`,"
                    + "    `trainers`.`firstname`,"
                    + "    `trainers`.`lastname`,"
                    + "    `trainers`.`subject`"
                    + "FROM"
                    + "    `trainerspercourse`"
                    + "        INNER JOIN"
                    + "    `trainers` ON `trainers`.`Tid` = `trainerspercourse`.`id_trainer`"
                    + "        INNER JOIN"
                    + "    `courses` ON `courses`.`Cid` = `trainerspercourse`.`id_course`"
                    + "ORDER BY `courses`.`Cid`;");
            while (rs.next()) {

                if ((tmpcourseid != rs.getInt("Cid")) || tmpcourseid == 0) {
                    course = new Course(
                            new TitleName(rs.getString("title")),
                            rs.getString("stream"),
                            (rs.getString("type").charAt(0) == 'F') ? true : false,
                            ConvertDateLong.convertDbDate(
                                    rs.getDate("startdate")),
                            ConvertDateLong.convertDbDate(
                                    rs.getDate("enddate")));

                    System.out.println("\n\n" + course);

                    tmpcourseid = rs.getInt("Cid");
                }

                trainer = new Trainer(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("subject"));

                System.out.print(trainer);
            }
            System.out.println("");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    //Show assignments per Course from Database
    public static void showFromDbAssignmentssPerCourse() {
        Assignment assignment;
        Course course = null;
        Statement statement = null;
        ResultSet rs = null;
        int tmpcourseid = 0;
        try {
            statement = connection.createStatement();

            rs = statement.executeQuery(
                    "SELECT "
                    + "    `courses`.`Cid`,"
                    + "    `courses`.`title`,"
                    + "    `courses`.`stream`,"
                    + "    `courses`.`type`,"
                    + "    `courses`.`startdate`,"
                    + "    `courses`.`enddate`,"
                    + "    `assignments`.`title`,"
                    + "    `assignments`.`description`,"
                    + "    `assignments`.`subdatetime`"
                    + "FROM"
                    + "    `assignmentspercourse`"
                    + "        INNER JOIN"
                    + "    `assignments` ON `assignments`.`Aid` = `assignmentspercourse`.`id_assignment`"
                    + "        INNER JOIN"
                    + "    `courses` ON `courses`.`Cid` = `assignmentspercourse`.`id_course`"
                    + "ORDER BY `courses`.`Cid`;");
            while (rs.next()) {

                if ((tmpcourseid != rs.getInt("Cid")) || tmpcourseid == 0) {
                    course = new Course(
                            new TitleName(rs.getString("title")),
                            rs.getString("stream"),
                            (rs.getString("type").charAt(0) == 'F') ? true : false,
                            ConvertDateLong.convertDbDate(
                                    rs.getDate("startdate")),
                            ConvertDateLong.convertDbDate(
                                    rs.getDate("enddate")));

                    System.out.println("\n\n" + course);

                    tmpcourseid = rs.getInt("Cid");
                }

                assignment = new Assignment(
                        new TitleName(rs.getString("title")),
                        rs.getString("description"),
                        ConvertDateLong.convertDbDate(rs.getDate("subdatetime")));

                System.out.print(assignment);
            }
            System.out.println("");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    //Show assignments per Course from Database
    public static void showFromDbAssignmentssPerCoursePerStudent() {
        Assignment assignment;
        Student student = null;
        Course course = null;
        Statement statement = null;
        ResultSet rs = null;
        int tmpcourseid = 0;
        int tmpstudentid = 0;
        try {
            statement = connection.createStatement();

            rs = statement.executeQuery(
                      "SELECT "
                    + "    `assignmentspercourse`.`id_assignment`,"
                    + "    `assignments`.`title` AS `assignmenttile`,"
                    + "    `assignments`.`description`,"
                    + "    `assignments`.`subdatetime`,"
                    + "    `courses`.`Cid`,"
                    + "    `courses`.`title` AS `coursetitle`,"
                    + "    `courses`.`stream`,"
                    + "    `courses`.`type`,"
                    + "    `courses`.`startdate`,"
                    + "    `courses`.`enddate`,"
                    + "    `students`.`Sid`,"
                    + "    `students`.`firstname`,"
                    + "    `students`.`lastname`,"
                    + "    `students`.`dateofbirth`,"
                    + "    `students`.`tuitionfees`"
                    + "FROM"
                    + "    `assignmentspercourse`"
                    + "        INNER JOIN"
                    + "    `assignments` ON `assignments`.`Aid` = `assignmentspercourse`.`id_assignment`"
                    + "        INNER JOIN"
                    + "    `courses` ON `courses`.`Cid` = `assignmentspercourse`.`id_course`"
                    + "        INNER JOIN"
                    + "    `studentspercourses` ON `studentspercourses`.`id_course` = `courses`.`Cid`"
                    + "        INNER JOIN"
                    + "    `students` ON `students`.`Sid` = `studentspercourses`.`id_student`"
                    + "ORDER BY `courses`.`Cid` , `students`.`Sid` , `assignments`.`Aid`;");
            while (rs.next()) {
                
                if ((tmpstudentid != rs.getInt("Sid")) || tmpstudentid == 0) {
                    student = new Student(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        ConvertDateLong.convertDbDate(
                                rs.getDate("dateofbirth")),
                        rs.getInt("tuitionfees"));
                    System.out.println("\n\n" + student);
                    
                    tmpstudentid = rs.getInt("Sid");
                    tmpcourseid = 0;
                }
                if ((tmpcourseid != rs.getInt("Cid")) || tmpcourseid == 0) {
                    
                    course = new Course(
                            new TitleName(rs.getString("coursetitle")),
                            rs.getString("stream"),
                            (rs.getString("type").charAt(0) == 'F') ? true : false,
                            ConvertDateLong.convertDbDate(
                                    rs.getDate("startdate")),
                            ConvertDateLong.convertDbDate(
                                    rs.getDate("enddate")));

                    System.out.println(course);

                    tmpcourseid = rs.getInt("Cid");
                }

                assignment = new Assignment(
                        new TitleName(rs.getString("assignmenttile")),
                        rs.getString("description"),
                        ConvertDateLong.convertDbDate(rs.getDate("subdatetime")));

                System.out.print(assignment);
            }
            System.out.println("");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
