package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex15) 문자열 배열을 길이 순으로 정렬
 * 주어진 문자열에서 배열의 길이로 정렬하는 프로그램을 작성하라
 */
public class Test1_15 {

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
