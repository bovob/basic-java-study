package com.generic.ex_array;

import java.util.ArrayList;

/**
 *
 *
 */

/*  (구성도)
 *
 *   Object
 *     |
 *     A
 *    / \
 *   B1 B2
 *   | \
 *   C  D
 */

public class Main3 {
    public static void main(String[] args) {
        // m1메서드에서는 B1을 상속받는 클래스만 허용한다.
        // 따라서 B1, C, D는 타입 선언이 가능하다.
        m1(new ArrayList<B1>());
        m1(new ArrayList<C>());
        m1(new ArrayList<D>());
        // Object, A, B2 선언 불가능
        //m1(new ArrayList<Object>());
        //m1(new ArrayList<A>());
        //m1(new ArrayList<B2>());

        //--------------------------------------------------------

        // m2메서드에서는 B1의 부모 클래스만 허용한다.
        // 따라서 Object, A, B1 타입 선언이 가능하다.
        m2(new ArrayList<Object>());
        m2(new ArrayList<A>());
        m2(new ArrayList<B1>());
        // C, D, B2 선언 불가능
        //m2(new ArrayList<C>());
        //m2(new ArrayList<D>());
        //m2(new ArrayList<B2>());
    }

    static void m1(ArrayList<? extends B1> list){
        // B1을 상속받은 클래스만 파라미터로 받기 때문에
        // B1 이상의 조상 클래스를 그대로 사용할 수 있다.
        // 따라서 B1, A, Object 가져와서 사용하기 가능하다.
        Object obj1 = list.get(0);
        A obj2 = list.get(1);
        B1 obj3 = list.get(2);
        // 컴파일 에러
        //B2 obj4 = list.get(3);
        //C obj5 = list.get(4);
        //D obj5 = list.get(5);

        // 파라미터의 타입이 정해지지 않아 컴파일 요류가 발생한다.
        //list.add(new B1());
    }

    static void m2(ArrayList<? super B1> list){
        // B1 타입 및 그 이상의 타입에 대해 파라미터로 넘길 수 있다.
        // 넘어오는 타입이 상위기 때문에
        Object obj1 = list.get(0);
        // 컴파일 에러
        //A obj2 = list.get(1);
        //B1 obj3 = list.get(2);
        //B2 obj4 = list.get(3);
        //C obj5 = list.get(4);
        //D obj5 = list.get(5);

        // 하위 클래스의 선언이 가능하다.
        // 하위 클래스는 상위 클래스 사용이 가능하기 때문에
        list.add(new B1());
        list.add(new C());
        list.add(new D());
        // 컴파일 에러
        //list.add(new Object());
        //list.add(new A());
    }

    static class A {}

    static class B1 extends A {}

    static class B2 extends A {}

    static class C extends B1 {}

    static class D extends B1 {}
}
