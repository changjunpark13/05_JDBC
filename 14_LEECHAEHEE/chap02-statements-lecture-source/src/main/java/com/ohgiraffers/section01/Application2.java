package com.ohgiraffers.section01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    /* 메뉴코드를 입력받아서 하나의 메뉴를 조회하는 기능 */
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.print("메뉴 코드를 입력하세요 : ");
            int menuCode = sc.nextInt();

            String query = "SELECT * FROM tbl_menu WHERE menu_code = " + menuCode;
//            String query = "SELECT * FROM tbl_menu WHERE menu_name = '" + menuCode + "'";
            System.out.println("query = " + query);

            rset = stmt.executeQuery(query);
            if (rset.next()) {
                System.out.println(rset.getString("menu_name") + "  " + rset.getInt("menu_price"));
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
