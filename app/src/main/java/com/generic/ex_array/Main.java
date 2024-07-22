package com.generic.ex_array;

import com.generic.ex_class.Member;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *  제네릭 배열 만들기
 */
public class Main {

    // 예1) 제네릭의 타입 파라미터로 레퍼런스 배열을 생성할 수 있다.
    static <T> T[] create1(){
        T[] arr;
        // 제네릭 타입 파라미터는 new 객체 생성시 사용할 수 없다.
        // arr = new T[10];
        return null;
    }

    // 예2) 견본 배열 arr를 받아서 복제하는 방법을 사용한다.
    static <T> T[] create2(T[] arr){
        // copyOf ( orginLength, newLength )
        return Arrays.copyOf(arr, 11);
    }

    // 예3) 배열의 타입 정보를 받아 생성하기
    static <T> T[] create3(Class<?> type){
        // T[] 확인되지 않은 타입으로 형 변환 후
        // 새로운 인스턴스 newInstance( type , Length ) 로 생성한다.
        return (T[]) Array.newInstance(type, 12);
    }

    // 예4) 견본 배열에서 타입 정보를 추출하여 배열을 생성하기
    static <T> T[] create4(T[] arr){
        // 배열 타입 확인
        Class<?> arrayTypeInfo = arr.getClass();
        System.out.println(arrayTypeInfo);

        // 배열
        Class<?> arrayItemTypeInfo = arrayTypeInfo.getComponentType(); // 예) String
        System.out.println(arrayItemTypeInfo);

        return (T[]) Array.newInstance(arrayItemTypeInfo, 14);
    }

    public static void main(String[] args) {

        // arr 복제
        String[] arr1 = create2(new String[0]);
        System.out.println("arr1 의 크기는 ["+arr1.length+"]");

        // arr2 복제 (크기변경)
        String[] testArr1 = new String[100];
        String[] arr2 = create2(testArr1);
        System.out.println("testArr1 의 크기는 ["+testArr1.length+"]");
        System.out.println("arr2 의 크기는 ["+arr2.length+"]");

        // arr3 class 값 전달 후 생성
        String[] arr3 = create3(String.class);
        System.out.println("arr3 의 크기는 ["+arr3.length+"]");
        Class<?> arr3Class = arr3.getClass();
        Class<?> arr3Type = arr3Class.getComponentType();
        System.out.printf("arr3 Class [%s] Type [%s]\n", arr3Class, arr3Type);

        // arr4 배열을 넘기면 배열의 항목 타입을 알아내 새 배열 생성
        Object[] arr4 = create4(new Integer[0]);
        System.out.println("arr4 의 크기는 ["+arr4.length+"]");
        Class<?> arr4Class = arr4.getClass();
        Class<?> arr4Type = arr4Class.getComponentType();
        System.out.printf("arr4 Class [%s] Type [%s]\n", arr4Class, arr4Type);

        // List 선언과 동시에 초기화 가능
        ArrayList<Member> list = new ArrayList<Member>();
        // 초기화 시 <> 선언과 같다면 생략 가능
        // ArrayList<Member> list = new ArrayList<>();

        // list 에 넣을 타입을 지정할 수 있다.
        list.add(new Member("홍길동", 20));

        // 별도의 형 변환 없이 사용이 가능하다.
        Member member = list.get(0);
        System.out.printf("Member[0] 이름 : %s , 나이 : %d\n", member.name, member.age);
    }
}
