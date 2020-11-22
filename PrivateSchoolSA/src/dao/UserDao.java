package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DbUtil;

public class UserDao {

    private Connection connection;

    public UserDao() {
        connection = DbUtil.getConnection();
    }

    public static void main(String[] args) {
        UserDao s = new UserDao();
        s.example();
    }
    public void example(){
        String coursetitle="course1";
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

}
