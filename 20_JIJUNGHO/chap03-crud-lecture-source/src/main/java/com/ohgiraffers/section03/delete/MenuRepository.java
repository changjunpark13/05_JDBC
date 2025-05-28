package com.ohgiraffers.section03.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

/**
 * Repository 계층
 * DBMS를 통해 수행되는 CURD 작업 단위의 메소드를 정의
 */
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

    public int deleteMenu(Connection con, Menu deleteMenu) {
        System.out.println("[MenuRepository]deleteMenu:  menu ===> " + deleteMenu);
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("deleteMenu");
            System.out.println("sql = " + sql);

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, deleteMenu.getMenuCode());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        System.out.println("[MenuRepository]deleteMenu:  result ===> " + result);
        return result;
    }
}
