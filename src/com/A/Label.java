package com.A;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.Timer;
import com.A.Constants;

public class Label implements ActionListener{
    JFrame frame = null;
    JLabel label = null;
    int residualSec = 0;
    String content = "";
    Boolean isTaskLabelMode = false; // ResidualSec with task.
    Boolean isTaskMode = false; // The mode is a name of task.
    Boolean isSecMode = false; // ResidualSec.
    public Label(JFrame frame, int residualSec){
        this.frame = frame;
        this.label = new JLabel(residualSec+"");
        this.residualSec = residualSec;
        this.isSecMode = true;
    }

    public Label(JFrame frame, String content){
        this.frame = frame;
        this.content = content;
        this.label = new JLabel(this.content);
        this.isTaskMode = true;
    }

    public Label(JFrame frame, int residualSec, String content){
        this.frame = frame;
        this.content = content;
        this.label = new JLabel(this.content+": "+residualSec+"s");
        this.residualSec = residualSec;
        this.isTaskLabelMode = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(this.isSecMode){
                this.label.setText(Integer.toString((int)this.residualSec)+"s");
            }else if(this.isTaskLabelMode){
                this.label.setText(this.content+": "+Integer.toString((int)this.residualSec)+"s");
            }
            this.residualSec--;
    }

    public void updateLabel(){
            javax.swing.Timer timer = new javax.swing.Timer(Constants.ONE_SECOND, this);
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
            return;
    }

    public JLabel getJLabel(){
        return this.label;
    }

}