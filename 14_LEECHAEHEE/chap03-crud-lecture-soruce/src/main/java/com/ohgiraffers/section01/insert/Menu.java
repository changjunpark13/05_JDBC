package com.ohgiraffers.section01.insert;

public class Menu {
    private String menuName;
    private int menuPrice;
    private int CategoryCode;
    private String orderbleStatus;

    public Menu(String menuName, int menuPrice, int categoryCode, String orderbleStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        CategoryCode = categoryCode;
        this.orderbleStatus = orderbleStatus;
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
}
