package com.bw.impl;

public abstract class House {
    private Integer id;
    private String address;
    private Double area;
    private boolean isRented;
    private String description;

    public House(String address, Double area, boolean isRented) {
        if (address.length() < 10) {
            System.out.println("错误: 地址长度必须大于10个字符!");
            return;
        }
        this.address = address;
        this.area = area;
        this.isRented = isRented;
    }

    public String getAddress() { return address; }

    public Double getArea() { return area; }

    public void setRented(boolean rented) { isRented = rented; }

    @Override
    public String toString() {
        String rentStatus = isRented ? "已出租" : "未出租";
        String agency = "链家";
        return "房屋编号：" + id + ", 地址：" + address + ", 面积：" + area + "平方米, 状态：" + rentStatus + ", 描述：" + description + ", 出租单位：" + agency;
    }

    public abstract int getId();

    public boolean isRented() {
        return false;
    }

}

// Apartment Class
class Apartment extends House {
    private final int roomNumber;

    public Apartment(String address, Double area, boolean isRented, int roomNumber) {
        super(address, area, isRented);
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", 房间号：" + roomNumber;
    }

    @Override
    public int getId() {
        return 0;
    }
}

// Villa Class
class Villa extends House {
    private final Double gardenArea;

    public Villa(String address, Double area, boolean isRented, Double gardenArea) {
        super(address, area, isRented);
        this.gardenArea = gardenArea;
    }

    @Override
    public String toString() {
        return super.toString() + ", 花园面积：" + gardenArea + "平方米";
    }

    @Override
    public int getId() {
        return 0;
    }
}