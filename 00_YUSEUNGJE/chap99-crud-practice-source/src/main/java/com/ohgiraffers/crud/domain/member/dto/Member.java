package com.ohgiraffers.crud.domain.member.dto;

public class Member {

    private String empId;
    private String empName;
    private String empNo;
    private Department dept;

    public Member() {
    }

    public Member(String empId, String empName, String empNo, Department dept) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.dept = dept;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Member{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", dept=" + dept +
                '}';
    }
}

