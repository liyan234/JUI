package deal;

import jui.deleteProject;
import jui.findAll;
import jui.updateProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FindAllDeal implements ActionListener, MouseListener {

    private findAll even;

    public FindAllDeal(findAll even) {
        this.even = even;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        if ("删除".equals(item.getText())) {
            //获取table中的信息
            int row = even.table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(even, "未选择");
                return;
            }
            Object o = even.table.getValueAt(row, 1);
            deleteProject deleteProject = new deleteProject();
            deleteProject.text.setText(o.toString());
        } else {
            //获取table中的信息
            int row = even.table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(even, "未选择");
                return;
            }
            Object o = even.table.getValueAt(row, 0);
            updateProject updateProject = new updateProject();
            updateProject.numText.setText(o.toString());

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            even.menu.show(even, e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
