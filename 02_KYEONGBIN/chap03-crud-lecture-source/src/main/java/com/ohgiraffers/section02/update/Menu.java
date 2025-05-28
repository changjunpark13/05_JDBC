package com.ohgiraffers.section02.update;

public class Menu {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String ordarableStatus;

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
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
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrdarableStatus() {
        return ordarableStatus;
    }

    public void setOrdarableStatus(String ordarableStatus) {
        this.ordarableStatus = ordarableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", ordarableStatus='" + ordarableStatus + '\'' +
                '}';
    }

    public Menu(int menuCode, String menuName, int menuPrice) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;


    }
}
