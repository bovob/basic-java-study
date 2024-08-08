package com.net.game;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        // 서버소켓 포트 8888
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server Start");

        while (true) {
            // 클라이언트 소켓 대기
            Socket socket = serverSocket.accept();
            System.out.printf("%d:%d 연결되었습니다. \n", socket.getInetAddress(), socket.getInetAddress().getHostAddress());


        }
    }

}
