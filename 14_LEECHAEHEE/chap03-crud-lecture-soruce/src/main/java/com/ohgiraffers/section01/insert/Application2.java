package com.ohgiraffers.section01.insert;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /*사용자 화면 시작*/
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴명 : ");
        String menuName = sc.nextLine();
        System.out.print("메뉴 가격 : ");
        int menuPrice = sc.nextInt();
        System.out.print("카테고리 코드 : ");
        int categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.println("판매상태 : ");
        String orderableStatus = sc.nextLine();
        /* 사용자 화면 끝 */

        /* Controller 시작 부분 */
        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        System.out.println("[Application] main() : menu ====> " + menu);
        MenuService menuService = new MenuService();
        menuService.registMenu(menu);
        System.out.println("[Application] main() : menu ====> End");
    }
}
