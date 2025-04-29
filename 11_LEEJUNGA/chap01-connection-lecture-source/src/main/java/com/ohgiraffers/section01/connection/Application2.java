package com.ohgiraffers.section01.connection;

import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        Properties props = new Properties();

        Connection con = null;

        try {
            props.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
//
//            /* 설정 정보는 유지보수성을 위해 리터럴 값으로 작성하지 않고 별도의 파일로 분리한다. */
////            con = DriverManager.getConnection(url, user, password); -> 아래와 동일
//            con = DriverManager.getConnection(url, props);

            Class.forName(driver);

            con = getConnection();
            System.out.println("con = " + con);

            // 내가 원하는 시점에 종료
            close(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
