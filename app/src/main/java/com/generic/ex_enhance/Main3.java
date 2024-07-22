package com.generic.ex_enhance;

import com.generic.ex_class.Member;
import java.util.HashMap;

/**
 *  HashMap과 제네릭
 */

public class Main3 {
    public static void main(String[] args) {
        // HashMap ( key, value ) 에서 타입을 지정하지 않는경우
        // 컴파일러 경고가 나타나지만 정상적으로 결과 값은 나온다.
        HashMap map = new HashMap();
        map.put("aaa",1111);
        map.put(222,"Value");

        System.out.println(map.get("aaa"));
        System.out.println(map.get(222));

        // 하지만 위와 같이 사용하는 경우 아래와 같이
        // 타입을 지정하는 것을 권장한다.
        HashMap<Object, Object> map2 = new HashMap<>();
        map.put("bbb",22);
        map.put(999,"Value");

        System.out.println(map.get("bbb"));
        System.out.println(map.get(999));

        // 타입을 정의하는경우 값을 꺼낼 때 형변환이 필요 없다.
        // Key : Integer
        // Value : Memeber
        HashMap<Integer, Member> memberHashMap = new HashMap<>();
        memberHashMap.put(1, new Member("홍길동", 20));
        memberHashMap.put(2, new Member("유관순", 25));

        System.out.println(memberHashMap.get(1));
        System.out.println(memberHashMap.get(2));
    }
}