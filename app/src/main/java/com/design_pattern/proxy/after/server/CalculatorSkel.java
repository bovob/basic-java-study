package com.design_pattern.proxy.after.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  클라이언트 요청을 실제 일을 하는 객체에게 전달하고
 *  객체가 작업한 결과를 클라이언트에게 보내는 역할을 한다.
 *
 *  해당 ORB는 Skeleton 이다.
 *  -> 이전 CalculatorServer
 */

public class CalculatorSkel {

    public static void main(String[] args) throws IOException {
        Calculator calc = new CalculatorImpl();

        try (ServerSocket ss = new ServerSocket(8888)) {
            System.out.println("서버 실행중 . . .");

            while (true) {
                try (Socket s = ss.accept();
                    DataInputStream in = new DataInputStream(s.getInputStream());
                    DataOutputStream out = new DataOutputStream(s.getOutputStream())) {

                    int a = in.readInt();
                    int b = in.readInt();
                    String op = in.readUTF();

                    switch (op) {
                        case "+":
                            out.writeUTF("OK");
                            out.writeInt(calc.plus(a, b));
                            break;
                        case "-":
                            out.writeUTF("OK");
                            out.writeInt(calc.minus(a, b));
                            break;
                        default:
                            out.writeUTF("FAIL");
                            out.writeUTF("해당 연산자는 지원하지 않습니다.");
                    }
                    out.flush();
                }
                catch (Exception e) {
                    System.out.println("에러발생 :" + e.getMessage());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}