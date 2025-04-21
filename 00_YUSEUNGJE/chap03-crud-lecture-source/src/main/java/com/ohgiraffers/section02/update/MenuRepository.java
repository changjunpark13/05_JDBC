package com.ohgiraffers.section02.update;

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

    public int updateMenu(Connection con, Menu modifyMenu) {

        System.out.println("[MenuRepository]updateMenu:  menu ===> " + modifyMenu);
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("updateMenu");
            System.out.println("sql = " + sql);

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, modifyMenu.getMenuName());
            pstmt.setInt(2, modifyMenu.getMenuPrice());
            pstmt.setInt(3, modifyMenu.getMenuCode());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        System.out.println("[MenuRepository]updateMenu:  result ===> " + result);
        return result;
    }
}
