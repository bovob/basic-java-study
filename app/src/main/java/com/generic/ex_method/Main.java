package com.generic.ex_method;

/**
 *  ~/generic/ex01
 *
 *  제네릭(Generic) 사용 전
 *
 *  echo는 Object 타입으로 원하는 타입으로 리턴값을 받기 위해서는
 *  형변환을 해줘야 한다.
 *
 */
public class Main {

    public static Object echo(Object obj){
        return obj;
    }

    public static void main(String[] args) {
        // 리턴 타입이 Object이기 떄문에
        // 형변환을 통하여 사용해야 한다.
        Object obj = echo("Hello");
        String str = (String) echo("world");

    }
}
