package com.A;
import com.A.Frame;
import com.A.Constants;
import com.A.Label;
import com.A.TaskCheckBox;
import com.A.ButtonTemplate;
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
        TaskCheckBox tcb2 = new TaskCheckBox(3,"hola");
        tcb2.toSetCurrentJPanel(workFrame.getLeftPanel());
        tcb2.updateLabel();
        workFrame.addCheckboxToLeftPanel(tcb2.getCheckBox());
        TaskCheckBox tcb1 = new TaskCheckBox(3,"hola");
        tcb1.toSetCurrentJPanel(workFrame.getLeftPanel());
        tcb1.updateLabel();
        workFrame.addCheckboxToLeftPanel(tcb1.getCheckBox());
        TaskCheckBox tcb3 = new TaskCheckBox(3,"hola");
        tcb3.toSetCurrentJPanel(workFrame.getLeftPanel());
        tcb3.updateLabel();
        workFrame.addCheckboxToLeftPanel(tcb3.getCheckBox());
        ButtonTemplate submitBtn = new ButtonTemplate();
        workFrame.addButtonToRightPanel(submitBtn);
        workFrame
            .showFrame();

    }
}