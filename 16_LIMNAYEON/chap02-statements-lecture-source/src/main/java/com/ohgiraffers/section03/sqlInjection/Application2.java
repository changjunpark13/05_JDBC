package com.ohgiraffers.section01.statement;

import java.sql.*;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application4 {

    private static String empId = "200";
    private static String empName = "' OR 1=1 AND emp_id = '200";

    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM employee WHERE emp_id = ? AND emp_name = ?";
        System.out.println("query = " + query);

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, empId);
            pstmt.setString(2, empName);

            rset = pstmt.executeQuery();

            if(rset.next()) {
                System.out.println(rset.getString("emp_name") + "님 환영합니다.");
            }else {
                System.out.println("회원 정보가 없습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

    }
}
