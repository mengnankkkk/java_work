package com.mengnankk;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ShutDown {
    public static void main(String[] args) {

        long delay = 3600000;


        Timer timer = new Timer();


        TimerTask shutdownTask = new TimerTask() {
            @Override
            public void run() {
                try {

                    String command = "shutdown -s -t 0";
                    Runtime.getRuntime().exec(command);
                    System.out.println("System will shut down now.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };


        timer.schedule(shutdownTask, delay);

        System.out.println("Shutdown scheduled in 1 hour.");
    }
}
