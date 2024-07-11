package com.oop.ex_innerClass.ex01;

/**
 *  ~/oop/ex11/a 참조
 * 
 *  접근범위 -> top level class : 패키지에 소속된 클래스
 */

public class Main {

    public static void main(String[] args) {
        // 동일 패키지는 주소나 그냥 접근할 수 있다.
        com.oop.ex_innerClass.ex01.A o1 = new com.oop.ex_innerClass.ex01.A();
        o1.printNum(1);

        // import도 필요없다.
        A o2 = new A();
        o2.printNum(2);
    }
}
