package com.lang.ex_enhancedFor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** ~/lang/ex06/Exam450~ 참조
 *
 *  Enhanced For 는 JDK 5 부터 추가되었으며
 *
 *  기존 for 루프보다 명확하게 코드를 읽을 수 있게 해주며
 *  간결하게 순회를 할 수 있다.
 *
 *  (사용법)
 *   for (변수타입 변수명 : Iterator 타입){
 *       반복실행문
 *   }
 */


public class Main {

    public static void main(String[] args) {

    // 1. 기본 배열 출력
    int[] intArr = {1,2,3,4,5};

        for(int arr : intArr){
            System.out.println(arr);
        }

    // 2. ArrayList 출력
    ArrayList<Character> arrList = new ArrayList();
        arrList.add('a');
        arrList.add('b');
        arrList.add('c');

        for (char ch : arrList){
            System.out.println(ch);
        }

    // 3. MAP 출력
        Map<Integer, String> scoreMap = new HashMap<>();
        scoreMap.put(100, "백점");
        scoreMap.put(50, "오십점");
        scoreMap.put(0, "빵점");

        for(Map.Entry<Integer, String> entry : scoreMap.entrySet() ){
            System.out.println(entry.getValue() + " : " +entry.getKey());
        }
    }
}
