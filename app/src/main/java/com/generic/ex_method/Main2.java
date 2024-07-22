package com.generic.ex_method;

/**
 *  ~/generic/ex01
 *
 *  제네릭(Generic) 사용 전
 *
 *  echo는 Object 타입으로 원하는 타입으로 리턴값을 받기 위해서는
 *  형변환을 해줘야 한다.
 *
 *  를 보안하기 위하여 각 타입에 대한 echo를 만들어 본다.
 *  
 */
public class Main2 {

    public static Object echo(Object obj){
        return obj;
    }

    public static String echo(String obj){
        return obj;
    }

    public static void main(String[] args) {

        Object obj = echo("Hello");

        // 기존코드는 아래와 같다.
        // String str = (String) echo("world");
        String str = echo("world");

    }
}
