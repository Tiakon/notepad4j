package cn.tiakon.notepad4j.entity.menubar;

import java.awt.*;

public class HelpMenuInMenuBar {

    private final Menu helpMenu;

    public HelpMenuInMenuBar() {
        this.helpMenu = new Menu("帮助");
        MenuItem websiteItem = new MenuItem("Notepad4j 官方主页");
        MenuItem projectItem = new MenuItem("Notepad4j 项目主页");
        MenuItem updateItem = new MenuItem("升级 Notepad4j");
        MenuItem aboutItem = new MenuItem("关于 Notepad4j");

        helpMenu.add(websiteItem);
        helpMenu.add(projectItem);
        helpMenu.add(updateItem);
        helpMenu.add(aboutItem);
    }

    public Menu getMenu() {
        return helpMenu;
    }
}
