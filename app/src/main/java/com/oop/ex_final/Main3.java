package com.oop.ex_final;
/** ~/oop/ex06/e 참조
 *
 *  final 사용법
 *
 *  필드에 final 을 붙이면 상수 필드가 된다.
 *  생성자에서 초기화를 시켜야 한다.
 *
 *  (사용법)
 *  final 변수명 ;
 *
 */

class Final3{

    // 상수필드는 보통 인스턴스 마다 개별적으로 관리하지 않는다.
    // 보통 스태틱 필드(클래스 필드)로 만든다.
    // 공개할 경우 public 으로 선언한다.
    public static final int v1 = 100;

    // 스태틱 상수 필드는 스태틱 블록에서 초기화시킬 수 있다.
    public static final int v2;
    static {
        v2 = 200;
    }

}


public class Main3{

    public static void main(String[] args) {
        //final int a; !! 컴파일 에러발생 초기화를 해줘야한다.
        final int v1 = 0;

        // final 상수는 딱 한번만 값을 설정할 수 있다.
        //v1 = 100; // !! 컴파일 에러

        System.out.println(Final3.v1); // 100
        System.out.println(Final3.v2); // 200

    }

}