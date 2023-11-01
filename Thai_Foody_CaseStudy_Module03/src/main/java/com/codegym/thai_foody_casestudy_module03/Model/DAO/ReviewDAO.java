package com.codegym.thai_foody_casestudy_module03.Model.DAO;

import com.codegym.thai_foody_casestudy_module03.Connection.JdbcConnection;
import com.codegym.thai_foody_casestudy_module03.Model.DAO.Impl.InterfaceReviewDAO;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.Review;
import com.codegym.thai_foody_casestudy_module03.Model.Utils.SQL_Exception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements InterfaceReviewDAO {
    public static ReviewDAO getInstance() {
        return new ReviewDAO();
    }

    private static final String INSERT_REVIEW = "INSERT INTO REVIEWS (REVIEW_TEXT,USER_ID,STORE_ID) VALUES(?,?,?)";
    private static final String SELECT_REVIEWS_BY_STORE_ID =

            "SELECT USER.NAME, USER.IMAGE_URL, REVIEW_TEXT, DATE_FORMAT(created_at, '%M %d, %Y') AS review_time " +
                    " FROM REVIEWS " +
                    " JOIN USER ON REVIEWS.USER_ID = USER.ID " +
                    "JOIN STORE ON REVIEWS.STORE_ID = STORE.ID WHERE  STORE.ID = ?;";

    @Override
    public boolean insertReview(Review review) {
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REVIEW)) {
            preparedStatement.setString(1, review.getReview_text());
            preparedStatement.setLong(2, review.getUserId());
            preparedStatement.setLong(3, review.getStoreId());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            SQL_Exception.printSQLException(e);
        }
        return false;
    }

    @Override
    public List<Review> getListReviewsByStoreId(long id) {
        List<Review> listUsersReviewAtStore = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEWS_BY_STORE_ID)) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String review_text = resultSet.getString("review_text");
                String created_at = resultSet.getString("review_time");
                String userName = resultSet.getString("name");
                String user_imageURL = resultSet.getString("image_url");
                listUsersReviewAtStore.add(new Review(review_text,created_at,userName,user_imageURL));
            }

        } catch (SQLException e) {
            SQL_Exception.printSQLException(e);
        }
        return listUsersReviewAtStore;
    }
}
