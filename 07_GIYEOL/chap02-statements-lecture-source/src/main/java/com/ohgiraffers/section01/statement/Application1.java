package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {
    /*트랜잭션 처리를 위한 DBMS 연동용 Connection 객체 생성*/
        Connection con = getConnection();
        System.out.println("con = " + con);

        Statement stmt = null; //쿼리를 운반하고 결과를 반환
        ResultSet rset = null; //조회할 예정(DML 직업이면 Rseultset 대신 int로 처리)

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT * FROM tbl_menu");

            /*while 문 안의 rset은 한 행을 의미*/
            while (rset.next()) {
                System.out.print(rset.getString("menu_name") + " ");
                System.out.print(rset.getInt("menu_price") + " \n ");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(stmt);
            close(con);
        }

    }
}
