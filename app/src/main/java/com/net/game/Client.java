package com.net.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    // socket에 담을 서버IP:PORT 정보
    private static final String host = "localhost";
    private static final int port = 8888;

    public static void main(String[] args) {
        try{
            // 클라이언트 socket 생성 및 server 정보 담기
            Socket socket = new Socket(host, port);
            System.out.println("서버에 소켓연결 확인");

            // 각 쓰레드 별로 server message read, write
            new Thread(new ReadMessage(socket)).start();
            new Thread(new WriteMessage(socket)).start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // server message 읽어오기
    static class ReadMessage implements Runnable {

        private final Socket socket;
        private BufferedReader in;

        public ReadMessage(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null){
                    System.out.println(message);
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                try{
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }

    // server message 보내기
    static class WriteMessage implements Runnable {
        private final Socket socket;
        private PrintWriter out;
        private BufferedReader consoleInput;

        public WriteMessage(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                consoleInput = new BufferedReader(new InputStreamReader(System.in));

                String message;
                while ((message = consoleInput.readLine()) != null) {
                    out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
