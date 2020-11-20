package jui;

import deal.allProjectDeal;

import javax.swing.*;
import java.awt.*;

public class allProject extends JFrame {

    //标签
    private JLabel label;
    //实现6个功能按钮
    private JButton[] jButtons;
    //放按钮的面板
    public JPanel panel;
    //容器
    public Container container;

    public allProject() {
        this.setSize(800, 600);
        this.setTitle("项目信息管理");
        this.setLayout(null);
        //初始化其他控件
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //点击一个关闭所有并退出程序
        this.setVisible(true);
    }

    //添加控件
    private void init() {
        System.out.println(111);
        //添加标签
        label = new JLabel();
        label.setText("项目信息管理主界面");
        label.setFont(new Font("", 1, 30));
        label.setSize(600, 100);
        label.setLocation(250, 80);
        //this.add(label);
        //添加按钮
        panel = new JPanel();
        panel.setSize(400, 220);
        panel.setLocation(200, 230);
        panel.setLayout(new GridLayout(3, 2, 20, 40));
        jButtons = new JButton[5];
        String[] names = new String[] {"显示所有项目", "查找具体项目", "增加项目信息",
                "修改项目信息", "删除具体项目",};
        //添加按钮 注册事件
        allProjectDeal deal = new allProjectDeal(this);

        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton(names[i]);
            jButtons[i].setFont(new Font("", Font.PLAIN, 20));
            //注册监听器
            jButtons[i].addActionListener(deal);
            panel.add(jButtons[i]);
        }
        //this.add(panel);
        container = this.getContentPane();
        container.add(label);
        container.add(panel);

    }
}
