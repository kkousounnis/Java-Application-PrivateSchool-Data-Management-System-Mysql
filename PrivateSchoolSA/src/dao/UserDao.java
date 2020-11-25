package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.AddDataLists;
import models.ControllerData;
import models.ConvertDateLong;
import models.Course;
import models.Student;
import util.DbUtil;

public class UserDao {

    private static Connection connection;

    public UserDao() {
        connection = DbUtil.getConnection();
    }

    public static void main(String[] args) {
        UserDao s = new UserDao();
        s.showSudents();
        ControllerData.showStudents();

    }

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
    
    public static void addDbCourses(Course c){
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
            preparedStatement.setObject(4,ConvertDateLong.convertLongToDataBaesFormat(c.getStartDate()));                     
            preparedStatement.setObject(5,ConvertDateLong.convertLongToDataBaesFormat(c.getEndDate()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showSudents() {
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
                if (rs.getInt("Sid") > AddDataLists.getArrStudent().size()) {
                    AddDataLists.AddStudentsLists(s);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }

}
