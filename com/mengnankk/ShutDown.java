package com.mengnankk;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ShutDown {
    public static void main(String[] args) {
        // 设置定时关机的时间（以毫秒为单位，3600000ms = 1小时）
        long delay = 3600000; // 1小时后关机

        // 创建一个 Timer 对象，用于调度任务
        Timer timer = new Timer();

        // 定义定时任务
        TimerTask shutdownTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    // 执行 Windows 系统的关机命令
                    String command = "shutdown -s -t 0"; // -s表示关机，-t 0表示立即关机
                    Runtime.getRuntime().exec(command);
                    System.out.println("System will shut down now.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        // 安排任务在指定的延迟后执行
        timer.schedule(shutdownTask, delay);

        System.out.println("Shutdown scheduled in 1 hour.");
    }
}
