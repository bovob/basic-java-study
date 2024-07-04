package com.oop.ex_interface.multiple_inheritance;

/** ~/oop/ex09/c 참조
 *
 *  interface의 다중상속
 *
 *  메소드 시그니처(이름, 파라미터, 리턴타입)이 같다면 다중 상속이 가능하다.
 *
 *  (사용법)
 *
 *  class Name implements Interface1, Interface2 { }
 *
 */

interface Inter1{
    int m1();
    float m2();
}

interface Inter2{
    int m1();
    float s2();
}

// Inter3는 1,2를 다중상속 받으며
// 본인도 m3라는 메서드를 구성할 수 있다.
interface Inter3 extends Inter1, Inter2{
    int m3();
}

// m1은 각각 int와 double 반환타입을 가지고 있어
// 1,2와 3에 충돌로 인하여 다중상속 할 수 없다.
//interface InterError extends Inter1, Inter2, Inter3{ }

class MyImpl implements Inter3{

    @Override
    public int m3() {
        return 333;
    }

    @Override
    public int m1() {
        return 111;
    }

    @Override
    public float s2() {
        return 222.f;
    }

    @Override
    public float m2() {
        return 221;
    }
}

public class Main {

    public static void main(String[] args) {

        MyImpl im1 = new MyImpl();
        im1.m1();
        im1.m2();
        im1.m3();
        im1.s2();

        // Interface 객체로 생성시
        // 아래와 같이 전부 선언하여 Overrding 이후
        // } 뒤에 ; 를 붙여줘야 한다.
        //Inter3 inter3 = new Inter3() {
        //    @Override
        //    public int m3() {
        //        return 0;
        //    }
        //
        //    @Override
        //    public int m1() {
        //        return 0;
        //    }
        //
        //    @Override
        //    public float m2() {
        //        return 0;
        //    }
        //
        //    @Override
        //    public float s2() {
        //        return 0;
        //    }
        //};

    }
}
