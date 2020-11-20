package jui;

import deal.deleteProjectDeal;

import javax.swing.*;
import java.awt.*;

//删除一个项目
public class deleteProject extends JFrame {

    private JPanel panel;
    public  JLabel name;
    public JTextField text;
    public JButton ok;

    public deleteProject() {
        this.setSize(500,500);
        this.setTitle("删除项目");
        this.setLayout(null);

        init();
        this.setVisible(true);
    }

    private void init() {

        panel = new JPanel();
        panel.setSize(300,50);
        panel.setLocation(100,50);

        panel.setLayout(new GridLayout(1,2,0,10));

        name = new JLabel("项目名称");
        name.setFont(new Font("", 1,30));
        text = new JTextField();
        text.setFont(new Font("",0,20));
        panel.add(name);
        panel.add(text);
        this.add(panel);

        ok = new JButton("删除");
        ok.setSize(100,40);
        ok.setLocation(180,150);
        ok.setFont(new Font("", 1,30));

        deleteProjectDeal deleteProjectDeal = new deleteProjectDeal(this);
        ok.addActionListener(deleteProjectDeal);
        this.add(ok);

    }

}
