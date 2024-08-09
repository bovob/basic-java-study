package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex13) 주어진 문자 제거
 * 주어진 문자열에서 주어진 문자를 제거하는 프로그램을 작성하라
 */
public class Test1_13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("문자를 입력하세요> ");
        String str = scan.nextLine();

        System.out.println("삭제할 문자를 입력하세요> ");
        String deleteStr = scan.nextLine();

        StringBuilder strBuilder = new StringBuilder();
        String[] strArray = str.split("");

        for(String c : strArray){
            if (deleteStr.equals(c)){
                continue;
            } else {
                strBuilder.append(c);
            }
        }
        System.out.println(strBuilder);
    }
}
