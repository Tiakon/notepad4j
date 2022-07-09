package cn.tiakon.notepad4j.entity.menubar;

import java.awt.*;

public class EditMenuInMenuBar {

    private final Menu editMenu;

    public EditMenuInMenuBar(Frame frame, TextArea textArea) {
        this.editMenu = new Menu("编辑");
        CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
        MenuItem copyItem = new MenuItem("复制");
        MenuItem pasteItem = new MenuItem("粘贴");
        editMenu.add(autoWrap);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        Menu formatMenu = new Menu("格式");
        MenuItem commentItem = new MenuItem("注释");
        MenuItem cancelItem = new MenuItem("取消注释");
        formatMenu.add(commentItem);
        formatMenu.add(cancelItem);
        //将格式化菜单添加到编辑菜单中，作为二级菜单
        editMenu.add(new MenuItem("-"));
        editMenu.add(formatMenu);
    }

    public Menu getEditMenu() {
        return editMenu;
    }
}
