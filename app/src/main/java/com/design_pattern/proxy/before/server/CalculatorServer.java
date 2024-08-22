package com.design_pattern.proxy.before.server;

import com.design_pattern.proxy.before.client.CalculatorClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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

public class CalculatorServer {
    public static void main(String[] args) throws IOException {
        // 계산 클래스 인스턴스 생성
        Calculator calc = new Calculator();

        //서버 소켓 생성
        try (ServerSocket ss = new ServerSocket(8888)){
            System.out.println("서버실행중 ...");

            while (true){
                // 데이터입력/출력 Stream 선언
                try(Socket s = ss.accept();
                    DataInputStream in = new DataInputStream(s.getInputStream());
                    DataOutputStream out = new DataOutputStream(s.getOutputStream())){

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
                }catch (Exception e){
                    System.out.println("에러발생 :" + e.getMessage());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}