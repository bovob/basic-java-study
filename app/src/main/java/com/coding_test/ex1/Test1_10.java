package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex10) 모든 순열 생성
 * 주어진 문자열의 모든 순열을 생성하는 프로그램을 작성하라
 * 모든순열 이란? 입력받은 모든 글자의 경우의 수
 * ex) abc
 * abc acb bac bca cba cab
 */
public class Test1_10 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("문자를 입력하세요> ");
        String str = scan.nextLine();

        generatePermutation("", str);
    }

    private static void generatePermutation(String fix, String str) {
        int length = str.length();
        if (length == 0){
            System.out.println(fix);
        } else {
            for (int i = 0; i < length; i++){
                generatePermutation(fix + str.charAt(i), str.substring(0, i)+str.substring(i+1, length));
            }
        }
    }
}
