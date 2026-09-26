package com.company.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.company.employee.bean.EmployeeBean;
import com.company.employee.util.DBUtil;

public class EmployeeDAO {

    public String addEmployee(EmployeeBean eb) {
        String result = "FAIL";
        try {
            Connection con = DBUtil.getDBConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO employee_tbl (emp_id, name, skill, score1, score2, score3, rating) VALUES (?,?,?,?,?,?,?)"
            );

            ps.setString(1, eb.getEmpId());
            ps.setString(2, eb.getName());
            ps.setString(3, eb.getSkill());
            ps.setInt(4, eb.getScore1());
            ps.setInt(5, eb.getScore2());
            ps.setInt(6, eb.getScore3());
            ps.setString(7, eb.getRating());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                result = "SUCCESS";
            }
        } catch (Exception e) {
            e.printStackTrace(); // IMPORTANT
        }
        return result;
    }
}
