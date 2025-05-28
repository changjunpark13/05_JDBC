package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    /*
     * 📌 getConnection()
     * ------------------------------
     * ✅ DB와 연결을 생성하는 메서드
     * ✅ DB 접속 정보를 외부 설정 파일로부터 읽어와서,
     *    - 드라이버 로드
     *    - Connection 객체 생성
     * ✅ 자동 커밋을 false로 설정해서 서비스 계층에서 수동으로 commit/rollback 하도록 설정
     */
    public static Connection getConnection() {
        Properties props = new Properties();     // jdbc-info.properties를 읽기 위한 객체
        Connection con = null;

        try {
            // 💡 설정 파일 경로: src/main/java/com/ohgiraffers/config/jdbc-info.properties
            props.load(new FileReader("src/main/java/com/ohgiraffers/config/jdbc-info.properties"));

            // 설정 파일에서 키 이름으로 value를 꺼냄
            String driver = props.getProperty("driver");  // ex) com.mysql.cj.jdbc.Driver
            String url = props.getProperty("url");        // ex) jdbc:mysql://localhost:3306/empdb

            // 드라이버 클래스 메모리에 로드 (ClassNotFoundException 발생 가능)
            Class.forName(driver);

            // DB 연결 생성 (url과 properties에 있는 사용자명, 비밀번호 사용)
            con = DriverManager.getConnection(url, props);

            // 자동 커밋 끄기 → commit(), rollback() 직접 처리 (트랜잭션 컨트롤용)
            con.setAutoCommit(false);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            // 설정 파일 읽기, 드라이버 로딩, 연결 생성 중 하나라도 실패하면 예외 발생
            throw new RuntimeException("DB 연결 중 오류 발생", e);
        }

        return con;  // 연결 객체 반환
    }

    /*
     * 📌 close(Connection con)
     * ------------------------------
     * ✅ 사용이 끝난 Connection 자원을 안전하게 종료
     * ✅ 데이터베이스 연결은 제한된 자원이므로 반드시 닫아야 함
     */
    public static void close(Connection con) {
        try {
            if (con != null && !con.isClosed()) {  // 연결이 열려 있을 경우
                con.close();  // DB 연결 종료
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB 연결 종료 중 오류 발생", e);
        }
    }

    /*
     * 📌 close(Statement stmt)
     * ------------------------------
     * ✅ Statement 또는 PreparedStatement 객체 종료용 메서드
     * ✅ 쿼리 실행 후 반드시 닫아야 자원 누수가 발생하지 않음
     */
    public static void close(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();  // 명령 객체 종료
            }
        } catch (SQLException e) {
            throw new RuntimeException("Statement 종료 중 오류 발생", e);
        }
    }

    /*
     * 📌 close(ResultSet rset)
     * ------------------------------
     * ✅ SELECT 쿼리 실행 후 받은 결과(ResultSet)를 종료
     * ✅ 열려 있는 ResultSet은 메모리를 계속 차지하기 때문에 닫아줘야 함
     */
    public static void close(ResultSet rset) {
        try {
            if (rset != null && !rset.isClosed()) {
                rset.close();  // 결과 집합 종료
            }
        } catch (SQLException e) {
            throw new RuntimeException("ResultSet 종료 중 오류 발생", e);
        }
    }
}
