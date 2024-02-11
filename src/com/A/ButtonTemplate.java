package com.A;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class ButtonTemplate extends JButton{
    public ButtonTemplate(){
        super("Submit");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hola world");
            }
        });
    }

    public JButton getButton(){
        return this;
    }
}
