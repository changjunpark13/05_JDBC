package com.ohgiraffers.crud.domain.member.service;

import com.ohgiraffers.crud.domain.member.dto.Member;
import com.ohgiraffers.crud.domain.member.repository.MemberRepository;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.crud.common.JDBCTemplate.close;
import static com.ohgiraffers.crud.common.JDBCTemplate.getConnection;

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
}
