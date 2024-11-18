package com.mengnankk;

import java.util.Scanner;
import java.util.Random;

public class Chacter {
    public static void main(String[] args) {
        // 创建角色列表
        String[] roles = {"勇者", "法师", "弓箭手", "骑士", "牧师", "盗贼", "战士", "术士"};

        // 创建 Scanner 和 Random 对象
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("欢迎来到抽角色小游戏！");
        System.out.println("我们有以下角色可供选择：");

        // 打印角色列表
        for (int i = 0; i < roles.length; i++) {
            System.out.println((i + 1) + ". " + roles[i]);
        }

        // 提示用户输入抽取角色的次数
        System.out.print("请输入你想抽取多少次角色：");
        int drawCount = scanner.nextInt();

        // 抽取角色
        System.out.println("\n开始抽取角色...\n");

        for (int i = 0; i < drawCount; i++) {
            // 随机选择一个角色
            int index = random.nextInt(roles.length);
            System.out.println("第 " + (i + 1) + " 次抽取结果：" + roles[index]);
        }

        System.out.println("\n游戏结束，谢谢参与！");

        // 关闭 scanner
        scanner.close();
    }
}
