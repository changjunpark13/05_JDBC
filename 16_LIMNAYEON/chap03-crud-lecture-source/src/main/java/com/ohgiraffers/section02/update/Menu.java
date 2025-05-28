package com.ohgiraffers.section01.insert;

public class Menu {

    private String menuName;
    private int menuPirce;
    private int categoryCode;
    private String orderbleStatus;

    public Menu( String menuName, int menuPirce, int categoryCode, String orderbleStatus) {

        this.menuName = menuName;
        this.menuPirce = menuPirce;
        this.categoryCode = categoryCode;
        this.orderbleStatus = orderbleStatus;
    }



    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPirce() {
        return menuPirce;
    }

    public void setMenuPirce(int menuPirce) {
        this.menuPirce = menuPirce;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderbleStatus() {
        return orderbleStatus;
    }

    public void setOrderbleStatus(String orderbleStatus) {
        this.orderbleStatus = orderbleStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                ", menuName='" + menuName + '\'' +
                ", menuPirce=" + menuPirce +
                ", categoryCode=" + categoryCode +
                ", orderbleStatus='" + orderbleStatus + '\'' +
                '}';
    }
}
