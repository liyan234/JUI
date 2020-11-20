package jui;

import deal.addProjectDeal;

import javax.swing.*;
import java.awt.*;

public class addProject extends JFrame {

    public JPanel panel;
    public JLabel[] labels;
    public JTextField[] textFields;

    private JButton ok;

    public addProject() {
        this.setSize(500, 600);
        this.setTitle("新增项目");
        this.setLayout(null);

        init();
        this.setVisible(true);
    }

    private void init() {

        panel = new JPanel();
        panel.setSize(350,350);
        panel.setLocation(85,60);
        panel.setLayout(new GridLayout(4,2,10,10));

        String[] labelNames = new String[]{"项目名称", "项目负责人", "项目位置", "项目预算<元>"};

        labels = new JLabel[4];
        textFields = new JTextField[4];

        for (int i = 0; i < labelNames.length; i++) {
            labels[i] = new JLabel(labelNames[i]);
            labels[i].setFont(new Font("", 1,20));
            panel.add(labels[i]);

            textFields[i] = new JTextField();
            textFields[i].setFont(new Font("",0,20));
            panel.add(textFields[i]);
        }

        this.add(panel);

        ok = new JButton("提交");
        ok.setSize(100,50);
        ok.setLocation(180,450);

        addProjectDeal deal = new addProjectDeal(this);
        ok.addActionListener(deal);

        this.add(ok);
    }


}
