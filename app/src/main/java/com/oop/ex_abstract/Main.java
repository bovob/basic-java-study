package com.oop.ex_abstract;

/** ~/oop/ex07/a 참조
 *
 *  추상클래스
 *
 *  클래스 앞에 abstract 가 붙으며 직접 사용하지 않는다.
 *  - 서브 클래스에게 공통 필드나 메서드를 상속해주는 것이 목적이다.
 *  - 직접 사용하지 않는다.
 *  - 여러 클래스를 같은 타입으로 묶기 위함이다.
 *  - 상속에서 generalization을 통해 수퍼 클래스를 정의하는 경우에
 *    수퍼 클래스를 주로 추상 클래스로 만든다.
 *
 *  (사용법)
 *  abstract class Name{}
 *
 */

abstract class Abstract1{
}

abstract class Abstract2{
    // 추상 메서드는 구현할 수 없다
    //public abstract void m0(){}; // !! 컴파일 에러
    public abstract void m1();

}

class SubAbstract2 extends Abstract2{

    // 추상 클래스의 서브 클래스는 모든 추상 메서드를 구현해야한다.
    // 그렇지 않다면 추상 메서드로 남아있어야 한다.
    @Override
    public void m1(){
        System.out.println("Sub m1 입니다.");
    }
}


public class Main {

    public static void main(String[] args) {
        // 추상 클래스는 인스턴스를 생성할 수 없다.
        //Abstract1 a1 = new Abstract1(); // !! 컴파일 에러

        // 그러나 레퍼런스는 선언할 수 있다.
        Abstract1 a2 = null;

        SubAbstract2 b1 = new SubAbstract2();
        b1.m1();
    }
}
