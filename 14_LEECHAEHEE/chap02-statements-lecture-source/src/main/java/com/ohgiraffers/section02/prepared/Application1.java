package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        // Statement의 자식 클래스이므로 JDBCTemlate의 Statement 매개변수로 하는
        // 메소드를 사용 가능하다.(동적바인딩, 상속 구조이므로 다형성 적용 가능, 업캐스팅)
        ResultSet rset = null;
        try {
            pstmt = con.prepareStatement("SELECT MENU_NAME, MENU_PRICE FROM tbl_menu");
            rset = pstmt.executeQuery();
            /* JDBC에서 SELECT문을 실행할 때 사용하는 메소드
            Statement객체일경우
            executeQuery(쿼리문);
            PreparedStatement객체일경우
            executeQuery(); */

            while (rset.next()) {
                System.out.printf("%s %d\n", rset.getString("menu_name"), rset.getInt(2));
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
