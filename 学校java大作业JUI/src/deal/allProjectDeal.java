package deal;

import jui.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class allProjectDeal implements ActionListener {
    private allProject event;

    public allProjectDeal(allProject event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String text = button.getText();

        switch (text.trim()) {
            case "显示所有项目" :
                new findAll();
                break;
            case "查找具体项目":
                new findAProject();
                break;
            case "增加项目信息":
                new addProject();
                break;
            case "修改项目信息":
                new updateProject();
                break;
            case "删除具体项目":
                new deleteProject();
                break;
        }
    }
}
