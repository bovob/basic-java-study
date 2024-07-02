package com.oop.ex_final;
/** ~/oop/ex06/e 참조
 *
 *  final
 *
 *  클래스에 final을 붙이면 해당 클래스에 서브 클래스를 만들 수 없다.
 *  - 서브 클래스의 생성을 방지하여 기존 클래스를 대체하지 못하도록 한다.
 *
 *  (사용법)
 *   final class ClassName{}
 *
 */

final class 단팥빵{ }

// final class인 단팥빵의 
// 서브 클래스를 생성할 수 없다.
// class 크림단팥빵 extends 단팥빵{} // !! 컴파일 에러

// String class는 final 클래스로
// 서브 클래스를 정의할 수 없다.
//class MyString extends String{} // !! 컴파일 에러

public class Main{

    public static void main(String[] args) {
        먹는다(new 단팥빵());
    }

    static void 먹는다(단팥빵 빵){

    }

}
