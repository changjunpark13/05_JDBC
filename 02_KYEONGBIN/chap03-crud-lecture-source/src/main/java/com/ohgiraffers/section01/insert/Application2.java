package com.ohgiraffers.section01.insert;

import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Menu name : ");
        String menuName = sc.nextLine();
        System.out.println("Menu price : ");
        int menuPrice = sc.nextInt();
        System.out.println("Menu category code : ");
        int  categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.println("Selling status : ");
        String orderableStatus = sc.nextLine();
        // 사용자 화면 끝 부분

        // Controller 시작 부분
        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        System.out.println("[Application] main() : menu ===>" + menu);

        Menuservice menuservice = new Menuservice();
        menuService.registMenu(menu);
    }

}
