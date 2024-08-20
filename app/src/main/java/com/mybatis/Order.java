package com.mybatis;

import java.sql.Date;

public class Order {
    int no;
    Beverage beverage;
    Customer drinker;
    Date orderDate;

    @Override
    public String toString() {
        return "Order{" +
                "no=" + no +
                ", beverage=" + beverage +
                ", drinker=" + drinker +
                ", orderDate=" + orderDate +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public Customer getDrinker() {
        return drinker;
    }

    public void setDrinker(Customer drinker) {
        this.drinker = drinker;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
