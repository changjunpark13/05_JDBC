package com.ohgiraffers.section03.delete;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {

    private final MenuRepository menuRepository = new MenuRepository();

    public void removeMenu(int menuCode) {

        Connection con = getConnection();
        int result = menuRepository.deleteMenu(con, menuCode);

        // 수행 결과에 따라서 Commit, Rollback 정해야한다.
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}
