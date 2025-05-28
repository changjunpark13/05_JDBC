package com.ohgiraffers.section01.statements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

// 이게 sql injection 이라고 함
public class Application3 {

    private static String empId = "200";
//    private static String empName = "홍길동";
    private static String empName = "'OR 1=1 AND EMP_ID = '200";

    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM EMPLOYEE WHERE emp_id = '" + empId + "' AND EMP_NAME = '" + empName + "'";
        System.out.println("query = " + query);

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
            } else {
                System.out.println("회원 정보가 없습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);

        }
    }
}
