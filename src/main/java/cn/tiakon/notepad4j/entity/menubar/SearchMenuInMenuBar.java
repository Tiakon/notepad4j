package cn.tiakon.notepad4j.entity.menubar;

import java.awt.*;

public class AnalysisMenuInMenuBar {
    private final Menu analysisMenu;

    public AnalysisMenuInMenuBar() {
        this.analysisMenu = new Menu("分析");
        MenuItem websiteItem = new MenuItem("Notepad4j 官方主页");
        MenuItem projectItem = new MenuItem("Notepad4j 项目主页");
        MenuItem updateItem = new MenuItem("升级 Notepad4j");
        MenuItem aboutItem = new MenuItem("关于 Notepad4j");

        analysisMenu.add(websiteItem);
        analysisMenu.add(projectItem);
        analysisMenu.add(updateItem);
        analysisMenu.add(aboutItem);
    }

    public Menu getAnalysisMenu() {
        return analysisMenu;
    }
}
