package com.ohgiraffers.section03.delete;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

/*
* Service 계층 : 비즈니스 로직을 구현하는 계층
* 기능의 수행 결과에 따라 commit, rollback 처리가 일어남
* */
public class MenuService {
        private static final MenuRepository menuRepository = new MenuRepository();
    public static void deleteMenu(Menu menu) {
        System.out.println("[MenuService] deleteMenu : menu ====> " + menu);

        Connection con = getConnection();
        int result = menuRepository.deleteMenu(con, menu);

        // 수행 결과에 따라 Commit, Rollback 정해야한다.
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        System.out.println("[MenuService] deleteMenu: End ====> ");
    }

}
