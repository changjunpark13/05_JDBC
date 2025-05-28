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

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = con.prepareStatement("SELECT MENU_NAME, MENU_PRICE FROM tbl_menu");
            rset = pstmt.executeQuery();  // 쿼리 실행

            while (rset.next()) {
                // 데이터 출력: 메뉴 이름과 가격
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
