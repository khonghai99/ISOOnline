package com.bkav.isoonline.Controller;
import com.bkav.isoonline.Data.JDBCModel;

import java.sql.Connection;


public class JDBCController {
    public  JDBCModel JdbcModel = new JDBCModel();

    public Connection ConnnectionData() {
        return JdbcModel.getConnectionOf();
    }
}