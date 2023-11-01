package com.codegym.thai_foody_casestudy_module03.Model.DAO;

import com.codegym.thai_foody_casestudy_module03.Connection.JdbcConnection;
import com.codegym.thai_foody_casestudy_module03.Model.DAO.Impl.InterfaceStoreDAO;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.Store;
import com.codegym.thai_foody_casestudy_module03.Model.Utils.SQL_Exception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO implements InterfaceStoreDAO {

    public static StoreDAO getInstance () {
        return new StoreDAO();
    }
    private static final String SELECT_ALL_STORES = "SELECT * FROM store";

    private static final  String SELECT_STORE_BY_ID = "SELECT * FROM store WHERE id = ? ";
    @Override
    public List<Store> getAll() {
        List<Store> stores = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STORES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int phoneNumber = rs.getInt("phone");
                float qualityIndex = rs.getFloat("quality_index");
                String district = rs.getString("district");
                String openHours = rs.getString("open_hours");
                String closedHours = rs.getString("closed_hours");
                String imageUrl = rs.getString("image_url");
                stores.add(new Store(id,name,type,phoneNumber,district,qualityIndex,openHours,closedHours,imageUrl));
            }
        } catch (SQLException e) {
            SQL_Exception.printSQLException(e);
        }
        return stores;
    }
    @Override
    public Store getStoreByID(long id) {
        Store store = null;
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STORE_BY_ID);) {
            preparedStatement.setLong(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                int phoneNumber = rs.getInt("phone");
                float qualityIndex = rs.getFloat("quality_index");
                String district = rs.getString("district");
                String openHours = rs.getString("open_hours");
                String closedHours = rs.getString("closed_hours");
                String imageUrl = rs.getString("image_url");
                store = new Store(id,name,type,phoneNumber,district,qualityIndex,openHours,closedHours,imageUrl);
            }
        }  catch (SQLException e) {
            SQL_Exception.printSQLException(e);
        }
       return  store;
    }



}
