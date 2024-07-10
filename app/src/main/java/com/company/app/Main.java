package com.company.app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();

        System.out.printf("%d", year - 543);

        scan.close();
    }

}
