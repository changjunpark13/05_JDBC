package com.ohgiraffers.section02.update;

import com.ohgiraffers.section01.insert.Menu;

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
public class MenuRepogitory {

//    private Properties prop = new Properties();
    private final Properties prop;
    
    public MenuRepogitory() {
        prop = new Properties();
        
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/MenuMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateMenu(Connection con, Memu modifyMenu) {
        System.out.println("[MenuRepository]insertMenu:  menu ===> " + modifyMenu);

        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("updateMenu");
            System.out.println("sql = " + sql);

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, modifyMenu );
            pstmt.setInt((2, modifyMenu.getMenuPrice()));
            pstmt.setInt((3, modifyMenu.getMenuCode()));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        System.out.println("[MenuRepository]updateMenu:  result ===> " + result);
        return result;

    }
}
