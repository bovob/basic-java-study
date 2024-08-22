package com.design_pattern.proxy.after.client;

import com.design_pattern.proxy.after.server.Calculator;
import com.design_pattern.proxy.after.server.CalculatorStub;
import java.util.Scanner;

/**
 * ~/design_pattern/proxy
 *
 * 서버에서 제공하는 객체를 사용하여 계산을 수행한다. 프록시 객체는 마치 자신이 실제 일을 하는 것 처럼 행동한다.
 */

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calc = new CalculatorStub();
        try {

            while (true) {
                System.out.print("계산식> (ex> 10 + 20) ");
                String input = scan.nextLine();
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }

                String[] values = input.split(" ");
                try {
                    int a = Integer.parseInt(values[0]);
                    int b = Integer.parseInt(values[2]);
                    String op = values[1];

                    // 이렇게 Calculator를 로컬에서 사용하는 것처럼
                    // CalculatorStub 이라는 프록시를 통해 작업을 수행할 수 있다.
                    // 서버 개발자가 프록시 객체를 만들어 제공하기 때문에
                    // 서버와 통신하는 코드를 따로 작성할 필요가 없다.
                    switch (op) {
                        case "+":
                            System.out.println(calc.plus(a, b));
                            break;
                        case "-":
                            System.out.println(calc.minus(a, b));
                            break;
                        default:
                            System.out.println("해당 연산자는 지원하지 않습니다.");
                    }
                }
                catch (Exception e) {
                    System.out.println("계산오류 " + e.getMessage());
                }
            }
        } finally {
          scan.close();
        }
    }
}