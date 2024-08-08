package com.coding_test.ex1;

import java.util.Scanner;

/**
 * ex07) 문자열을 int, long, float, double로 변환
 * 주어진 String 객체를 int, long, float, double로 변환하는 프로그램을 작성하라
 */
public class Test1_7 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("문자를 입력하세요> ");
        String str = scan.nextLine();

        int strInt = Integer.parseInt(str);
        long strLong = Long.parseLong(str);
        float strFloat = Float.parseFloat(str);
        double strDouble = Double.parseDouble(str);

        System.out.printf(
            "int : %d\n long : %d\n float : %f\n Double : %f\n",
            strInt, strLong, strFloat, strDouble);
    }

}
