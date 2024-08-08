package com.net.advanced;

import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String host = "localhost";
    private static final int port = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to the chat server");

            new Thread(new ReadMessage(socket)).start();
            new Thread(new WriteMessage(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ReadMessage implements Runnable {
        private final Socket socket;
        private BufferedReader in;

        public ReadMessage(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
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

