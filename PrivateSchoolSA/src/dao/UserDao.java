package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.AddDataLists;
import models.ControllerData;
import models.ConvertDateLong;
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

    public void addDbStudents(Student s) {
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

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
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
                        ConvertDateLong.convertDbDate(rs.getDate("dateofbirth")),
                        rs.getInt("tuitionfees"));
                AddDataLists.AddStudentsLists(s);
            }

            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
        }

    }

}
