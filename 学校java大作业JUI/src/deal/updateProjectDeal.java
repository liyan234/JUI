package deal;

import dao.projectDao;
import exception.projectException;
import jui.updateProject;
import project.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;

public class updateProjectDeal implements ActionListener {

    updateProject event;

    public updateProjectDeal(updateProject event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Project project = null;

        if ((project = checkItExist()) != null) {
            String newName = event.textFields[0].getText();
            String newMan = event.textFields[1].getText();
            String newLocation = event.textFields[2].getText();
            String newBudget = event.textFields[3].getText();

            if (judgeIsNull(newName) && judgeIsNull(newMan)
            && judgeIsNull(newLocation) && judgeIsNull(newBudget)) {
                JOptionPane.showMessageDialog(event, "都为空，不知道你想修改啥");
                return;
            }

            if (confirm()) {
                return;
            }

            String name = project.getProject_name();
            projectDao dao = new projectDao();

            try {
                if (!judgeIsNull(newName)) {
                    dao.updateProjectNewNameByName(name, newName);
                }
                if (!judgeIsNull(newMan)) {
                    dao.updateProjectManByName(name, newMan);
                }
                if (!judgeIsNull(newBudget)) {
                    dao.updateProjectBudgetByName(name, newBudget);
                }
                if (!judgeIsNull(newLocation)) {
                    dao.updateProjectLocationByName(name, newLocation);
                }

            } catch (projectException ex) {
                JOptionPane.showMessageDialog(event, "修改失败");
                return;
            }
            JOptionPane.showMessageDialog(event, "修改成功");
            event.numText.setText("");
            event.textFields[0].setText("");
            event.textFields[1].setText("");
            event.textFields[2].setText("");
            event.textFields[3].setText("");
        }

    }

    private boolean confirm() {
        int ret = JOptionPane.showConfirmDialog(event, "确认修改?","警告", YES_NO_CANCEL_OPTION);
        return ret != JOptionPane.YES_OPTION;
    }

    //为空返回true 不为空返回false
    private boolean judgeIsNull(String str) {
        boolean judge = false;
        if (str == null || str.trim().equals("")) {
            judge = true;
        }
        return judge;
    }

    private Project checkItExist() {
        String num = event.numText.getText();

        if (num == null || num.equals("")) {
            JOptionPane.showMessageDialog(event, "请填写编号");
            return null;
        }

        projectDao dao = new projectDao();
        Project project = null;

        try {
            project = dao.selectByNum(Integer.parseInt(num.trim()));
            if (project == null) {
                JOptionPane.showMessageDialog(event, "编号应该不存在");
                return null;
            }
        } catch (projectException e) {
            JOptionPane.showMessageDialog(event, "数据错误");
            return null;
        }
        return project;
    }
}
