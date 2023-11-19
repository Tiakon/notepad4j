package cn.tiakon.notepad4j.entity.menubar;

import javax.swing.*;

public class SearchMenuInMenuBar {
    private final JMenu searchMenu;

    public SearchMenuInMenuBar() {
        this.searchMenu = new JMenu("搜索");
        JMenuItem findItem = new JMenuItem("查找");
        JMenuItem nextItem = new JMenuItem("查找下一个");
        JMenuItem previousItem = new JMenuItem("查找上一个");
        JMenuItem replaceItem = new JMenuItem("替换");
        JMenuItem grepItem = new JMenuItem("过滤");

        searchMenu.add(findItem);
        searchMenu.add(nextItem);
        searchMenu.add(previousItem);
        searchMenu.add(findItem);
        searchMenu.add(replaceItem);
        searchMenu.add(grepItem);
    }

    public JMenu getMenu() {
        return searchMenu;
    }
}
