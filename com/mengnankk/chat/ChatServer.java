package com.mengnankk.chat;
import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer {

    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("服务启动...");

        try {
            while (true) {

                new ClientHandler(serverSocket.accept()).start();
            }
        } finally {
            serverSocket.close();
        }
    }


    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);


                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("mengnankkk: " + message);

                    synchronized (clientWriters) {
                        for (PrintWriter writer : clientWriters) {
                            writer.println(message);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            }
        }
    }
}
