package com.A;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.Timer;

public class TaskCheckBox implements ActionListener{
    JFrame frame = null;
    Checkbox checkBox = null;
    int residualSec = 0;
    String content = "";
    Boolean isTaskLabelMode = false; // ResidualSec with task.
    Boolean isTaskMode = false; // The mode is a name of task.
    Boolean isSecMode = false; // ResidualSec.
    public TaskCheckBox(JFrame frame, int residualSec){
        this.frame = frame;
        this.checkBox = new Checkbox(residualSec+"");
        this.residualSec = residualSec;
        this.isSecMode = true;
    }

    public TaskCheckBox(JFrame frame, String content){
        this.frame = frame;
        this.content = content;
        this.checkBox = new Checkbox(this.content);
        this.isTaskMode = true;
    }

    public TaskCheckBox(JFrame frame, int residualSec, String content){
        this.frame = frame;
        this.content = content;
        this.checkBox = new Checkbox(this.content+": "+residualSec+"s");
        this.residualSec = residualSec;
        this.isTaskLabelMode = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println(this.checkBox.getState());
            if(this.checkBox.getState()){
                if(this.isSecMode){
                    this.checkBox.setLabel(Integer.toString((int)this.residualSec)+"s");
                }else if(this.isTaskLabelMode){
                    this.checkBox.setLabel(this.content+": "+Integer.toString((int)this.residualSec)+"s");
                }
                this.residualSec--;
            }
    }

    public void updateLabel(){
            javax.swing.Timer timer = new javax.swing.Timer(Constants.ONE_SECOND, this);
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
            return;
    }

    public Checkbox getCheckBox(){
        return this.checkBox;
    }

}