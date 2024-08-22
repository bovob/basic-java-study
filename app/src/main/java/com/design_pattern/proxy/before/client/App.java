package com.design_pattern.proxy.before.client;

import java.util.Scanner;

/**
 * ~/design_pattern/proxy
 *
 * 클라이언트-서버의 계산기 프로그램을 예시로 작성한다.
 *
 * 클라이언트에 요청을 서버에 전달하고 서버의 작업 결과를 클라이언트에게 리턴을 해주는
 * 중개인 역할을 하는 객체를 "Object Request Broker(ORB)" 라고 부른다.
 *
 * 객체가 있는 서버 측에서 요청과 응답을 대행하는 ORB를 "Skeleton (스켈레톤)"이라 하고
 * 객체를 사용하는 클라이언트 측에서 요청과 응답을 대행하는 ORB를 "Stub (스텁)"이라 한다.
 */

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CalculatorClient calStub = new CalculatorClient();

        try {

        while (true) {
            System.out.print("계산식> (ex> 10 + 20) ");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("quit"))
                break;

            String[] values = input.split(" ");
            try {
                System.out.println(calStub.compute(
                        Integer.parseInt(values[0]),
                        Integer.parseInt(values[2]),
                        values[1]));
            } catch (Exception e) {
                System.out.println("계산오류 " + e.getMessage());
            }

            }
        }
        finally {
            scan.close();
        }
    }
}