package com.ohgiraffers.section02.update;

import com.ohgiraffers.section01.insert.Menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuRepository {

    private final Properties prop; // 📌 쿼리문을 읽어올 Properties 객체 선언

    // ================================
    // ✅ 생성자
    // - MenuMapper.xml에서 SQL문을 읽어와 Properties 객체에 로딩
    // ================================
    public MenuRepository() {
        prop = new Properties();
        try {
            // 📌 XML 파일에서 SQL 구문을 읽어옴
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/MenuMapper.xml"));
        } catch (IOException e) {
            // 예외 발생 시 런타임 예외로 전환하여 던짐
            throw new RuntimeException("쿼리 매핑 파일 로드 중 오류 발생", e);
        }
    }

    // ================================
    // ✅ insertMenu()
    // - 전달받은 Menu 객체 데이터를 DB에 insert
    // - Connection은 Service에서 전달받음
    // ================================
    public int insertMenu(Connection con, Menu menu) {

        PreparedStatement pstmt = null;  // SQL 실행 객체
        int result = 0;                  // 실행 결과 (처리된 행 수)

        try {
            // 📌 XML에서 "insertMenu" 키에 해당하는 SQL 문 꺼내오기
            String sql = prop.getProperty("insertMenu");
            System.out.println("sql : " + sql); // 로그 출력용

            pstmt = con.prepareStatement(sql); // SQL 준비

            // 📌 ? 에 값 바인딩 (Menu 객체에서 값 가져옴)
            pstmt.setString(1, menu.getMenuName());       // 메뉴 이름
            pstmt.setDouble(2, menu.getMenuPrice());      // 메뉴 가격
            pstmt.setInt(3, menu.getCategoryCode());      // 카테고리 코드
            pstmt.setString(4, menu.getOrderableStatus()); // 주문 가능 여부 (Y/N)

            // 📌 INSERT 실행 → 처리된 행 수 반환
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            // SQL 실행 중 에러 발생 시 예외 던짐
            throw new RuntimeException("메뉴 등록 중 오류 발생", e);
        } finally {
            // 📌 자원 정리
            close(pstmt);  // PreparedStatement 닫기
        }

        return result;  // 실행 결과 반환 (삽입된 행 수)
    }
}
