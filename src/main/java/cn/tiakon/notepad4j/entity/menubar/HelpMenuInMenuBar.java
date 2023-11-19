package cn.tiakon.notepad4j.entity.menubar;

import javax.swing.*;

public class HelpMenuInMenuBar {

    private final JMenu helpMenu;

    public HelpMenuInMenuBar() {
        JMenuItem websiteItem = new JMenuItem("Notepad4j 官方主页");
        JMenuItem projectItem = new JMenuItem("Notepad4j 项目主页");
        JMenuItem updateItem = new JMenuItem("升级 Notepad4j");
        JMenuItem aboutItem = new JMenuItem("关于 Notepad4j");

        helpMenu = new JMenu("帮助");
        helpMenu.add(websiteItem);
        helpMenu.add(projectItem);
        helpMenu.add(updateItem);
        helpMenu.add(aboutItem);
    }

    public JMenu getMenu() {
        return helpMenu;
    }
}
