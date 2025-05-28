package com.ohgiraffers.crud.domain.member.repository;

import com.ohgiraffers.crud.domain.member.dto.Department;
import com.ohgiraffers.crud.domain.member.dto.Member;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.crud.common.JDBCTemplate.close;

public class MemberRepository {

    private Properties prop = null;

    public MemberRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/MemberMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Member> selectAllMembers(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectAllMembers");

        List<Member> members = null;
        try {
            pstmt = con.prepareStatement(sql);

            rset = pstmt.executeQuery();
            members = new ArrayList<>();
            while (rset.next()) {
                Member member = new Member();
                member.setEmpId(rset.getString("emp_id"));
                member.setEmpName(rset.getString("emp_name"));
                member.setEmpNo(rset.getString("emp_no"));

                Department department = new Department();
                department.setDeptId(rset.getString("dept_id"));
                department.setDeptTitle(rset.getString("dept_title"));
                member.setDept(department);
                members.add(member);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(rset);
        }

        return members;
    }

    public List<Member> searchMember(Connection con, String searchName) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("searchMember");
        List<Member> members = new ArrayList<>();

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, searchName);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                Member member = new Member();
                member.setEmpId(rset.getString("emp_id"));
                member.setEmpName(rset.getString("emp_name"));
                member.setEmpNo(rset.getString("emp_no"));

                Department department = new Department();
                department.setDeptId(rset.getString("dept_id"));
                department.setDeptTitle(rset.getString("dept_title"));
                member.setDept(department);

                members.add(member);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(rset);
        }

        return members;
    }

    public int insertMember(Connection con, Member member) {

        PreparedStatement pstmt = null;
        int result = 0;
        String sql = prop.getProperty("insertMember");

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getEmpId());
            pstmt.setString(2, member.getEmpName());
            pstmt.setString(3, member.getEmpNo());
            pstmt.setString(4, member.getJobCode());
            pstmt.setString(5, member.getSalLevel());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int updateMember(Connection con, int empCode, String empName) {

        PreparedStatement pstmt = null;
        int result = 0;
        try {
            String sql = prop.getProperty("updateMember");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, empName);
            pstmt.setInt(2, empCode);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int deleteMember(Connection con, String removeName) {
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("deleteMember");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, removeName);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}
