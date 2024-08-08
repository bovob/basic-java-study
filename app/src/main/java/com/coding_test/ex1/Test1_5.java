package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex05) 모음과 자음 세기
 * 주어진 문자열에서 모음과 자음 개수를 세는 프로그램을 작성하라.
 * 자음(a, e, i, o, u)
 */
public class Test1_5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("문자를 입력하세요> ");

        String str = scan.nextLine();

        String[] consonant = new String[]{"a","e","i","o","u"};
        String[] strArray = str.split("");

        int sum = 0;

        for (int i = 0 ; i < strArray.length ; i++){
            for (int j = 0 ; j < consonant.length ; j++){
                if (strArray[i].equals(consonant[j])){
                    sum++;
                }
            }
        }
        System.out.println("자음의 총 갯수는 : "+sum);
    }

}
