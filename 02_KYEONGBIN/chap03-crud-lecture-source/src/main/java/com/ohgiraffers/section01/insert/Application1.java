package com.ohgiraffers.section01.insert; // 패키지 경로 설정

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.*; // JDBCTemplate 클래스의 static 메서드를 직접 호출 가능하게 import

public class Application1 {

    public static void main(String[] args) {

        Connection con = getConnection();  // 📌 DB 연결 생성 (JDBCTemplate에서 정의한 getConnection() 사용)
        PreparedStatement pstmt = null;   // 📌 SQL 실행을 위한 PreparedStatement 선언

        // ✅ 실행할 SQL문 (데이터 삽입용 INSERT 문)
        // ?는 나중에 setXxx()로 값을 바인딩함
        String sql =
                "insert into tbl_menu(menu_name, menu_price, category_code, orderable_status) " +
                        "values(?,?,?,?)";

        int result = 0;  // 📌 SQL 실행 결과 저장 변수 (INSERT/UPDATE/DELETE는 int 타입으로 처리된 행 수를 반환함)

        try {
            pstmt = con.prepareStatement(sql);  // 📌 SQL 준비 (미리 컴파일된 쿼리 객체 생성)

            // ✅ ? 자리에 값 바인딩 (1부터 시작)
            pstmt.setString(1, "봉골레청국장");  // 첫 번째 ? → menu_name (문자열)
            pstmt.setInt(2, 12000);             // 두 번째 ? → menu_price (정수)
            pstmt.setInt(3, 4);                 // 세 번째 ? → category_code (정수)
            pstmt.setString(4, "Y");            // 네 번째 ? → orderable_status (문자열)

            // 📌 쿼리 실행 → INSERT, UPDATE, DELETE는 executeUpdate() 사용
            result = pstmt.executeUpdate(); // 실행 후 영향을 받은 행 수 반환됨

            // 실행 결과 출력 (1이면 성공적으로 1행 삽입됨)
            System.out.println(result);

        } catch (SQLException e) {
            // 예외 발생 시 RuntimeException으로 감싸서 던짐
            throw new RuntimeException(e);
        } finally {
            // 📌 사용한 자원 정리 (사용 순서 반대로 닫기)
            close(pstmt); // 쿼리 객체 닫기
            close(con);   // DB 연결 닫기
        }
    }
}
