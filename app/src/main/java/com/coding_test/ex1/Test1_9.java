package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex09) 구분자로 여러 문자열 합치기
 * 주어진 문자열을 주어진 구분자로 합치는 프로그램을 작성하라
 */
public class Test1_9 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("구분자를 입력하세요> ");
        String dot = scan.nextLine();

        System.out.println("문자를 입력하세요(종료:0)> ");

        StringBuilder strBuilder = new StringBuilder();

        while(true) {
            String str = scan.nextLine();
            if (str.equals("0")){
                strBuilder.setLength(strBuilder.length()-dot.length());
                break;
            } else {
                strBuilder.append(str);
                strBuilder.append(dot);
            }
        }
        System.out.println(strBuilder);
    }
}
