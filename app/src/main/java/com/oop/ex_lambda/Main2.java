package com.oop.ex_lambda;

import org.checkerframework.checker.units.qual.C;

interface A{
    void play();
}

interface INT{
    void m1(String A);
}

public class Main2 {

    public static void main(String[] args) {

        class B implements A{
            @Override
            public void play() {
                System.out.println("일반");
            }
        }

        A p1 = new B();
        p1.play();


        A p2 = new B(){
            @Override
            public void play() {
                System.out.println("익명");
            }
        };
        p2.play();


        new B(){
            @Override
            public void play() {
                System.out.println("익명1");
            }
        }.play();

        A p3 = () -> {System.out.println("람다1");};
        p3.play();

        A p4 = () -> System.out.println("람다2");
        p4.play();

        //--------------------------------------------


    }

}
