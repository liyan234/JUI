package jui;


import project.Project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class findSomeProject extends JFrame{


    private JTable table;
    private JScrollPane pane;
    public List<Project> projectList;

    public findSomeProject(List<Project> projectList) {

        this.projectList = projectList;
        this.setSize(1000, 500);
        this.setTitle("显示的项目信息");
        this.setLayout(null);
        this.setVisible(true);
        init(projectList);
    }

    private void init(List<Project> projects) {
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
        table.setFont(new Font("",0,16));
        pane = new JScrollPane(table);
        pane.setSize(900, 400);
        pane.setLocation(50, 50);
        //总是出现垂直滚动条
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(pane);
    }
}
