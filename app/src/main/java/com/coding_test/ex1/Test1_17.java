package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex17) 문자열 내 부분 문자열 빈도수 세기
 * 주어진 문자열에서 또 다른 주어진 문자열의 빈도수를 세는 프로그램을 작성하라
 */
public class Test1_17 {

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
