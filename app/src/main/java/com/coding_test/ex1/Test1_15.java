package com.coding_test.ex1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * ex15) 문자열 배열을 길이 순으로 정렬
 * 주어진 문자열에서 배열의 길이로 정렬하는 프로그램을 작성하라
 */
public class Test1_15 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, String> strMap = new HashMap<>();

        while (true){
            int key = 0 ;

            System.out.println("문자를 입력하세요(0 입력시 종료)> ");
            String str = scan.nextLine();

            if (str.equals("0")){
                break;
            } else {
                strMap.put(key, Arrays.toString(str.split("")));
                key++;
            }
        }

        for (int i = 0 ; i < strMap.size() ; i++){
            int[] intArray = new int[strMap.size()];
            intArray[i] = strMap.get(i).length();

            Arrays.stream(intArray).sorted();


        }
    }
}
