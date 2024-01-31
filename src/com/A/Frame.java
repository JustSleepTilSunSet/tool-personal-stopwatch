package com.A;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Frame{
    JFrame jf = null;
    public Frame(String title){
        jf = new JFrame(title);
    }

    public JFrame getFrame(){
        this.jf.setVisible(true);
        return this.jf;
    }

    public Frame setFrame(int width,int height){
        try{
            this.jf.setSize(width, height);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return this;
        }
    }

    public Frame setLayout(){
        GridLayout grid = new GridLayout(1,2);
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        leftPanel.add(new JLabel("Left Panel"));
        rightPanel.add(new JLabel("Right Panel"));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        this.jf.setLayout(grid);
        this.jf.add(splitPane);
        return this;
    }
}