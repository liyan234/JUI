package jui;

import deal.findAProjectDeal;
import deal.findSomeProjectDeal;
import sun.plugin.dom.html.HTMLBodyElement;

import javax.swing.*;
import java.awt.*;

public class findAProject extends JFrame {


    private JLabel message;

    private JLabel name;
    public JTextField nameText;
    private JButton ok;

    private JPanel panel;

    public JLabel[] labels;
    public JLabel[] answers;

    public findAProject() {
        this.setSize(600, 300);
        this.setTitle("显示具体的项目信息");
        this.setLayout(null);

        init();
        this.setVisible(true);
    }

    private void init() {
        message = new JLabel("根据项目名称查找具体的项目");
        message.setSize(400,30);
        message.setLocation(20,0);
        message.setFont(new Font("", 0, 20));
        this.add(message);

        name = new JLabel("项目名称");
        name.setSize(100,30);
        name.setLocation(20,50);
        name.setFont(new Font("",0,20));

        nameText = new JTextField();
        nameText.setSize(100, 40);
        nameText.setLocation(110, 50);
        nameText.setFont(new Font("", 0, 20));
        ok = new JButton("查找");
        ok.setFont(new Font("", 1, 15));
        ok.setSize(100, 30);
        ok.setLocation(250, 50);

        //findAProjectDeal deal = new findAProjectDeal(this);
        //ok.addActionListener(deal);
        findSomeProjectDeal deal = new findSomeProjectDeal(this);
        ok.addActionListener(deal);
        this.add(ok);
        this.add(name);
        this.add(nameText);

    }
}
