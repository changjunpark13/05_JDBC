package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {

    public static void main(String[] args) {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307", "ohgiraffers","ohgiraffers");

            System.out.println("con = " + con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
