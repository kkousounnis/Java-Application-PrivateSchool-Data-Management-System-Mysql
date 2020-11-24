package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.AddDataLists;
import models.ControllerData;
import models.ConvertDateLong;
import models.Student;
import util.DbUtil;

public class UserDao {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDao() {
        connection = DbUtil.getConnection();
    }

    public static void main(String[] args) {
        UserDao s = new UserDao();
        s.showSudents();
        ControllerData.showStudents();

    }

    public void example() {
        String coursetitle = "course1";
        String stream = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `privateschool`.`courses` where title=?");
            preparedStatement.setString(1, coursetitle);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                stream = rs.getString("stream");
                System.out.println(stream);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDbStudents(Student s) {
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

    public void showSudents() {
        Student s;
        try {
            preparedStatement
                    = connection.prepareStatement("SELECT * FROM `students`");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                s = new Student(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        ConvertDateLong.convertDbDate(rs.getDate("dateofbirth")),
                        rs.getInt("tuitionfees"));
                AddDataLists.AddStudentsLists(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
