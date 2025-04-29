package com.ohgiraffers.crud.domain.member.view;

import com.ohgiraffers.crud.domain.member.service.MemberService;

import java.util.Scanner;

public class MemberView {
    static final MemberService ms = new MemberService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String menu = """
                ============= 회원 관리 프로그램 ===============
                1. 모든 회원 정보 보기
                2. 회원 찾기
                3. 회원 가입
                4. 회원 정보수정
                5. 회원 탈퇴
                9. 프로그램 종료
                메뉴를 선택해주세요 : """;

        while (true) {
            System.out.print(menu);
            int input = sc.nextInt();
            sc.nextLine(); // 버퍼 초기화

            switch (input) {
                case 1:
                    // 1. 모든 회원 정보 보기
                    ms.selectAllMembers();
                    break;
                case 2:
                    // 2. 회원 찾기
                    System.out.print("찾을 회원 ID를 입력해주세요 : ");
                    int empId = sc.nextInt();
                    ms.findMember(empId);
                    break;
                case 3:
                    // 3. 회원 가입
//                    EMP_ID     varchar(3)       not null  primary key,
//                    EMP_NAME   varchar(20)      not null,
//                    EMP_NO     char(14)         not null,
//                    JOB_CODE   varchar(10)      not null,
//                    SAL_LEVEL  char(2)          not null,
                    System.out.print("회원 번호를 입력해주세요 : ");
                    empId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("이름을 입력해주세요 : ");
                    String empName = sc.nextLine();

                    System.out.print("주민번호를 입력해주세요 : ");
                    String empNo = sc.nextLine();

                    ms.registMember(empId, empName, empNo);
                    break;
                case 4:
                    // 4. 회원 정보수정
                    System.out.print("회원번호를 입력해주세요 : ");
                    empId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("수정할 이름을 입력해주세요 : ");
                    empName = sc.nextLine();

                    ms.modifyMember(empId, empName);
                    break;
                case 5:
                    // 5. 회원 탈퇴
                    System.out.print("삭제할 회원번호를 입력해주세요 : ");
                    empId = sc.nextInt();

                    ms.deleteMember(empId);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }
}