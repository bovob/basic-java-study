package com.generic.ex_enhance;

import com.generic.ex_class.Member;
import java.util.ArrayList;

/**
 *  <?> 타입 선언시
 *
 *  객체 생성시 어떠한 타입을 지정해도 상관없지만
 *  메서드를 사용할 때 주의해야한다.
 *
 *  컴파일러가 문법의 유효여부를 검사할 수 없게된다.
 *
 *  따라서 항상 제네릭 타입 선언시엔
 *  <제네릭 타입> 을 명확하게 지정하자.
 */

public class Main2 {

    public static void main(String[] args) {

        // <?> 타입선언
        ArrayList<?> list;

        // 선언가능
        list = new ArrayList();
        list = new ArrayList<>();
        list = new ArrayList<String>();
        list = new ArrayList<Member>();

        // 컴파일 에러
        //list.add("test");
        //list.add(Integer.valueOf(100));

    }

}
