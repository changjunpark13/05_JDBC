package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {
        Properties props = new Properties();
        Connection con = null;

        try {
            // 리소스 파일 경로 수정
            props.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            String driver = props.getProperty("driver");
            String url = props.getProperty("url");

            Class.forName(driver); // 드라이버 로딩
            con = DriverManager.getConnection(url, props);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException("DB 연결 중 오류 발생", e);
        }

        return con;
    }

    public static void close(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB 연결 종료 중 오류 발생", e);
        }
    }

    public static void close(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB 연결 종료 중 오류 발생", e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            if (rset != null && !rset.isClosed()) {
                rset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB 연결 종료 중 오류 발생", e);
        }
    }
}