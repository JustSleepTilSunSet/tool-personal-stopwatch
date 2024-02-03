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
    JLabel testing = null;
    public Frame(String title){
        jf = new JFrame(title);
    }

    public Frame getFrame(){
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

    public void updateLabel(){
        JLabel rightLabel = this.rightLabel;
        javax.swing.Timer timer = new javax.swing.Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightLabel.setText(Integer.toString((int)Math.round(Math.random() * 100)));
            }
        });

        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
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

    public Frame setLeftPanel(){
        this.leftPanel.setLayout(new BoxLayout(this.leftPanel, BoxLayout.Y_AXIS));
        
        this.leftPanel.add(createNewLabel(1));
        this.leftPanel.add(createNewLabel(2));
        return this;
    }

    public Frame setRightPanel(){ 
        this.rightPanel.add(this.rightLabel);
        return this;
    }
}