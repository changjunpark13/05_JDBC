package com.ohgiraffers.crud.domain.member.view;

import com.ohgiraffers.crud.domain.member.dto.Member;
import com.ohgiraffers.crud.domain.member.service.MemberService;

import java.util.Scanner;

public class MemberView {

    public static void main(String[] args) {
        MemberService ms = new MemberService();

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
            sc.nextLine();

            switch (input) {
                case 1:
                    ms.selectAllMember();
                    break;
                case 2:
                    System.out.print("찾으실 회원 이름 검색 : ");
                    String searchName = sc.nextLine();
                    ms.searchMember(searchName);
                    break;
                case 3:
                    System.out.print("번호 입력 : ");
                    String empId = sc.nextLine();
                    System.out.print("이름 입력 : ");
                    String empName = sc.nextLine();
                    System.out.print("주민번호 입력 : ");
                    String empno = sc.nextLine();
                    System.out.print("잡 코드 입력 : ");
                    String jobCode = sc.nextLine();
                    System.out.print("sal level 입력 : ");
                    String salLevel = sc.nextLine();
                    Member member = new Member(empId, empName, empno, jobCode, salLevel);
                    ms.insertMember(member);
                    break;
                case 4:
                    System.out.print("변경할 회원 번호 : ");
                    int empCode = sc.nextInt();
                    sc.nextLine();
                    System.out.print("변경할 회원 이름 : ");
                    String name = sc.nextLine();
                    ms.updateMember(empCode, name);
                    break;
                case 5:
                    System.out.print("탈퇴할 이름 입력 : ");
                    String removeName = sc.nextLine();
                    ms.deleteMember(removeName);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

}
