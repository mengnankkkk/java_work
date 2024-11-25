package com.mengnankk;

import java.util.Scanner;
import java.util.Random;

public class Chacter {
    public static void main(String[] args) {

        String[] roles = {"勇者", "法师", "弓箭手", "骑士", "牧师", "盗贼", "战士", "术士"};


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("欢迎来到抽角色小游戏！");
        System.out.println("我们有以下角色可供选择：");


        for (int i = 0; i < roles.length; i++) {
            System.out.println((i + 1) + ". " + roles[i]);
        }


        System.out.print("请输入你想抽取多少次角色：");
        int drawCount = scanner.nextInt();


        System.out.println("\n开始抽取角色...\n");

        for (int i = 0; i < drawCount; i++) {

            int index = random.nextInt(roles.length);
            System.out.println("第 " + (i + 1) + " 次抽取结果：" + roles[index]);
        }

        System.out.println("\n游戏结束，谢谢参与！");


        scanner.close();
    }
}
