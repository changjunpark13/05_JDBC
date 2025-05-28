//package com.ohgiraffers.section01.connection;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class Application1 {
//
//    public static void main(String[] args) {
//
//        // 데이터베이스 연결 객체 선언 (초기에는 null로 설정)
//        Connection con = null;
//
//        try {
//            // 데이터베이스에 연결 시도
//            con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/menudb",  // DB 주소 (스키마명 포함)
//                    "ohgiraffers",                         // DB 사용자명
//                    "ohgiraffers"                          // DB 비밀번호
//            );
//
//            System.out.println("DB 연결 성공! con = " + con);
//
//        } catch (SQLException e) {
//            // DB 연결 중 오류 발생 시 예외 처리
//            throw new RuntimeException("DB 연결 실패", e);
//
//        } finally {
//            // 무조건 실행되는 finally 블록에서 연결 종료 처리
//            if (con != null) {
//                try {
//                    con.close();
//                    System.out.println("DB 연결 해제 완료");
//                } catch (SQLException e) {
//                    throw new RuntimeException("DB 연결 해제 실패", e);
//                }
//            }
//        }
//    }
//}
// ⚠️ 주의할 점 1: DB 접속 정보는 절대 소스 코드에 하드코딩하지 않음!
// 보안상 위험하며, 환경에 따라 달라질 수 있기 때문에 .properties 파일 등에 따로 분리해서 관리함

// ⚠️ 주의할 점 2: 연결 객체(Connection)는 사용 후 반드시 닫아야 함!
// 닫지 않으면 리소스 누수 발생 → 서버 다운이나 연결 제한 문제 발생 가능

// ⚠️ 주의할 점 3: try-catch-finally로 예외 및 자원 정리를 철저히 해야 함
// 실무에서는 try-with-resources 또는 별도의 JDBC 템플릿 클래스(JDBCTemplate 등) 사용을 권장
