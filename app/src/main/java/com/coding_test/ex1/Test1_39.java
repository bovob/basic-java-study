package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex39) 컴팩트 수 포멧팅
 * 수 1,000,000 을 1M(미국 로캘)과 1mln(이탈리아 로캘)로 포멧팅 하는 프로그램을 작성하라
 * 또한 문자열 내 1M과 1mln을 수로 파싱해보자
 */
public class Test1_39 {

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
