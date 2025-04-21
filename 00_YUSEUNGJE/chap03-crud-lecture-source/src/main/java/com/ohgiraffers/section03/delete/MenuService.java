package com.ohgiraffers.section03.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {

    private MenuRepository menuRepository = new MenuRepository();

    public void removeMenu(int menuCode) {
        Connection con = getConnection();
        int result = menuRepository.deleteMenu(con, menuCode);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}
