package com.oop.ex_interface.interface_abstract;

/**
 *  인터페이스와 추상클래스 사용
 *
 *  인터페이스에서 미리 정의한 메서드를 받아서 추상클래스에서 사용할 수 있다.
 *
 */
interface RuleInterface{
    void rule1();
    void rule2();
    void rule3();
    void rule4();
}

abstract class RuleAbstract implements RuleInterface{
    @Override
    public void rule1(){

    }
}

public class Main {

    public static void main(String[] args) {
        RuleAbstract ra = new RuleAbstract() {
            @Override
            public void rule2() {
                System.out.println("Rule2");
            }

            @Override
            public void rule3() {
                System.out.println("Rule3");
            }

            @Override
            public void rule4() {
            }

        };

        // Interface에서 미리 정의해둔 rule1을 사용할 수 있다.
        ra.rule1();

        // Abstract에서 Overriding 한 rule2를 사용할 수 있다.
        ra.rule2();
    }
}
