package com.A;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Constants{
    public static String TITLE = "Title";
    public static int WIDTH =  300;
    public static int HEIGHT =  600;
    public static int ONE_SECOND =  1000;
    public static int TASK_TAG = 1;
    public static void LabelAnimation() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
            }
        });
    }
}