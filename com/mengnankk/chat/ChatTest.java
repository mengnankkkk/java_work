package com.mengnankk.chat;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ChatTest {

    public static void main(String[] args) throws InterruptedException {
        int numberOfClients = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfClients);

        for (int i = 0; i < numberOfClients; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        String serverAddress = "localhost";
                        int serverPort = 9090;
                        Socket socket = new Socket(serverAddress, serverPort);

                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


                        String clientMessage = "Client " + Thread.currentThread().getName() + " message";
                        out.println(clientMessage);
                        System.out.println("Sent: " + clientMessage);


                        String serverMessage = in.readLine();
                        if (serverMessage != null) {
                            System.out.println("Received: " + serverMessage);
                        }

                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
