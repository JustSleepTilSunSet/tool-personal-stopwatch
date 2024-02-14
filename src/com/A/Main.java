package com.A;
import com.A.Label;
import com.A.TaskCheckBox;
import com.A.ButtonTemplate;
import com.A.MainFrame;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.Timer;

public class Main{
    public static void LabelAnimation() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                // To wait loading of L&F done.
                MainFrame mf = new MainFrame("Main")
                    .setSize();
                mf.initializeRightPanel();
                mf.toShow();
            }
        });
    }
    public static void main(String[]args){
        LabelAnimation();
    }
}