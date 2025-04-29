package com.ohgiraffers.section02.update;

public class Menu {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int CategoryCode;
    private String orderbleStatus;

    public Menu(int menuCode, String menuName, int menuPrice) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return CategoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        CategoryCode = categoryCode;
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
                ", menuPrice=" + menuPrice +
                ", CategoryCode=" + CategoryCode +
                ", orderbleStatus='" + orderbleStatus + '\'' +
                '}';
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }
}
