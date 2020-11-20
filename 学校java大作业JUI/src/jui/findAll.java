package jui;

import com.sun.javafx.webkit.theme.PopupMenuImpl;
import dao.projectDao;
import deal.FindAllDeal;
import exception.projectException;
import project.Project;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class findAll extends JFrame {

    public JTable table;
    private JScrollPane pane;
    private JButton updateButton;

    private JButton deleteButton;

    public JPopupMenu menu;
    public JMenuItem[] items = new JMenuItem[2];


    public findAll() {
        this.setSize(1000, 500);
        this.setTitle("显示所有项目信息");
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null); //点击一个关闭所有并退出程序

        /*this.setLocation(300,400);
        this.setSize(1200,500);
        updateButton = new JButton("删除");
        updateButton.setFont(new Font("", Font.PLAIN, 20));
        this.add(updateButton);*/



        this.setVisible(true);
        //获取所有信息
        projectDao dao = new projectDao();
        try {
            List<Project> projects = dao.SelectAll();
            init(projects);
        } catch (projectException e) {
            JOptionPane.showMessageDialog(this, "获取信息异常!");
        }
    }

    private void init(List<Project> projects) {

        FindAllDeal deal = new FindAllDeal(this);
        //设置表格标题 和表格信息
        String[] titles = new String[]{"项目编号","项目名称", "项目负责人", "项目位置", "项目预算<元>"};
        String[][] values = new String[projects.size()][5];
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            values[i][0] = String.valueOf(project.getProject_num());
            values[i][1] = project.getProject_name();
            values[i][2] = project.getProject_man();
            values[i][3] = project.getProject_location();
            values[i][4] = project.getProject_budget() + "元";
        }
        //初始化表格和滚动面板
        table = new JTable(values, titles);
        table.addMouseListener(deal);
        table.setFont(new Font("",0,16));
        pane = new JScrollPane(table);
        pane.setSize(900, 400);
        pane.setLocation(50, 50);
        //总是出现垂直滚动条
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(pane);


        //注册监听器

        menu = new JPopupMenu();
        items[0] = new JMenuItem("删除");
        items[1] = new JMenuItem("修改");
        items[0].addActionListener(deal);
        items[1].addActionListener(deal);
        menu.add(items[0]);
        menu.add(items[1]);
        menu.addMouseListener(deal);
        this.addMouseListener(deal);


    }

}
