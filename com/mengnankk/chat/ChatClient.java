package com.mengnankk.chat;

import java.net.*;
import java.io.*;
import java.util.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int serverPort = 9090;
        Socket socket = new Socket(serverAddress, serverPort);


        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);


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


        System.out.println("请输入文字");
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
