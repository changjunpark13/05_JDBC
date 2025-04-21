package com.ohgiraffers.section02.update;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 메뉴 번호 : ");
        int menuCode = sc.nextInt();
        System.out.print("변경할 메뉴 이름 : ");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.print("변경할 메뉴 가격 : ");
        int menuPrice = sc.nextInt();

        Menu modifyMenu = new Menu(menuCode, menuName, menuPrice);
        MenuService menuService = new MenuService();
        menuService.modifyMenu(modifyMenu);
    }
}
