package com.mengnankk;

import java.awt.*;
import java.awt.event.InputEvent;

public class Mouse {
    public static void main(String[] args) {
        try {

            Robot robot = new Robot();


            int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
            int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;


            for (int i = 0; i < 1000; i++) {

                int x = (int) (Math.random() * screenWidth);
                int y = (int) (Math.random() * screenHeight);


                robot.mouseMove(x, y);


                robot.delay(100);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
