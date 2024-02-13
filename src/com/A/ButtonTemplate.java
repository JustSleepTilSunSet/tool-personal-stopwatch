package com.A;
import com.A.MainFrame;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.TextField;

class ButtonTemplate extends JButton{
    public MainFrame mf = null;
    public class buttonActions implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("isClick");
            }
    }
    public class mouseActions extends MouseAdapter{
            @Override
            public void mouseClicked(MouseEvent e) {
                String taskName = mf.getTextFieldValue();
                String taskSecond = mf.getSpinnerSec();
                String[] taskDetail = {taskName,taskSecond};
                mf.createTask(taskDetail);
            }
    }

    public ButtonTemplate(MainFrame mf){
        super("Submit");
        this.mf = mf;
    }

    public void appendActionEvent(){
        this.addActionListener(new buttonActions());
        return;
    }

    public void appendMouseEvent(){
        this.addMouseListener(new mouseActions());
        return;
    }

    public JButton getButton(){
        return this;
    }
}
