package com.mengnankk;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Random random = new Random();


        int targetNumber = random.nextInt(100) + 1;
        int userGuess = 0;
        int attemptCount = 0;

        System.out.println("欢迎来到数字猜谜游戏！");
        System.out.println("我已经选择了一个 1 到 100 之间的数字，请猜测它是多少。");


        while (userGuess != targetNumber) {

            System.out.print("请输入你的猜测：");
            userGuess = scanner.nextInt();
            attemptCount++;


            if (userGuess < targetNumber) {
                System.out.println("太小了！再试一次。");
            } else if (userGuess > targetNumber) {
                System.out.println("太大了！再试一次。");
            } else {
                System.out.println("恭喜你，猜对了！");
                System.out.println("你一共猜了 " + attemptCount + " 次。");
            }
        }


        scanner.close();
    }
}
