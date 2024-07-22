package com.generic.ex_method;

/**
 *  ~/generic/ex01
 *
 *  제네릭(Generic)을 이용하면 여러 타입을 모두 수용할 수 있는 메서드를 만들 수 있다.
 *
 *  (사용법)
 *  <타입_별칭> 타입_별칭 method(타입_별칭 파라미터, ...){ - }
 *  
 */
public class Main3 {

    // What 이라는 Type 파라미터 객체를 생성
    // What 은 메서드가 호출될 때 넘겨주는 파라미터로 결정된다.
    static <What> What echo(What obj){
        return obj;
    }

    public static void main(String[] args) {

        // What -> Object
        Object obj = echo("Hello");

        // What -> String
        String str = echo("world");

    }
}
