package com.oop.ex_iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 검색 참조
 *  notion 30
 *
 *  Set은 순서에 상관없이 출력된다.
 */

public class Main2 {

    public static void main(String[] args) {
        // Set 생성
        Set<String> cars = new HashSet<>();
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
