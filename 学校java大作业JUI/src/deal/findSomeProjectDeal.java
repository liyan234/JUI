package deal;

import dao.projectDao;
import exception.projectException;
import jui.*;
import project.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class findSomeProjectDeal extends JFrame implements ActionListener {

    findAProject event;
    public findSomeProjectDeal(findAProject event) {
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
        List<Project> projectList = null;

        try {
            projectList = dao.findSomeProject(name);
            new findSomeProject(projectList);
        } catch (projectException ex) {
            JOptionPane.showMessageDialog(event, "查询失败");
            return;
        }
    }

}
