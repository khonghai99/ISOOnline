package com.bkav.isoonline.models;

import com.bkav.isoonline.Controller.JDBCController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TroubleModel {
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public TroubleModel() {
        connection = jdbcController.ConnnectionData();
    }

    public List<Trouble> getTroublelist(String sql) throws SQLException, ParseException {
        List<Trouble> list = new ArrayList<>();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String dateCreate = "";
            if(rs.getString("CreatedAt") != "") {
                String[] date = rs.getString("CreatedAt").split(" ");
                String[] date1 = date[0].split("-");
                dateCreate = date1[2] + "/" + date1[1] + "/" + date1[0];
            }
            list.add(new Trouble(rs.getString("Name"),rs.getString("ProblemEmergencyName"),dateCreate));
        }
        connection.close();
        return list;
    }

/*    public boolean Insert(User objUser) throws SQLException {
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
    }*/
}
