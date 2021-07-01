package com.bkav.isoonline.models;

import com.bkav.isoonline.Controller.JDBCController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akinosora on 16/11/2017.
 */

public class UserModel {

    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public UserModel() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }

    public List<User> getuserlist(String account, String pass, String idas) throws SQLException {
        List<User> list = new ArrayList<>();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select HumanUsers.ID,HumanEmployees.Name from HumanUsers, HumanEmployees where Account = '" + account + "'  and HumanUsers.ID = HumanEmployees.ID";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new User(rs.getString("Name"), rs.getInt("ID")));// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        return list;
    }

    public boolean Insert(User objUser) throws SQLException {
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "insert in to User(Name) values(" + objUser.getName() + ")";
        if (statement.executeUpdate(sql) > 0) { // Dùng lệnh executeUpdate cho các lệnh CRUD
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
        }
    }

    public boolean Update(User objUser) throws SQLException {
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "Update User set Name = " + objUser.getName() + " where ID = " + objUser.getID();
        if (statement.executeUpdate(sql) > 0) {
            connection.close();
            return true;
        } else
            connection.close();
        return false;
    }

    public boolean Delete(User objUser) throws SQLException {
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "delete from User where ID = " + objUser.getID();
        if (statement.executeUpdate(sql) > 0){
            connection.close();
            return true;
        }

        else
            connection.close();
        return false;
    }

}
