package com.ohgiraffers.crud.domain.member.service;

import com.ohgiraffers.crud.domain.member.dto.Member;
import com.ohgiraffers.crud.domain.member.repository.MemberRepository;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.crud.common.JDBCTemplate.*;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public void selectAllMembers() {

        Connection con = getConnection();

        List<Member> memberList = memberRepository.selectAllMembers(con);

        for(Member member : memberList) {
            System.out.println(member);
        }

        close(con);
    }

    public void findMember(int empId) {
        Connection con = getConnection();
        Member member = memberRepository.selectMember(con, empId);
        System.out.println(member);
        close(con);
    }

    public void registMember(int empId, String empName, String empNo) {
        Connection con = getConnection();
        int result = memberRepository.insertMember(con, empId, empName, empNo);
        System.out.println("result = " + result);

        if(result == 1) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public void modifyMember(int empId, String empName) {
        Connection con = getConnection();
        int result = memberRepository.updateMember(con, empId, empName);
        System.out.println("result = " + result);

        if(result == 1) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public void deleteMember(int empId) {
        Connection con = getConnection();
        int result = memberRepository.deleteMember(con, empId);
        System.out.println("result = " + result);

        if(result == 1) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}