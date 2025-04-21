package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/*
* PreparedStatement는 Statement와 달리 최초 한 번 쿼리를 파싱하고 컴파일하고 캐싱하여 다시 재해석 하는
* 과정(비용)을 생략함으로 인해 불완전하게 작성된 쿼리 실행의 경우는 Statement보다 빠르다.
* */
public class Application2 {

    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 코드를 입력하세요 : ");
        int menuCode = sc.nextInt();

        /* PreparedStatement는 Statement와 달리 placeholder(?)를 활용한 하나의 문자열 형태로 쿼리를 작성 */
        String query = "SELECT MENU_NAME, MENU_PRICE FROM tbl_menu WHERE MENU_CODE = ?";


        try {
            pstmt = con.prepareStatement(query); // 미완성된 쿼리를 이용해서 Prepared객체를 생성
            pstmt.setInt(1, menuCode);  // 위치홀더(?)가 나열된 순서 왼쪽->오른쪽 순서대로 채워나간다.

            rset = pstmt.executeQuery();
            while(rset.next()) {
                System.out.printf("%s %d\n", rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }


    }
}

