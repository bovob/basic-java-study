package com.generic.ex_enhance;

/**
 *  Class 자체 만 받을 수 있다.
 *  <Class>
 *
 *  Class 를 상속받은 클래스 이하로 받을 수 있다.
 *  < ? extends Class >
 *
 *  Class 를 자식으로 가지는 클래스 이상만 받을 수 있다.
 *  < ? super Class >
 */

/* ( 구성도 )
 *
 *   Object
 *     |
 *     A
 *    / \
 *   B1 B2
 *   |
 *   C
 */

public class Main {
    public static void main(String[] args) {

        // 일반 선언
        Box<B1> box1;
        box1 = new Box<B1>(); // < > 안에 들어있는 클래스만 받을 수 있다.

        //컴파일 에러
        //box1 = new Box<Object>();
        //box1 = new Box<A>();
        //box1 = new Box<B2>();
        //box1 = new Box<C>();

        //---------------------------------------------------------------

        // B1 상속까지 선언
        Box<? extends B1> box2;
        box2 = new Box<B1>();
        box2 = new Box<C>();

        // 컴파일 에러
        //box2 = new Box<Object>();
        //box2 = new Box<A>();
        //box2 = new Box<B2>();

        //---------------------------------------------------------------

        // B1 부모까지 선언
        Box<? super B1> box3;
        box3 = new Box<B1>();
        box3 = new Box<A>();
        box3 = new Box<Object>();

         //컴파일 에러
        //box3 = new Box<B2>();
        //box3 = new Box<C>();


    }

    static class A {}

    static class B1 extends A {}

    static class B2 extends A {}

    static class C extends B1 {}

    static class Box<T>{
        void set(T obj){}
    }
}
