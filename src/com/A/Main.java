package com.A;
import com.A.Frame;
import com.A.Constants;
import com.A.Label;
import com.A.TaskCheckBox;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.Timer;

public class Main{
    public static void main(String[]args){
        Constants.LabelAnimation();
        Frame frame = new Frame(Constants.TITLE);
        Frame workFrame = frame
            .setFrame(Constants.WIDTH,Constants.HEIGHT)
            .setLeftPanel()
            .setRightPanel()
            .setLayout();
        Label Label1 = new Label(workFrame.getCurrentFrame(), 4,"TASK#1");
        workFrame.addLabelToLeftPanel(Label1.getJLabel());
        Label1.updateLabel();
        Label Label2 = new Label(workFrame.getCurrentFrame(), 4,"TASK#2");
        workFrame.addLabelToLeftPanel(Label2.getJLabel());
        Label2.updateLabel();
        Label Label3 = new Label(workFrame.getCurrentFrame(), "Testing");
        workFrame.addLabelToLeftPanel(Label2.getJLabel());
        workFrame.addLabelToRightPanel(Label3.getJLabel());
        TaskCheckBox tcb = new TaskCheckBox(workFrame.getCurrentFrame(), 4,"TASK#2");
        tcb.updateLabel();
        workFrame.addCheckboxToLeftPanel(tcb.getCheckBox());
        workFrame
            .showFrame();

    }
}