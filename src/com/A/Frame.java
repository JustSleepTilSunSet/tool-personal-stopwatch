package com.A;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.Timer;

public class Frame{
    JFrame jf = null;
    JLabel leftLabel = new JLabel("Left Panel");
    JLabel rightLabel = new JLabel("Right Panel");
    JPanel leftPanel = new JPanel(new BorderLayout());
    JPanel rightPanel = new JPanel();
    public Frame(String title){
        jf = new JFrame(title);
    }

    public JFrame getCurrentFrame(){
        return this.jf;
    }

    public Frame showFrame(){
        this.jf.setVisible(true);
        return this;
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

    public static  JLabel createNewLabel(Object content){
        // return new JLabel("<html> "+content+" <br/></html>", SwingConstants.CENTER);
        return new JLabel(content.toString(), SwingConstants.CENTER);
    }

    public Frame setLayout(){
        GridLayout grid = new GridLayout(1,2);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.leftPanel, this.rightPanel);
        this.jf.setLayout(grid);
        this.jf.add(splitPane);
        return this;
    }

    public Frame addLabelToLeftPanel(JLabel label){
        this.leftPanel.add(label);
        return this;
    }

    public Frame setRightPanel(){
        this.rightPanel.setLayout(new BoxLayout(this.rightPanel, BoxLayout.Y_AXIS));
        return this;
    }

    public Frame addLabelToRightPanel(JLabel label){
        this.rightPanel.add(label);
        return this;
    }

    public Frame setLeftPanel(){
        this.leftPanel.setLayout(new BoxLayout(this.leftPanel, BoxLayout.Y_AXIS));
        return this;
    }

}