package com.ohgiraffers.section01.statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application4 {

    private static String empId = "200";
    // private static String empName = "홍길동";
    private static String empName = "'OR 1=1 AND EMP_ID = '200";  // 이 값은 더 이상 쿼리에 영향을 못 줌 (SQL Injection 차단됨)

    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM EMPLOYEE WHERE emp_id = ? AND EMP_NAME = ?";

        try {
            pstmt = con.prepareStatement(query); // 미리 쿼리 구조를 정의
            pstmt.setString(1, empId);           // 첫 번째 ?에 empId 대입
            pstmt.setString(2, empName);         // 두 번째 ?에 empName 대입

            System.out.println("Prepared Query 실행 중...");

            rset = pstmt.executeQuery();

            if (rset.next()) {
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
            } else {
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
