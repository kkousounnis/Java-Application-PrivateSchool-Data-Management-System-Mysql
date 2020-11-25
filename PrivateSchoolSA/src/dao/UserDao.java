package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.AddDataLists;
import models.Assignment;
import models.ControllerData;
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //take from database students
    public static void showSudents() {
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
        TitleName titlename;
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
    public static void takeAssignmentsDb(){
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
}
