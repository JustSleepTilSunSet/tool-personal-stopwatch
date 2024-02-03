package com.A;
import com.A.Frame;
import com.A.Constants;
import java.util.*;
import java.lang.Thread;

public class Main{
    public static void main(String[]args){
        Constants.TestLabelAnimation();
        Frame frame = new Frame(Constants.TITLE);
        frame
            .setFrame(Constants.WIDTH,Constants.HEIGHT)
            .setLeftPanel()
            .setRightPanel()
            .setLayout()
            .getFrame()
            .updateLabel();
    }
}