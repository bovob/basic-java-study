package com.oop.ex_final;
/** ~/oop/ex06/e 참조
 *
 *  final 사용법
 *
 *  메서드에 final 을 붙이면 서브클래스에서 오버라이딩 할 수 없다.
 *  - 보안에 관련된 일을 하는 메서드
 *  - 템플릿 메서드 디자인 패턴에서 처럼
 *    전체적인 작업 흐름을 정의한 메서드
 *    서브 클래스의 오버라이딩을 막는 것이 좋다.
 *
 *  (사용법)
 *  final return_type method(){}
 *
 */

class A{
    // final 메소드 m1
    final void m1(){
        System.out.println("A의 m1 입니다.");
    }

    // 일반 메소드 m2
    void m2(){
        System.out.println("A의 m2 입니다.");
    }
}


class B extends A{
    // final 메서드는 오버라이딩 할 수 없다.
    //@Override
    //void m1(){ // !! 컴파일 에러
    //    System.out.println("B의 m2 입니다.");
    //}

    // 일반 메서드는 오버라이딩이 가능 하다.
    @Override
    void m2(){
        System.out.println("B의 m2 입니다.");
    }
}

public class Main2{

    public static void main(String[] args) {

        B b = new B();

        b.m1(); // A의 m1 출력
        b.m2(); // B의 m2 출력

    }

}