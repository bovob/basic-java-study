package com.oop.ex_interface.after;
/** ~/oop/ex08/b/Exam05 참조
 *
 * Interface에서의 static 사용
 *
 * Interface와 Abstract 는 둘 다 상속받은 Class에
 * 모든 메서드의 구현을 강제 하지만
 *
 * 추상화클래스는 해당 메서드의 기능을 구현/확장하는 데 있으며
 *
 * 인터페이스는 상속받는 클래스들의 공통적인 기능의 보장에 의의가 있다.
 *
 */

interface Myinterface {
    // static void m1 생성
    /*public*/static void m1(){ System.out.println("Myinterface .m1");}
}

class Parent {
    // 부모 클래스 생성
    static void m2(){ System.out.println("Parent .m2");}
}

class MyImpl extends Parent implements Myinterface{
}

public class Main3 {

    public static void main(String[] args) {

        // 1. interface의 static method 사용
        Myinterface.m1(); // 가능

        // 2. Class의 static method 사용
        Parent.m2(); // 가능

        // 3. MyImpl의 Interface static method 사용
        //MyImpl.m1(); // 불가능

        // 4. MyImpl의 Super Class static method 사용
        MyImpl.m2(); // 가능

        // 5. MyImpl의 객체 생성
        MyImpl obj = new MyImpl(); // 가능

        // 6. MyImpl 객체를 통한 Interface static method 사용
        //obj.m1(); // 불가능

        // 7. MyImpl 객체를 통한 Super Class static method 사용
        Parent.m2(); //가능
        // 하지만 static method는 가능한 선언된 메서드를 통해서 호출하는 것이 좋다.
    }

}
