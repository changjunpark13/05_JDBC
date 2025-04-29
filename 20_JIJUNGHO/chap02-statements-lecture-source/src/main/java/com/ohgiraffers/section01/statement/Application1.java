package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {
        // 트랜젝션 처리를 위한 DBMS 연동용 Connection 객체 생성
        Connection con = getConnection();
        System.out.println("con = " + con);


        Statement stmt = null;      // 쿼리를 운반하고 결과를 반환
        ResultSet rset = null;      // 조회할 예정(DML 작업이면 ResultSet 대신 int로 처리)

        // db console 연것과 같은 상태
//        stmt = con.createStatement();
        try {
            stmt = con.createStatement();
            // 쿼리문을 실행한 값을 rset에 담는다.
            rset = stmt.executeQuery("SELECT * FROM tbl_menu");

            // rset에 값이 있는지 반드시 확인해야한다.
            // while 안의 rset은 한 행을 의미
            while (rset.next()) {
                System.out.print(rset.getString("menu_name") + " ");
                System.out.print(rset.getInt("menu_price") + "원 \n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 생성의 역순으로 close()를 실행
            close(rset);
            close(stmt);
            close(con);
        }
    }

}
