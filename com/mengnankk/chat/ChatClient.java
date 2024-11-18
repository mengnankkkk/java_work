package com.mengnankk.chat;

import java.net.*;
import java.io.*;
import java.util.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int serverPort = 9090;
        Socket socket = new Socket(serverAddress, serverPort);

        // 获取输入输出流
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        // 启动一个线程读取服务器发送来的消息
        Thread readThread = new Thread(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        readThread.start();

        // 发送消息
        System.out.println("Enter your messages (type 'exit' to quit):");
        while (true) {
            String message = scanner.nextLine();
            if (message.equals("exit")) {
                break;
            }
            out.println(message);
        }

        scanner.close();
        socket.close();
    }
}
