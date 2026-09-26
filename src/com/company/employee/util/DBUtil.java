package com.company.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getDBConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_db",
                "root",
                ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
