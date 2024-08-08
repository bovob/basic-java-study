package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex03) 글자와 단어 뒤집기
 * 각 단어의 글자를 뒤집는 프로그램과 각 단어의 글자와 각 단어를 뒤집는 프로그램을 작성하라
 */

public class Test1_3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("단어 혹은 문장을 입력하세요> ");

        String str = scan.nextLine();

        // 1.
         String[] strArray = str.split("");
         StringBuilder strBuilder = new StringBuilder();

         for (int i = 0 ; i < strArray.length/2 ; i++){
             String tmp = strArray[i];
             strArray[i] =  strArray[(strArray.length-1)-i];
             strArray[(strArray.length-1)-i] = tmp;
         }

         for (String s : strArray){
             strBuilder.append(s);
         }

        // 2.
        //StringBuilder strBuilder = new StringBuilder(str);
        //strBuilder.reverse();

        // 3.
        //String[] words = str.split(" ");
        //StringBuilder strBuilder = new StringBuilder();
        //
        //for (String word : words) {
        //    StringBuilder reverseWord = new StringBuilder(word);
        //    strBuilder.append(reverseWord.reverse()).append(" ");
        //}
        System.out.println(strBuilder);
    }
}
