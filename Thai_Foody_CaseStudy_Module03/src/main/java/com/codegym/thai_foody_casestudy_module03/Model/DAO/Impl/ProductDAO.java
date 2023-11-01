package com.codegym.thai_foody_casestudy_module03.Model.DAO.Impl;

import com.codegym.thai_foody_casestudy_module03.Connection.JdbcConnection;
import com.codegym.thai_foody_casestudy_module03.Model.DAO.InterfaceProductDAO;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.Product;
import com.codegym.thai_foody_casestudy_module03.Model.Utils.SQL_Exception;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements InterfaceProductDAO {

    private static final String SELECT_PRODUCT_BY_STORE_ID = "SELECT * FROM product WHERE store_id = ?";

    public static ProductDAO getInstance() {
        return new ProductDAO();
    }
    @Override
    public List<Product> getListProductByStoreId( long storeId) {
        List<Product> products = new ArrayList<>();
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_STORE_ID);) {
            preparedStatement.setLong(1,storeId);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String productName = resultSet.getString("name");
                int productPrice = resultSet.getInt("price");
                String imageURL  = resultSet.getString("image_url");
                products.add(new Product(id,productName,productPrice,imageURL));
            }
        } catch (SQLException e) {
            SQL_Exception.printSQLException(e);
        }
        return products;
    }


}
