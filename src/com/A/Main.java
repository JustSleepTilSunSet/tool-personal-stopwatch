package com.A;
import com.A.Frame;
import com.A.Constants;
import java.util.*;

public class Main{
    public static void main(String[]args){
        Frame frame = new Frame(Constants.TITLE);
        frame
            .setFrame(Constants.WIDTH,Constants.HEIGHT)
            .setLayout()
            .getFrame();
    }
}