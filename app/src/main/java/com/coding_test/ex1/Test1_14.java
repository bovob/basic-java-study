package com.coding_test.ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * ex14) 빈도수가 가장 높은 문자 찾기
 * 주어진 문자열에서 빈도수가 가장 높은 문자를 찾는 프로그램을 작성하라
 */
public class Test1_14 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("문자를 입력하세요> ");
        String str = scan.nextLine();

        String[] strArray = str.split("");
        List strList = new ArrayList<>();
        Map<String, Integer> strMap = new HashMap<>();

        int length = strArray.length;

        for (int i = 0; i < length ; i++){
            for (int j = 0; j < length ; j++){
                if(strList.isEmpty()){
                    strList.add(strArray[i]);
                    strMap.put(strArray[i],1);
                } else {
                    if(strList.contains(strArray[i])){
                        int num = strMap.get(strArray[i]);
                        strMap.put(strArray[i], num++);
                        break;
                    } else {
                        if (strArray[i] == strArray[j]){
                            break;
                        } else {
                            strList.add(strArray[i]);
                            strMap.put(strArray[i],1);
                        }
                    }
                }
            }
        }



        for (Object s : strList){
            System.out.printf("%s : %d", s, strMap.get((String)s));
        }
    }
}
