package com.ohgiraffers.section01.insert;


import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

/*
* Service 계층 : 비즈니스 로직을 구현하는 계층
* 기능의 수행 결과에 따라 commit, rollback 처리가 일어남
* */
public class MenuService {
    private MenuRepogitory menuRepogitory = new MenuRepogitory();

    public void registMenu(Menu menu) {
        System.out.println("[MenuService]registMenu: menu ====> " + menu);

        Connection con = getConnection();
        int result = menuRepogitory.insertMenu(con, menu);

        // 수행 결과에 따라서 commit, Rollback 정해야 한다.
        if (result > 0) {
            commit(con);
        }else {
            rollback(con);
        }

        close(con);
        System.out.println("[MenuService]registMenu:  End ===> ");
    }


}
