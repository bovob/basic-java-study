package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex18) 두 문자열이 애너그램인지 검사하라
 * 두 문자열이 애너그램인지 검사하는 프로그램을 작성하라
 * 대소문자와 여백을 무시한다.
 *
 * 애너그램이란? 문자열의 순열
 * ex) abc = bca
 */
public class Test1_18 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("문자를 입력하세요> ");
        String str = scan.nextLine();
        boolean ox = false;

        ox = diffStr(str);

        if (ox){
            System.out.println("회문이 맞습니다.");
        } else {
            System.out.println("회문이 아닙니다.");
        }
    }

    private static boolean diffStr(String str) {

        int length = str.length();

        for (int i = 0; i < length/2 ; i++){
            if(str.charAt(i) != str.charAt(length - i - 1)){
                return false;
            }
        } return true;
    }
}
