package jui;


import deal.updateProjectDeal;

import javax.swing.*;
import java.awt.*;

//修改项目信息
public class updateProject extends JFrame {
    private JLabel message;

    //编号
    private JLabel num;
    public JTextField numText;

    public JPanel panel;
    public JLabel[] labels;
    public JTextField[] textFields;

    private JButton ok;

    public updateProject() {
        this.setSize(500,700);
        this.setTitle("修改项目信息");
        this.setLayout(null);

        init();
        this.setVisible(true);
    }

    private void init() {
        message = new JLabel();
        message.setSize(400,30);
        message.setLocation(5,0);
        message.setText("编号不可更改");
        message.setFont(new Font("",0,20));
        this.add(message);

        num = new JLabel("项目编号");
        num.setSize(100,30);
        num.setLocation(85,50);
        num.setFont(new Font("",1,20));

        numText = new JTextField();
        numText.setSize(60,30);
        numText.setLocation(180,50);
        numText.setFont(new Font("",0,20));
        this.add(num);
        this.add(numText);

        panel = new JPanel();
        panel.setSize(350,400);
        panel.setLocation(85,140);

        panel.setLayout(new GridLayout(5,2,10,10));

        String[] labelNames = new String[]{"项目名称", "项目负责人", "项目位置", "项目预算<元>"};
        labels = new JLabel[4];
        textFields = new JTextField[4];

        for (int i = 0; i < labelNames.length; i++) {
            labels[i] = new JLabel(labelNames[i]);
            labels[i].setFont(new Font("",1,20));
            panel.add(labels[i]);

            textFields[i] = new JTextField();
            textFields[i].setFont(new Font("",0,20));
            panel.add(textFields[i]);
        }
        this.add(panel);

        ok = new JButton("确认");
        ok.setSize(100,60);
        ok.setLocation(180,500);
        ok.setFont(new Font("",1, 20));
        updateProjectDeal deal = new updateProjectDeal(this);
        ok.addActionListener(deal);
        this.add(ok);
    }
}
