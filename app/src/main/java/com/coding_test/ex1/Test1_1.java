package com.coding_test.ex1;

import java.util.Scanner;

/**
 *  ex01) 문자 개수 세기
 *  주어진 문자열에서 문자 개수를 세는 프로그램을 작성하라.
 */

public class Test1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("글자를 입력하세요> ");

        String str = null;
        str = scan.nextLine();

        int strLength = 0;
        strLength = str.length();

        System.out.printf("입력한 문자의 길이는 %d 개 입니다.\n", strLength);

        scan.close();
    }
}
