package com.mybatis;

public class Beverage {
    int no;
    String name;
    String kind;
    int price;

    @Override
    public String toString() {
        return "Beverage{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", price=" + price +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}