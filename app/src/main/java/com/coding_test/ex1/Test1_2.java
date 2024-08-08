package com.coding_test.ex1;

import java.util.Objects;
import java.util.Scanner;

/**
 *  ex02) 반복되지 않는 첫 번째 문자 찾기
 *  주어진 문자열에서 반복되지 않는 첫 번째 문자를 반환하는 프로그램을 작성하라.
 */

public class Test1_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("글자를 입력하세요> ");

        String str = null;
        str = scan.nextLine();

        String[] strArray = str.split("");

        for (int i = 0 ; i < strArray.length ; i++){
            System.out.println(strArray[i]);
            if (Objects.equals(strArray[0], strArray[i])){
                continue;
            }
            else {
                System.out.println("처음으로 다른 문자는 "+strArray[i]);
                break;
            }
        }
    }
}
