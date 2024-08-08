package com.net.advanced;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final Set<ClientHandler> clientHandlers = new HashSet<>();
    private static int clientId = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Chat server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());
            ClientHandler clientHandler = new ClientHandler(socket, clientId++);
            clientHandlers.add(clientHandler);
            new Thread(clientHandler).start();
        }
    }

    public static void broadcastMessage(String message, ClientHandler excludeClient) {
        for (ClientHandler client : clientHandlers) {
            if (client != excludeClient) {
                client.sendMessage(message);
            }
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;
        private final int id;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket, int id) {
            this.socket = socket;
            this.id = id;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received from client " + id + ": " + message);
                    ChatServer.broadcastMessage("Client " + id + ": " + message, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clientHandlers.remove(this);
                System.out.println("Client " + id + " disconnected");
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}
