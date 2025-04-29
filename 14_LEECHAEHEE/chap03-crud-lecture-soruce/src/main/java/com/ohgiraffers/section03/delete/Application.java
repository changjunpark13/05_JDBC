package com.ohgiraffers.section03.delete;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴 번호: ");
        int menuCode = sc.nextInt();
        Menu deleteMenu = new Menu(menuCode);
        MenuService.deleteMenu(deleteMenu);
    }
}
