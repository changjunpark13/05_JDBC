package com.ohgiraffers.section03.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


/*
* DBMS를 통해
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
        PreparedStatement pstmt = null;
        int result;

        String sql = prop.getProperty("insertMenu");
        System.out.println("sql = " + sql);

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setInt(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public int updateMenu(Connection con, Menu modifyMenu) {
        PreparedStatement pstmt;
        int result;

        String sql = prop.getProperty("updateMenu");
        System.out.println("sql = " + sql);

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, modifyMenu.getMenuName());
            pstmt.setInt(2, modifyMenu.getMenuPrice());
            pstmt.setInt(3, modifyMenu.getMenuCode());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    public int deleteMenu(Connection con, int menuCode) {
        PreparedStatement pstmt;
        int result;

        String sql = prop.getProperty("deleteMenu");
        System.out.println("sql = " + sql);

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, menuCode);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
