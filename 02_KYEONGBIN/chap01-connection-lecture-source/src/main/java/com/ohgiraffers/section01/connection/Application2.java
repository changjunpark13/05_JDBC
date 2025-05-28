package com.ohgiraffers.section01.connection;

import com.ohgiraffers.section02.template.JDBCTemplate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
// import static은 메소드명까지 작성하며 static 메소드를 '클래스명'을 생략하고 호출할 수 있음
import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application2 {

    public static void main(String[] args) {
        // 1. Properties 객체 생성
        // Properties는 key-value 형태로 데이터를 저장할 수 있는 객체로,
        // 보통 설정 파일에서 값을 읽어오는 데 사용됩니다.
        Properties props = new Properties();

        // 2. Connection 객체 선언
        // 데이터베이스와의 연결을 관리하는 Connection 객체를 선언합니다.
        // 이 객체는 데이터베이스 연결이 성공하면, 데이터를 주고받을 수 있는 세션을 제공합니다.
        Connection con = null;

        try {
            // 3. jdbc-config.properties 파일 읽기
            // FileReader를 통해 파일 경로에 위치한 jdbc-config.properties 파일을 읽어들입니다.
            // 이 파일에는 데이터베이스 접속에 필요한 정보가 저장되어 있습니다.
            props.load(new FileReader(
                    "src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));

            // 4. 데이터베이스 접속 정보 추출
            // jdbc-config.properties 파일에서 'url', 'user', 'password'라는 키로
            // 데이터베이스 접속 정보를 가져옵니다. 이 값들은 DB 연결에 사용됩니다.
            String url = props.getProperty("url");
            String driver = props.getProperty("driver");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

//            Class.forName(driver);

            // 5. 데이터베이스 연결
            // DriverManager.getConnection() 메서드를 사용하여 실제로 데이터베이스에 연결합니다.
            // getConnection()의 파라미터로 URL, 사용자 이름, 비밀번호를 전달하여
            // 데이터베이스 연결을 시도합니다.
            con = DriverManager.getConnection(url, user, password);

            // 6. 연결 확인
            // 연결이 성공적으로 이루어지면 Connection 객체가 반환되고, 그 객체를 출력합니다.
            System.out.println("con = " + con);
        } catch (SQLException e) {
            // 7. SQLException 처리
            // SQL 예외가 발생하면 예외를 RuntimeException으로 감싸서 던집니다.
            // SQLException은 SQL 문법이나 연결에 문제가 있을 때 발생합니다.
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            // 8. FileNotFoundException 처리
            // 파일을 찾을 수 없을 때 발생하는 예외입니다. jdbc-config.properties 파일이
            // 존재하지 않는 경우 이 예외가 발생합니다.
            throw new RuntimeException(e);
        } catch (IOException e) {
            // 9. IOException 처리
            // 파일을 읽는 과정에서 발생하는 오류를 처리합니다. 파일에 접근할 수 없거나
            // 읽기 오류가 발생하면 이 예외가 발생합니다.
            throw new RuntimeException(e);
        } finally {
            // 10. 연결 종료 및 자원 해제
            // finally 블록은 예외가 발생하든 안 하든 반드시 실행되는 구간입니다.
            // 여기서는 데이터베이스 연결을 종료하여 자원을 해제하는 작업을 수행합니다.
            if (con != null) {
                try {
                    // 11. 연결 종료
                    // Connection 객체는 자원을 많이 사용하는 객체이기 때문에,
                    // 사용 후 반드시 종료해야 합니다. close() 메서드를 호출하여 연결을 종료합니다.
                    con.close(); // 연결 종료
                } catch (SQLException e) {
                    // 12. SQLException 처리
                    // 연결 종료 중 예외가 발생하면 RuntimeException을 던집니다.
                    throw new RuntimeException(e);
                }
            }

            try {
                // 13. JDBCTemplate의 getConnection() 호출
                // JDBCTemplate에서 제공하는 getConnection() 메서드를 사용하여
                // 새로운 연결을 생성합니다. 이 메서드는 데이터베이스 연결을 설정하는
                // 방법을 단순화하는 데 사용됩니다.
                con = getConnection();
                System.out.println("con = " + con);

                // 14. 안전하게 연결 종료
                // JDBCTemplate의 close() 메서드를 사용하여 데이터베이스 연결을 종료합니다.
                // 이 메서드는 연결을 닫을 때 발생할 수 있는 예외를 처리하고, 연결을 안전하게 종료합니다.
                close(con);
            } catch (SQLException e) {
                // 15. SQLException 처리
                // getConnection() 호출 중 예외가 발생하면 그 예외를 출력합니다.
                e.printStackTrace();
            }
        }
    }
}
