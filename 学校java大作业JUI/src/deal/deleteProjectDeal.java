package deal;

import dao.projectDao;
import exception.projectException;
import jui.deleteProject;
import project.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;

public class deleteProjectDeal implements ActionListener {

    private deleteProject event;

    public deleteProjectDeal (deleteProject event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = event.text.getText();

        if (name == null || name.trim().equals("")) {
            JOptionPane.showMessageDialog(event, "请填写完整的信息");
            return;
        }

        projectDao dao = new projectDao();
        try {
            Project project = dao.selectByName(name.trim());
            if (project == null) {
                JOptionPane.showMessageDialog(event, "这个项目是否存在");
                return;
            }
        } catch (projectException ex) {
            JOptionPane.showMessageDialog(event, "数据库出错");
            return;
        }

        if (confirm()) {
            return;
        }

        try {
            dao.deleteProjectByName(name.trim());
        } catch (projectException ex) {
            JOptionPane.showMessageDialog(event, "删除失败");
            return;
        }
        event.text.setText("");
        JOptionPane.showMessageDialog(event, "删除成功");
    }

    private boolean confirm() {
        int ret = JOptionPane.showConfirmDialog(event, "确认删除?","警告", YES_NO_CANCEL_OPTION);
        return ret != JOptionPane.YES_OPTION;
    }
}
