package cn.tiakon.notepad4j.entity.menubar;

import java.awt.*;

public class SearchMenuInMenuBar {
    private final Menu searchMenu;

    public SearchMenuInMenuBar() {
        this.searchMenu = new Menu("搜索");
        MenuItem findItem = new MenuItem("查找");
        MenuItem nextItem = new MenuItem("查找下一个");
        MenuItem previousItem = new MenuItem("查找上一个");
        MenuItem replaceItem = new MenuItem("替换");
        MenuItem grepItem = new MenuItem("过滤");

        searchMenu.add(findItem);
        searchMenu.add(nextItem);
        searchMenu.add(previousItem);
        searchMenu.add(findItem);
        searchMenu.add(replaceItem);
        searchMenu.add(grepItem);
    }

    public Menu getMenu() {
        return searchMenu;
    }
}
