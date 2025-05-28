package com.ohgiraffers.crud.domain.member.dto;

public class Member {

    private String empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;
    private String jobCode;
    private String salLevel;
    private int salary;
    private int bonus;
    private Department dept;

    public Member() {
    }

    public Member(String empId, String empName, String empNo, Department dept) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.dept = dept;
    }

    public Member(String empId, String empName, String empNo, String jobCode, String salLevel) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.jobCode = jobCode;
        this.salLevel = salLevel;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String empEmail) {
        this.email = empEmail;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getSalLevel() {
        return salLevel;
    }

    public void setSalLevel(String salLevel) {
        this.salLevel = salLevel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
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

