package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex33) BigInteger을 원시 타입으로 변환
 * 주어진 BigInteger에서 원시 타입 값을 추출하는 프로그램을 작성하라
 */
public class Test1_33 {

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
