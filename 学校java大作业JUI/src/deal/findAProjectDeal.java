package deal;

import dao.projectDao;
import exception.projectException;
import jui.findAProject;
import project.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class findAProjectDeal implements ActionListener {

    findAProject event;

    public findAProjectDeal (findAProject event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = event.nameText.getText();

        if (name == null || name.trim().equals("")) {
            JOptionPane.showMessageDialog(event, "请填写完整的信息");
            return;
        }

        projectDao dao = new projectDao();
        Project project = null;

        try {
            project = dao.selectByName(name);
            if (project == null) {
                JOptionPane.showMessageDialog(event, "数据库中没有这个项目");
                return;
            }
        } catch (projectException ex) {
            JOptionPane.showMessageDialog(event, "未检查到这条河");
            return;
        }

        event.answers[0].setText(project.getProject_name());
        event.answers[1].setText(project.getProject_man());
        event.answers[2].setText(project.getProject_location());
        event.answers[3].setText(project.getProject_budget());

    }
}
