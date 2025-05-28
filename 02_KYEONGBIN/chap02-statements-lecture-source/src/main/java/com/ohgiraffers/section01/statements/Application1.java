package com.ohgiraffers.section01.statements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {

        // 1️⃣ DB 연결을 위한 Connection 객체 생성
        Connection con = getConnection();    // JDBCTemplate에서 가져온 DB 연결 메서드 사용
        System.out.println("con = " + con);  // 연결 확인용 출력

        Statement stmt = null;   // SQL문을 실행시킬 Statement 객체
        ResultSet rset = null;   // SELECT 결과를 담는 ResultSet (조회 전용)

        try {
            // 2️⃣ 연결된 DB로부터 Statement 객체 생성 (SQL 실행할 준비)
            stmt = con.createStatement(); // SQL 문장을 실행하는 통로

            // 3️⃣ SQL 실행 (tbl_menu 테이블에서 전체 조회)
            rset = stmt.executeQuery("SELECT * FROM tbl_menu");

            // 4️⃣ 조회 결과 출력 (rset은 결과 행들을 한 줄씩 가져올 수 있음)
            while (rset.next()) {  // rset.next() → 다음 행이 있으면 true
                // menu_name 컬럼 값을 문자열로 가져오기
                System.out.print(rset.getString("menu_name") + " ");

                // menu_price 컬럼 값을 정수로 가져오기
                System.out.print(rset.getInt("menu_price") + "\n");
            }

        } catch (SQLException e) {
            // SQL 실행 중 오류 발생 시 예외 처리
            throw new RuntimeException(e);
        } finally {
            // 5️⃣ 사용한 자원들 반납 (닫기)
            close(rset);  // ResultSet 닫기
            close(stmt);  // Statement 닫기
            close(con);   // Connection 닫기
        }

    }
}
