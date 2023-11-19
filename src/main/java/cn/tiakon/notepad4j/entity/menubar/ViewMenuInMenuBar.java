package cn.tiakon.notepad4j.entity.menubar;

import javax.swing.*;

public class ViewMenuInMenuBar {
    private final JMenu viewMenu;

    public ViewMenuInMenuBar() {
        JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("自动换行");
        JMenuItem fontItem = new JMenuItem("字体");

        viewMenu = new JMenu("查看");
        viewMenu.add(autoWrap);
        viewMenu.add(fontItem);
    }

    public JMenu getMenu() {
        return viewMenu;
    }
}
