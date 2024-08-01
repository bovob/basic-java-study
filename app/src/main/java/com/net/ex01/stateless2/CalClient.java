package com.net.ex01.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *  다중 클라이언트의 요청 처리하기
 *
 *  클라이언트와 통신하는 부분을 별도의 스레드(실행흐름)로 분리하여 실행한다.
 *
 */
public class CalClient {

    public static void main(String[] args) throws IOException {
        Scanner keyScan = new Scanner(System.in);

        // 서버에서 클라이언트 구분하기 위한 번호 초기화
        long clientId = 0;

        while (true) {
            // 연산자와 값을 입력받는다.
            System.out.println("연산자");
            String op = keyScan.nextLine();

            System.out.println("값?");
            int value = Integer.parseInt(keyScan.nextLine());

            // 소켓, in & out Stream을 선언한다.
            try (Socket socket = new Socket("localhost", 8888);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream())){

                // 초기화 번호를 보낸다.
                out.writeLong(clientId);

                // 연산자, 값을 넘기고 비운다.
                out.writeUTF(op);
                out.writeInt(value);
                out.flush();

                // 서버에서 보낸 번호를 받는다.
                clientId = in.readLong();

                // 서버에서 보낸 결과를 읽는다.
                int result = in.readInt();
                System.out.printf("계산결과 : %d\n", result);

            }catch (Exception e){
                System.out.println("통신에러!");
            }
            System.out.print("계속하시겠습니까?(Y/n)");
            if (keyScan.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }
        keyScan.close();
    }
}
