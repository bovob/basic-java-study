package com.oop.ex_iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 검색 참조
 *  notion 30
 *
 *  ArrayList는 인덱스가 있어
 *  순서대로 출력된다.
 */

public class Main {

    public static void main(String[] args) {
        // List 생성
        ArrayList<String> cars = new ArrayList<>();
        cars.add("벤츠");
        cars.add("람보르기니");
        cars.add("롤스로이스");
        cars.add("페라리");
        // Iterator 획득
        Iterator<String> iterator = cars.iterator();
        // while을 통하여 출력
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
        // for-each를 통하여 출력
        for (String str : cars)
        {
            System.out.println(str);
        }
    }
}
