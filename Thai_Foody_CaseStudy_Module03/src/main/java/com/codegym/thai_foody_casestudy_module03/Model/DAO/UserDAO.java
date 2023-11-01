package com.codegym.thai_foody_casestudy_module03.Model.DAO;

import com.codegym.thai_foody_casestudy_module03.Connection.JdbcConnection;
import com.codegym.thai_foody_casestudy_module03.Model.DAO.Impl.InterfaceUserDAO;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.User;
import com.codegym.thai_foody_casestudy_module03.Model.Utils.SQL_Exception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements InterfaceUserDAO {

    private static final String INSERT_USER = "INSERT INTO USER (NAME,PASSWORD,EMAIL,PHONE_NUMBER) VALUES(?,?,?,?)";

    private static final String SELECT_USER_BY_EMAIL_OR_PHONE = "SELECT * FROM USER WHERE (PHONE_NUMBER = ? OR EMAIL = ?) AND PASSWORD = ?; ";

    public static UserDAO getInstance() {
        return new UserDAO();
    }

    //    Nếu để ở DTB ràng buộc la UNIQUE thì khi mà chúng ta insert trùng nó sẽ trả về false
    @Override
    public boolean insert(User user) {
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassWord());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            SQL_Exception.printSQLException(e);
        }
        return false;
    }

    @Override

    public User getUserByEmailOrPhoneAndPassWord(String loginName, String passWord) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_OR_PHONE)) {
            preparedStatement.setString(1, loginName);
            preparedStatement.setString(2, loginName);
            preparedStatement.setString(3, passWord);
//            Lúc này resultSet sẽ trả về 1 record có đối tượng trùng với câu lệnh query
            ResultSet resultSet = preparedStatement.executeQuery();
//            Sau đó dùng .next để đi qua từng collum của đối tượng để set vào đối tượng của mình
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassWord(resultSet.getString("password"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setImageURl(resultSet.getString("image_url"));
                return user;
            }
        } catch (SQLException e) {
            SQL_Exception.printSQLException(e);
        }
        return null;
    }


}



