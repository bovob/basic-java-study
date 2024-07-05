package com.company.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String boldAnsi = "\033[1m";
        String resetAnsi = "\033[0m";
        String appTitle = boldAnsi+"프로젝트"+resetAnsi;
        int number;

        System.out.println(appTitle);
        //
        //Scanner scan = new Scanner(System.in);
        //
        //do {
        //    System.out.print("입력> ");
        //    number = scan.nextInt();
        //
        //    switch (number){
        //        case 1,2,3: System.out.println("123 테스트");
        //        case 4,5,6: System.out.println("456 테스트");
        //        case 7:System.out.println("7 테스트");
        //        default: break;
        //    }
        //    for (int i = 0; i < 2; i++) {
        //        System.out.println("a 태그 입니다.");
        //    }
        //} while(number != 9);
        //
        //String[] numbers = {"one", "two", "three"};
        //for(String asd: numbers) {
        //    System.out.println(asd);
        //}scan.close();

        for (float x=0.1f ; x<= 1.0f ; x+=0.1f){
            System.out.println(x);
        }

    }
}
