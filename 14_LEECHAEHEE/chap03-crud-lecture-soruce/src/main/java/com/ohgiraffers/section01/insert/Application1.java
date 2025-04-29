package com.ohgiraffers.section01.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application1 {

    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;

        String sql = "insert into tbl_menu(menu_name, menu_price, category_code, orderable_status) values(?,?,?,?)";
        int result = 0;  // insert, update, delete 시에는 수행된 행의 개수를 int로 반환

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "봉골레청국장");
            pstmt.setInt(2, 12000);
            pstmt.setInt(3, 4);
            pstmt.setString(4, "Y");

            result = pstmt.executeUpdate();        // insert,update,delete 시에는 executeUpdate() 사용
            System.out.println(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }



    }
}
