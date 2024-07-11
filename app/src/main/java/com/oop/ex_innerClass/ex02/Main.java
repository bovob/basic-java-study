package com.oop.ex_innerClass.ex02;

public class Main {

    public static void main(String[] args) {
        // public으로 공개된 클래스는 다른 패키지에서도 접근이 가능하다.
        com.oop.ex_innerClass.ex01.A a = new com.oop.ex_innerClass.ex01.A();
        a.printNum(5);
    }
}
