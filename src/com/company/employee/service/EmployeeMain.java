package com.company.employee.service;

import com.company.employee.bean.EmployeeBean;
import com.company.employee.dao.EmployeeDAO;

public class EmployeeMain {

    public String addEmployee(EmployeeBean eb) {

        // Generate emp_id (IMPORTANT FIX)
        String empId = eb.getName().substring(0, 2).toUpperCase()
                     + (int)(Math.random() * 10000);
        eb.setEmpId(empId);

        // Calculate rating
        int total = eb.getScore1() + eb.getScore2() + eb.getScore3();

        if (total >= 240)
            eb.setRating("EXCELLENT");
        else if (total >= 180)
            eb.setRating("GOOD");
        else if (total >= 120)
            eb.setRating("AVERAGE");
        else
            eb.setRating("POOR");

        EmployeeDAO dao = new EmployeeDAO();
        String res = dao.addEmployee(eb);

        if (res.equals("SUCCESS")) {
            return eb.getEmpId() + ":" + eb.getRating();
        } else {
            return "ERROR";
        }
    }

    public static void main(String[] args) {

        EmployeeMain em = new EmployeeMain();

        EmployeeBean eb = new EmployeeBean();
        eb.setName("Ravi");
        eb.setSkill("Java");
        eb.setScore1(80);
        eb.setScore2(100);
        eb.setScore3(90);

        System.out.println(em.addEmployee(eb));
    }
}
