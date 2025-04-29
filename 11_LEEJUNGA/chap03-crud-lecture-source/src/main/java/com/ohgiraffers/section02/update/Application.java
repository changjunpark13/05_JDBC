package com.ohgiraffers.section02.update;

import com.ohgiraffers.section02.update.Menu;
import com.ohgiraffers.section02.update.MenuService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        /* 사용자 화면 시작 부분 */
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 번호 : ");
        int menuCode = sc.nextInt();
        System.out.println("변경할 메뉴 이름 : ");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.println("변경할 메뉴 가격 : ");
        int menuPrice = sc.nextInt();
        /* 사용자 화면 끝 부분 */


        /* Controller 시작 부분 */
        Menu modifyMenu = new Menu(menuCode, menuName, menuPrice);
        MenuService menuService = new MenuService();
        menuService.modifyMenu(modifyMenu);

        System.out.println("[Application] main() : main() End");
    }
}
