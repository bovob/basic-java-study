package com.design_pattern.proxy.after.server;

/**
 * 클라이언트 요청을 서버에 전달하고 서버의 작업 결과를 클라이언트에게 리턴하는 일을 한다.
 * => 즉 중개인 역할을 수행한다.
 *
 * 스텁은 실제 일을 하는 객체를 대행하기 때문에 다음과 같은 규칙에 따라 구현되어야 한다.
 *
 * 1. 클라리언트는 이 스텁 클래스가 실제 일을 하는 객체인양 사용한다.
 * 2. 실제 일을 하는 객체와 같은 규칙을 따르지만, 메서드가 호출될 때
 *    자신이 직접 일을 하지 않고, 실제 일을 하는 객체에게 위임한다.
 *
 *    해당 디자인 패턴을 "" Proxy (프록시) 디자인 패턴 "" 라고 한다.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class CalculatorStub implements Calculator {

    public int compute(int a, int b, String op) throws Exception {
        // 서버 소켓정보 ("IP",Port) 선언
        // 데이터입력/출력 Stream 선언
        try (Socket s = new Socket("localhost", 8888);
             DataOutputStream out = new DataOutputStream(s.getOutputStream());
             DataInputStream in = new DataInputStream(s.getInputStream())
        ) {
            // 서버에 입력받은 a, b값 & 연산자 op를 보낸다.
            out.writeInt(a);
            out.writeInt(b);
            out.writeUTF(op);

            // 서버로부터 OK를 받으면 서버로 부터 받은 결과값 출력
            if (in.readUTF().equalsIgnoreCase("OK")) {
                return in.readInt();
            } else {
                throw new RuntimeException(in.readUTF());
            }
        }
    }

    @Override
    public int plus(int a, int b) {
        try {
            return compute(a, b, "+");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int minus(int a, int b) {
        try {
            return compute(a,b,"-");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
