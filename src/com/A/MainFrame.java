package com.A;
import com.A.Constants;
import com.A.ButtonTemplate;
import com.A.TaskCheckBox;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.TextField;
import java.awt.Dimension;
import java.awt.Checkbox;
import javax.swing.JButton;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JOptionPane;

class MainFrame extends JFrame{
    public int currWidth = Constants.WIDTH;
    public int currHeight = Constants.HEIGHT;
    public JPanel leftPanel = new JPanel();
    public JPanel rightPanel = new JPanel();
    public JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
    public TextField textField1 = new TextField("hola", 1);
    public JSpinner secSpinner = new JSpinner();
    public MainFrame(String title){
        super("Main");
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                currWidth = e.getComponent().getSize().width;
                currHeight = e.getComponent().getSize().height;
                splitPane.setDividerLocation(currWidth/2);
                textField1.setMaximumSize(new Dimension(currWidth, currHeight/10));
                secSpinner.setMaximumSize(new Dimension(currWidth/2, currHeight/10));
            }
        });
        this.secSpinner.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                if(Integer.parseInt(secSpinner.getValue().toString())<=0){
                    Object[] options = { "OK" };
                        JOptionPane.showOptionDialog(null, "Invalid setting for residual second!", "Time up",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, options, options[0]);
                    secSpinner.setValue(1);
                }
            }
        });
        this.leftPanel.setLayout(new BoxLayout(this.leftPanel, BoxLayout.Y_AXIS));
        this.rightPanel.setLayout(new BoxLayout(this.rightPanel, BoxLayout.Y_AXIS));
    }

    public MainFrame setSize(){
        try{
            this.setSize(Constants.WIDTH, Constants.HEIGHT);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return this;
        }
    };

    public MainFrame initializeRightPanel(){
        ButtonTemplate submitBtn = new ButtonTemplate(this);
        submitBtn.appendMouseEvent();
        textField1.setMaximumSize(new Dimension(currWidth, currHeight/10));
        secSpinner.setMaximumSize(new Dimension(currWidth, currHeight/20));
        secSpinner.setValue(1);
        this.rightPanel.add(new JLabel("設定鬧鐘名稱:"));
        this.rightPanel.add(this.textField1);
        this.rightPanel.add(new JLabel("設定秒數:"));
        this.rightPanel.add(secSpinner);
        this.rightPanel.add(submitBtn);
        return this;
    }

    public String getSpinnerSec(){
        try{
            this.secSpinner.commitEdit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            return this.secSpinner.getValue().toString();
        }
    }

    public void createTask(String[] params){
        //index 0 for task name,and index1 for task residual time(second).
        TaskCheckBox tcb = new TaskCheckBox(Integer.parseInt(params[1]), params[0]);
        tcb.toSetCurrentJPanel(this.getLeftPanel());
        tcb.updateLabel();
        addCheckboxToLeftPanel(tcb.getCheckBox());
        return;
    }

    public MainFrame addCheckboxToLeftPanel(Checkbox box){
        this.leftPanel.add(box);
        this.leftPanel.updateUI();
        return this;
    }

    public JPanel getLeftPanel(){
        return this.leftPanel;
    }

    public String getTextFieldValue(){
        return textField1.getText();
    }
    public void toShow(){
        GridLayout grid = new GridLayout(1,2);
        this.setLayout(grid);
        this.add(splitPane);
        this.setVisible(true);
    }
}