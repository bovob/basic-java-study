package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex11) 문자열 회문 검사
 * 주어진 문자열이 회문인지 알아내는 프로그램을 작성하라
 * 회문이란? 그대로읽어도 반대로읽어도 같은 글자
 * ex) 토마토, txt
 */
public class Test1_11 {

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
