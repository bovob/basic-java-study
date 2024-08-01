package com.net.ex01.stateful2;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *  다중 클라이언트의 요청 처리하기
 *
 *  클라이언트와 통신하는 부분을 별도의 스레드(실행흐름)로 분리하여 실행한다.
 *
 */
public class CalClient {

    public static void main(String[] args)  throws Exception{
        Scanner keyscan = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        Scanner in = new Scanner(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        while (true) {
            System.out.print("연산자입력 : ");
            out.writeUTF(keyscan.nextLine());
            System.out.print("값 : ");
            out.writeInt(Integer.parseInt(keyscan.nextLine()));

            String str = in.nextLine();
            System.out.println(str);

            if (str.equals("quit"))
                break;

        }
        in.close();
        out.close();
        socket.close();
        keyscan.close();
    }
}
