package com.oop.ex_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 검색 참조
 *  notion 30
 *
 *  ArrayList
 */

public class Main3 {

    public static void main(String[] args) {
        // List 생성
        ArrayList<String> list = new ArrayList<>();
        for (char c = 'A' ; c <= 'F' ; c++) {
            String str = String.valueOf(c);
            list.add(str);
        }
        System.out.println("While문 전 리스트 값 : " + list);

        ListIterator<String> listIterator = list.listIterator();

        while (listIterator.hasNext()){
            Object element = listIterator.next();
            listIterator.set(element +"+");
        }

        while (listIterator.hasPrevious()){
            Object element = listIterator.previous();
            System.out.println(element + " ");
        }System.out.println();
    }
}
