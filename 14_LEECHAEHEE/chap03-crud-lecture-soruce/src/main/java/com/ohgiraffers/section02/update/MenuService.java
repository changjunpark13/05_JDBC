package com.ohgiraffers.section02.update;

import com.ohgiraffers.section02.update.Menu;
import com.ohgiraffers.section02.update.MenuRepository;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

/*
* Service 계층 : 비즈니스 로직을 구현하는 계층
* 기능의 수행 결과에 따라 commit, rollback 처리가 일어남
* */
public class MenuService {
        private static final MenuRepository menuRepository = new MenuRepository();
    public static void registMenu(Menu menu) {
        System.out.println("[MenuService] registMenu : menu ====> " + menu);

        Connection con = getConnection();
        int result = menuRepository.updateMenu(con, menu);

        // 수행 결과에 따라 Commit, Rollback 정해야한다.
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        System.out.println("[MenuService] registMenu: End ====> ");
    }

    public static void modifyMenu(Menu modifyMenu) {
        System.out.println("[MenuService] modifyMenu : menu ====> " + modifyMenu);

        Connection con = getConnection();
        int result = menuRepository.updateMenu(con, modifyMenu);

        // 수행 결과에 따라 Commit, Rollback 정해야한다.
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        System.out.println("[MenuService] modifyMenu : End ====> ");
    }
}
