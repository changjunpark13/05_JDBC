package com.ohgiraffers.crud.domain.member.service;

import com.ohgiraffers.crud.domain.member.dto.Member;
import com.ohgiraffers.crud.domain.member.repository.MemberRepository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static com.ohgiraffers.crud.common.JDBCTemplate.*;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }


    public void selectAllMember() {
        Connection con = getConnection();

        List<Member> members = memberRepository.selectAllMembers(con);

        for(Member member : members) {
            System.out.println(member);
        }

        close(con);
    }

    public void searchMember(String searchName) {
        Connection con = getConnection();
        List<Member> members = memberRepository.searchMember(con, searchName);
        if (members.isEmpty()) {
            System.out.println("일치하는 회원이 없습니다.");
        } else {
            for (Member member : members) {
                System.out.println(member);
            }
        }

        close(con);
    }

    public void insertMember(Member member) {
        Connection con = getConnection();
        int result = memberRepository.insertMember(con, member);

        if(result > 0) {
            System.out.println("회원 등록 성공");
            commit(con);
        } else {
            System.out.println("회원 등록 실패");
            rollback(con);
        }
        close(con);
    }

    public void updateMember(int empCode, String empName) {

        Connection con = getConnection();

        int result = memberRepository.updateMember(con, empCode, empName);

        if (result > 0) {
            System.out.println("회원 수정 성공");
            commit(con);
        } else {
            System.out.println("회원 수정 실패");
            rollback(con);
        }
        close(con);

    }

    public void deleteMember(String removeName) {

        Connection con = getConnection();
        int result = memberRepository.deleteMember(con, removeName);

        if (result > 0) {
            System.out.println("회원 탈퇴 성공");
            commit(con);
        } else {
            System.out.println("회원 탈퇴 실패");
            rollback(con);
        }
        close(con);
    }
}
