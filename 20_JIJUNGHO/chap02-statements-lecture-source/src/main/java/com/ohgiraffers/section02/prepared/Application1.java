package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {
        Connection con = getConnection();

        /*
        PreparedStatement객체의 타입이 뭐에요 ?
                PreparedStatement타입이면서
        Statement타입이기도하다.
                == >상속구조이기 때문이고, 그래서 다형성을 적용할수있다.
        close(pstmt) == >Close(Statement simi = PreparedStatementEI)
        */

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt =con.prepareStatement("SELECT MENU_NAME, MENU_PRICE FROM tbl_menu");
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.printf("%s %d\n", rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"));
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
