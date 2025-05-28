package com.ohgiraffers.section01.statement;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    /*메뉴 코드를 입력 받아 하나의 메뉴를 조회하는 기능*/
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.print("메뉴 코드 입력 : " );
            int menuCode = sc.nextInt();

            String query = "select * from tbl_menu where menu_code = " + menuCode;
       //     String query = "select * from menu where menu_name = '" + menuName + "'";
            System.out.println("query : " + query);

            rset = stmt.executeQuery(query);
            if (rset.next()) {
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
