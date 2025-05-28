package com.ohgirafferces.crud.domain.Service;

import java.sql.Connection;

import static com.ohgirafferces.crud.common.JDBCTemplate.*;

public class MemberService {
    private MemberService memberService;
    public MemberService() {
        memberService = new MemberService();
    //직원 테이블에서 회원을 참조하여 회원 번호 조회
        public void selectMemberList(int empID){

            System.out.println("memberService : emp" + emp);
            Connection con = getConnection();
            int result = memberService.emp(con,emp);

            if(result > 0){
                commit(con);
            }else{
                rollback(con);
            }
            close(con);
            System.out.println();

        }
    }

}
