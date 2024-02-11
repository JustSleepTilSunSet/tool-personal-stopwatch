package com.A;
import com.A.Constants;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.Timer;
import javax.swing.JOptionPane;

public class TaskCheckBox implements ActionListener{
    Checkbox checkBox = null;
    JPanel currJPanel;
    int residualSec = 0;
    int assginTaskTag = 1;
    String content = "";
    Boolean isTaskLabelMode = false; // ResidualSec with task.
    Boolean isTaskMode = false; // The mode is a name of task.
    Boolean isSecMode = false; // ResidualSec.
    public TaskCheckBox(int residualSec){
        this.checkBox = new Checkbox(residualSec+"");
        this.residualSec = residualSec;
        this.assginTaskTag = Constants.TASK_TAG;
        Constants.TASK_TAG++;
        this.isSecMode = true;
    }

    public TaskCheckBox(String content){
        this.content = content;
        this.checkBox = new Checkbox(this.content);
        this.assginTaskTag = Constants.TASK_TAG;
        Constants.TASK_TAG++;
        this.isTaskMode = true;
    }

    public TaskCheckBox(int residualSec, String content){
        this.content = content;
        this.checkBox = new Checkbox("TASK#"+Constants.TASK_TAG+": "+this.content+residualSec+"s");
        this.assginTaskTag = Constants.TASK_TAG;
        Constants.TASK_TAG++;
        this.residualSec = residualSec;
        this.isTaskLabelMode = true;
    }

    public void showMessageWin(){
         Object[] options = { "OK" };
        JOptionPane.showOptionDialog(null, this.content + " <= The clock time up.", "Time up",
             JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
             null, options, options[0]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(this.checkBox.getState()){
                if(this.residualSec>=0){
                    if(this.isSecMode){
                        this.checkBox.setLabel(Integer.toString((int)this.residualSec)+"s");
                    }else if(this.isTaskLabelMode){
                        this.checkBox.setLabel(this.content+": "+Integer.toString((int)this.residualSec)+"s");
                    }
                }
                if(this.residualSec==0){
                    this.checkBox.setLabel("#"+this.assginTaskTag+": "+this.content+" done.");
                    this.currJPanel.remove(this.checkBox);
                    this.currJPanel.updateUI();
                    showMessageWin();
                }
                this.residualSec--;
            }
            else {
                this.checkBox.setLabel("[pending]#"+this.assginTaskTag+":"+this.content+": "+Integer.toString((int)this.residualSec)+"s");
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

    public void toSetCurrentJPanel(JPanel currJPanel){
        this.currJPanel = currJPanel;
        return;
    }
}