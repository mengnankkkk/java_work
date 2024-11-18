package com.mengnankk;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // 创建 Scanner 对象用于读取用户输入
        Scanner scanner = new Scanner(System.in);

        // 创建 Random 对象用于生成随机数字
        Random random = new Random();

        // 生成一个 1 到 100 之间的随机数作为目标数字
        int targetNumber = random.nextInt(100) + 1; // 随机数范围为 1-100
        int userGuess = 0;  // 用户猜测的数字
        int attemptCount = 0;  // 记录猜测次数

        System.out.println("欢迎来到数字猜谜游戏！");
        System.out.println("我已经选择了一个 1 到 100 之间的数字，请猜测它是多少。");

        // 进行循环，直到用户猜对为止
        while (userGuess != targetNumber) {
            // 提示用户输入猜测的数字
            System.out.print("请输入你的猜测：");
            userGuess = scanner.nextInt();
            attemptCount++;

            // 根据用户输入进行判断
            if (userGuess < targetNumber) {
                System.out.println("太小了！再试一次。");
            } else if (userGuess > targetNumber) {
                System.out.println("太大了！再试一次。");
            } else {
                System.out.println("恭喜你，猜对了！");
                System.out.println("你一共猜了 " + attemptCount + " 次。");
            }
        }

        // 关闭扫描器
        scanner.close();
    }
}
