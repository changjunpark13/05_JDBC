package com.ohgiraffers.section01.insert;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

/**
 * service계층 : 비즈니스 로직을 구현하는 계층
 * 기능의 수행 결과에 따라 commit, rollback 처리가 일어남
 */

public class MenuService {

    private MenuRepository menuRepository = new MenuRepository();

    public void registMenu(Menu menu) {
        System.out.println("[MenuService] registMenu: menu ===> " + menu);

        Connection con = getConnection();

        int result = menuRepository.insertMenu(con, menu);

        // 수행 결과에 따라서 commit, rollback 정해야한다.
        // 수행결과가 정상적으로 완료되면 result 값은 1이상이 됨
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
        System.out.println("[MenuService]registMenu:  Commit-End ===> ");
    }

}
