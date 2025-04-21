package com.ohgiraffers.crud.domain.member.dto;

public class Department {

    private String deptId;
    private String deptTitle;

    public Department() {
    }

    public Department(String deptId, String deptTitle) {
        this.deptId = deptId;
        this.deptTitle = deptTitle;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptTitle() {
        return deptTitle;
    }

    public void setDeptTitle(String deptTitle) {
        this.deptTitle = deptTitle;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId='" + deptId + '\'' +
                ", deptTitle='" + deptTitle + '\'' +
                '}';
    }
}