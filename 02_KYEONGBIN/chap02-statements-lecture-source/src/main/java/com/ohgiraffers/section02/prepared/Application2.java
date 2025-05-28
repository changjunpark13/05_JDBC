package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {

    // PreparedStatement는 SQL문을 처음 실행할 때 한 번만 분석(파싱), 번역(컴파일), 저장(캐싱)해둠
    // 그래서 같은 SQL문을 여러 번 실행할 경우, 다시 해석하지 않아서 Statement보다 더 빠름
    // 단, SQL문 구조는 고정되어 있고 값만 바뀌는 경우에 효과적임


    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;

        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 코드를 입력하세요; ");
        int menuCode = sc.nextInt();

        // PreparedStatement는 ? 기호(placeholder)를 사용해서 값이 들어갈 자리를 미리 정해놓을 수 있음
        // 그래서 SQL문을 문자열 하나로 작성하고, 실행 전에 값만 따로 넣어줌
        String query = "SELECT MENU_NAME, MENU_PRICE FROM tbl_menu WHERE MENU_CODE = ?";

        try {
            pstmt = con.prepareStatement(query); // 미완성된 쿼리를 이용해서 Prepared 객체를 생성
            pstmt.setInt(1, menuCode); // 위치 홀더(?) 가 나열된 순서 왼쪽 -> 오른쪽 순서대로 채워나감
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

    }
}
