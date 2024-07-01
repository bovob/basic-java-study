package com.oop.ex_overloading;

public class A {
    // 파라미터의 타입이나 개수가 다르지만 이름이 같은 메서드를 여러 개 만들 수 있다.
    static public void m() {
        System.out.println("m()");
    }
    static public void m(int a) {
        System.out.println("m(int)");
    }
    static public void m(String a) {
        System.out.println("m(String)");
    }
    static public void m(String a, int b) {
        System.out.println("m(String,int)");
    }
    static public void m(int a, String b) {
        System.out.println("m(int,String)");
    }
}
