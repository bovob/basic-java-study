package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex06) 문자 빈도수 세기
 * 주어진 문자열에서 특정 문자의 빈도수를 세는 프로그램을 작성하라
 */
public class Test1_6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("문자를 입력하세요> ");
        String str = scan.nextLine();

        String[] strArray = str.split("");

        System.out.println("특정 문자를 입력하세요>");
        String target = scan.nextLine();

        int sum = 0;
        for(int i = 0 ; i < strArray.length ; i++){
            if (strArray[i].equals(target)){
                sum++;
            }
        }
        System.out.println(target+"의 총 갯수는 : "+sum);
    }
}
