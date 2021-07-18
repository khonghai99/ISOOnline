package com.bkav.isoonline.models;

import com.bkav.isoonline.Controller.JDBCController;
import com.bkav.isoonline.Session.Golobal;

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
            //list.add(new Trouble(rs.getString("Name"),rs.getString("ProblemEmergencyName"),rs.getString("ProblemTypeName"),rs.getString("CriticalLevelName"),rs.getString("ProblemGroupName"),rs.getString("Description"),dateCreate,rs.getInt("Reporter"),rs.getString("ContactNumber"),rs.getString("ReporterEmail"),rs.getString("Receiver"),rs.getString("ResidentAgencyName")));

        }
        connection.close();
        return list;
    }
    public List<Trouble> getTroubleBundlelist() throws SQLException, ParseException {

        String sql = "select DISTINCT\n" +
                "      p.Name\n" +
                "\t  ,e.ProblemEmergencyName\n" +
                "\t  ,t.ProblemTypeName\n" +
                "\t  ,c.CriticalLevelName as CriticalLevelName\n" +
                "\t  ,g.ProblemGroupName\n" +
                "      ,p.Description\n" +
                "\t  ,s.ProblemStatusName\n" +
                "      ,p.CreatedAt\n" +
                "      ,[Reporter]\n" +
                "      ,p.ContactNumber\n" +
                "      ,p.ReporterEmail\n" +
                "      ,p.Receiver\n" +
                "\t  ,r.Name as ResidentAgencyName\n" +
                "from V3ProblemEvent as p\n" +
                "left join V3ProblemEventUser as u on  u.ProblemEventID = p.ID\n" +
                "left join V3ProblemType as t on p.ProblemTypeID = t.ID\n" +
                "left join V3ProblemStatus as s on p.StatusID = s.ID\n" +
                "left join V3ProblemEmergency as e on p.EmergencyTypeID = e.ID\n" +
                "left join V3ProblemCriticalLevel as c on p.CriticalLevelID = c.ID\n" +
                "left join V3ProblemGroup as g on p.ProblemGroupID = g.ID\n" +
                "left join V3ProblemResidentAgency as r on p.ResidentAgencyID = r.ID\n" +
                "where \n" +
                "(u.HumanEmployeeID =" + Golobal.getIdUser() +" or p.Receiver = " + Golobal.getIdUser() +")\n" +
                "and (p.IsDelete = 0 or p.IsDelete is null)";

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
            //list.add(new Trouble(rs.getString("Name"),rs.getString("ProblemEmergencyName"),dateCreate));
            list.add(new Trouble(rs.getString("Name"),rs.getString("ProblemEmergencyName"),rs.getString("ProblemTypeName"),rs.getString("CriticalLevelName"),rs.getString("ProblemGroupName"),rs.getString("Description"),dateCreate,rs.getString("Reporter"),rs.getString("ContactNumber"),rs.getString("ReporterEmail"),rs.getString("Receiver"),rs.getString("ResidentAgencyName"),rs.getString("ProblemStatusName")));

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
