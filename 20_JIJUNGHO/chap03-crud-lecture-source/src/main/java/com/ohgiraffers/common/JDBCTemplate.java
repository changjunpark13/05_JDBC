package com.ohgiraffers.common;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;


public class JDBCTemplate {

    public static Connection getConnection() {

        Properties props = new Properties();
        Connection con = null;

        try {
            props.load(new FileReader("src/main/java/com/ohgiraffers/config/jdbc-info.properties"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");

            Class.forName(driver);

            con = DriverManager.getConnection(url, props);
            // 자동 커밋 설정을 수동 커밋 설정으로 변경하여 서비스계층에서 트랜잭션을 컨트롤할 수 있도록함
            con.setAutoCommit(false);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    // connection을 닫는 개념은 별도의 메소드로 분리하고 실제 담는 시점은 Service 계층에서 진행
    public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        // PreparedStatement가 Statement의 자식 클래스(상속 구조)이기 때문에 다형성을 적용할 수 있다.
        // 동적바인딩이 발생하여 PreparedStatement의 close()클래스를 따로 만들지 않아도 된다.
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            if (rset != null) {
                rset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
