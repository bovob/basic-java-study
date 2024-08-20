package com.mybatis;

public class Customer {
    int no;
    String name;
    String email;

    @Override
    public String toString() {
        return "Customer{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
