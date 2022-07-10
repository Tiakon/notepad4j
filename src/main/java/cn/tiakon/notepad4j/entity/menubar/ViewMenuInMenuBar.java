package cn.tiakon.notepad4j.entity.menubar;

import java.awt.*;

public class ViewMenuInMenuBar {
    private final Menu viewMenu;

    public ViewMenuInMenuBar() {
        this.viewMenu = new Menu("查看");
        CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
        MenuItem fontItem = new MenuItem("字体");

        viewMenu.add(autoWrap);
        viewMenu.add(fontItem);
    }

    public Menu getMenu() {
        return viewMenu;
    }
}
