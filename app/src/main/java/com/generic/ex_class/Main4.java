package com.generic.ex_class;

import com.generic.ex_class.Main3.Box;

/**
 *  제네릭 적용
 *
 *  보통 타입 파라미터로 이용하는 경우 아래와 같이
 *  한 가지의 대문자로 된 이름을 사용한다.
 *
 *  T : Type 이라는 의미를 표현할 수 있어 많이 사용된다.
 *  E : Element 라는 의미로 목록의 항목을 가리킬 때 사용한다.
 *  K : Key 객체를 가리킬 때 사용한다.
 *  N : Number 의 의미로 숫자 타입을 가리킬 때 사용한다.
 *  V : Value 의 의미로 값의 타입을 가리킬 때 사용한다.
 *
 *  T, U, V : 한번에 여러 타입을 가리킬 때 이름으로 주로 사용한다. (알파벳 순서)
 */

public class Main4 {

    public static void main(String[] args) {

        Box<Member, String, Integer> obj = new Box<>();

        obj.v1 = new Member("홍길동",20);
        obj.v2 = "Hello World!";
        obj.v3 = Integer.valueOf(100);

        System.out.println(obj);
    }

    // Type Parameter <T>를 받는 Box Class 생성
    // 주로 T U V ... 를 사용한다. (알파벳 순서)
    static class Box<T, U, V>{
        T v1;
        U v2;
        V v3;

        @Override
        public String toString() {
            return "Box{" + "v1=" + v1 + ", v2=" + v2 + ", v3=" + v3 + '}';
        }
    }
}
