package deal;

import dao.projectDao;
import exception.projectException;
import jui.addProject;
import project.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addProjectDeal implements ActionListener {

    private addProject event;

    public addProjectDeal (addProject event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //项目名称
        String name = event.textFields[0].getText();
        //项目负责人
        String man = event.textFields[1].getText();
        //项目位置
        String location = event.textFields[2].getText();
        //项目预算
        String budget = event.textFields[3].getText();

        if (check(name) && check(man) && check(location) && check(budget)) {

            Project project = new Project();
            project.setProject_name(name);
            project.setProject_location(location);
            project.setProject_budget(budget);
            project.setProject_man(man);

            projectDao dao = new projectDao();

            try {
                dao.addProject(project);
            } catch (projectException ex) {
                JOptionPane.showMessageDialog(event, "添加失败");
                for (int i = 0; i < 4; i++) {
                    event.textFields[i].setText("");
                }
                return;
            }

            for (int i = 0; i < 4; i++) {
                event.textFields[i].setText("");
            }
            JOptionPane.showMessageDialog(event, "添加成功");
        } else {
            JOptionPane.showMessageDialog(event, "请填写完整的信息");
        }
    }
    private boolean check(String str) {
        return str != null && !str.trim().equals("") ;
    }
}
