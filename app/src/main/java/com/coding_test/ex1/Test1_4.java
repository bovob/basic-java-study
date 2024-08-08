package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex04) 숫자만 포함하는 문자열인지 검사
 * 주어진 문자열이 숫자만 포함하는지 검사하는 프로그램을 작성하라.
 */
public class Test1_4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("문자를 입력하세요> ");
        String str = scan.nextLine();
        boolean ox = false;

        for (char c : str.toCharArray()) {
           if(!Character.isDigit(c)) {
               ox = false;
               break;
           } else {
               ox = true;
           }
        }

        if (ox){
            System.out.println("숫자로 이루어져 있습니다.");
        } else {
            System.out.println("문자가 포함되어 있습니다.");
        }
    }
}
