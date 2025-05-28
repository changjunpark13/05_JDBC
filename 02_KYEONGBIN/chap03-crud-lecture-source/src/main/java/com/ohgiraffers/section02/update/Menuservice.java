package com.ohgiraffers.section02.update;

// 💡 JDBC 템플릿 메서드(static)들을 import해서 바로 사용할 수 있게 함

import com.ohgiraffers.section01.insert.Menu;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/**
 * 📌 MenuService 클래스
 * - 'Service 계층'은 실제 비즈니스 로직(업무 로직)을 처리하는 역할을 함
 * - 이 클래스에서는 사용자의 메뉴 등록 요청을 받아
 *   DB에 insert하고, 결과에 따라 commit 또는 rollback을 수행함
 */
public class MenuService {

    // 💡 Repository(DAO) 객체 생성 → DB와 직접 통신하는 역할
    private MenuRepository menuRepository = new MenuRepository();

    /**
     * ✅ registMenu(Menu menu)
     * - 사용자가 등록한 메뉴 정보를 DB에 저장하는 메서드
     * - 트랜잭션 처리(commit/rollback 포함)
     *
     * @param menu : 저장할 메뉴 정보 (Menu 객체)
     */
    public void registMenu(Menu menu) {
        System.out.println("[MenuService] regist menu: menu ---> " + menu); // 디버깅용 로그 출력

        // 1️⃣ DB 연결(Connection 객체) 생성
        Connection con = getConnection();

        // 2️⃣ Repository를 통해 insert 수행
        int result = menuRepository.insertMenu(con, menu);

        // 3️⃣ 트랜잭션 처리 (결과에 따라 commit 또는 rollback)
        if (result > 0) {         // 0보다 크면 = insert 성공한 행이 있음
            commit(con);          // 트랜잭션 커밋 (변경사항 확정)
        } else {                  // 실패한 경우
            rollback(con);        // 롤백 (변경사항 취소)
        }

        // 4️⃣ 자원 반납 (Connection 닫기)
        close(con);
    }

    public void modifyMenu(com.ohgiraffers.section02.update.Menu modifyMenu) {
    }
}
