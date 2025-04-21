package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

/* Repository 계층
* DBMS를 통해 수행되는 CRUD 작업 단위의 메소드를 정의
* */
public class MenuRepository {

    private final Properties prop;

    public MenuRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/MenuMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertMenu(Connection con, Menu menu) {

        System.out.println("[MenuRepository]insertMenu:  menu ===> " + menu);
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("insertMenu");
            System.out.println("sql = " + sql);

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setInt(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        System.out.println("[MenuRepository]insertMenu:  result ===> " + result);
        return result;
    }
}
