package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex08) 문자열에서 여백 제거
 * 주어진 문자열에서 모든 여백을 제거하는 프로그램을 작성하라.
 */
public class Test1_8 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("문자를 입력하세요> ");
        String str = scan.nextLine();

        String[] strArray = str.trim().split("");

        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0 ; i < strArray.length ; i++){
            if (!strArray[i].equals(" ")){
                strBuilder.append(strArray[i]);
            }
        }

        System.out.println(strBuilder);
    }
}
