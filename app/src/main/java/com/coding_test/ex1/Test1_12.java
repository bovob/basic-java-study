package com.coding_test.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ex12) 중복 문자 제거
 * 주어진 문자열에서 중복 문자를 제거하는 프로그램을 작성하라
 */
public class Test1_12 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("문자를 입력하세요> ");
        String str = scan.nextLine();

        String[] strArray = str.split("");
        List strList = new ArrayList<>();

        int length = strArray.length;

        for (int i = 0; i < length ; i++){
            for (int j = 0; j < length ; j++){
                if(strList.isEmpty()){
                    strList.add(strArray[i]);
                }
                if(strList.contains(strArray[i])){
                    break;
                } else {
                    if (strArray[i] == strArray[j]){
                        break;
                    } else {
                        strList.add(strArray[i]);
                    }
                }
            }
        }

        for (Object s : strList){
            System.out.printf((String) s);
        }
    }
}
