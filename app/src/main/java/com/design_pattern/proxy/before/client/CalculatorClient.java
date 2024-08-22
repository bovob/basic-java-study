package com.design_pattern.proxy.before.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class CalculatorClient {

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
}
