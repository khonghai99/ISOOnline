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

public class ReportModel {
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public ReportModel() {
        connection = jdbcController.ConnnectionData();
    }

    public List<Report> getTroublelist() throws SQLException, ParseException {
        String Sql = "select  p.ID,p.ProblemEventID,p.Name,p.Content,[From],[To],p.Reporter as ReporterID, emp.Name as ReporterName,p.ReportDate,s.ProblemStatusName,[Percent]\n" +
                "from V3ProblemEventReport as p \n" +
                "join HumanEmployees as emp on p.Reporter = emp.ID \n" +
                "join V3ProblemStatus as s on p.Status = s.ID\n" +
                "join V3ProblemEvent as pe on pe.ID = p.ProblemEventID\n" +
                "where p.ProblemEventID = 1075";
        List<Report> list = new ArrayList<>();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(Sql);
        while (rs.next()) {
            String dateCreate = "";
            if(rs.getString("ReportDate") != "") {
                String[] date = rs.getString("ReportDate").split(" ");
                String[] date1 = date[0].split("-");
                dateCreate = date1[2] + "/" + date1[1] + "/" + date1[0];
            }
            list.add(new Report(rs.getInt("ID"),rs.getInt("ProblemEventID"),rs.getString("Name"),rs.getString("Content"),rs.getString("From"),rs.getString("To"),rs.getInt("ReporterID"),rs.getString("ReporterName"),dateCreate,rs.getString("ProblemStatusName"),rs.getString("Percent")));
            //list.add(new Trouble(rs.getString("Name"),rs.getString("ProblemEmergencyName"),rs.getString("ProblemTypeName"),rs.getString("CriticalLevelName"),rs.getString("ProblemGroupName"),rs.getString("Description"),dateCreate,rs.getInt("Reporter"),rs.getString("ContactNumber"),rs.getString("ReporterEmail"),rs.getString("Receiver"),rs.getString("ResidentAgencyName")));

        }
        connection.close();
        return list;
    }
}
