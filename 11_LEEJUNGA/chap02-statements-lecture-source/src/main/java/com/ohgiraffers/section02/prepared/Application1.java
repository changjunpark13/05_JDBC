package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/*
* JDBC에서 SELECT문을 실행할 때 사용하는 메소드
* Statement객체일경우
* executeQuery(쿼리문)
*
* PreparedStatement 객체일경우
* executeQuery()
* */

public class Application1 {
    public static void main(String[] args) {
        Connection conn = getConnection();

        // PreparedStatement 객체의 타입이 뭐에요?
        // PreparedStatement 타입이면서 Statement 타입이기도 하다.
        // => 상속구조이기 떄문이고, 그래서 다형성을 적용할 수 있다.
        // close(pstmt) => Close(Statement stmt = new PreparedStatement())
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = conn.prepareStatement("SELECT MENU_NAME, MENU_PRICE FROM tbl_menu");
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.printf("%s %d\n", rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(conn);
        }
    }
}
