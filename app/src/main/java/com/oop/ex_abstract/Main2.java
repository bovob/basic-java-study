package com.oop.ex_abstract;

/** ~/oop/ex07/a 참조
 *
 *  추상메서드
 *
 *  추상메서드는 구현하지 않은 메서드이기 떄문에
 *  일반 클래스(= 구현 클래스; concreate class)는 추상 메서드를 가질 수 없다.
 *
 *  ! 주의
 *  일반 클래스는 인스턴스를 생성할 수 있기 때문에
 *  완전히 정의되지 않은 메스드가 있다면 호출할 때 오류가 발생한다.
 *  따라서 일반 클래스는 추상 메서드를 가지지 못한다.
 *
 *  (사용법)
 *  abstract class Name{
 *      abstract void Method_Name(){}
 *  }
 *
 */

abstract class A2 {
    public abstract void m1();
}

class A2Sub extends A2 {

    @Override
    public void m1() {
        System.out.println("A2Sub.m1() 호출됨!");
    }

    public void m2() {
        System.out.println("A2Sub.m2() 호출됨!");
    }
}

public class Main2 {

    public static void main(String[] args) {

        // 추상 클래스 레퍼런스 선언 가능!
        A2 obj;

        // 추상 클래스는 인스턴스 생성 불가능!
        //obj = new A2(); // !! 컴파일 에러

        // 서브 클래스의 인스턴스 생성 가능!
        obj = new A2Sub();

        // obj 레퍼런스가 가리키는 A2를 사용하지만
        // A2에 m1이 존재하기 떄문에 실행된다.
        obj.m1();

        // obj 레퍼런스가 실제로는 A2를 가리키며 m2가 없기 때문에
        // m2가 정의된 A2Sub 로 형변환을 해야 한다.
        ((A2Sub) obj).m2();

    }
}
