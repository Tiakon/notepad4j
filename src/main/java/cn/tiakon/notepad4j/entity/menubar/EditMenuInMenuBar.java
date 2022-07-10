package cn.tiakon.notepad4j.entity.menubar;

import java.awt.*;

public class EditMenuInMenuBar {

    private final Menu editMenu;

    public EditMenuInMenuBar(Frame frame, TextArea textArea) {
        this.editMenu = new Menu("编辑");
        MenuItem undoItem = new MenuItem("撤销");
        MenuItem cutItem = new MenuItem("剪切");
        MenuItem copyItem = new MenuItem("复制");
        MenuItem pasteItem = new MenuItem("粘贴");
        MenuItem deleteItem = new MenuItem("删除");
        MenuItem selectAllItem = new MenuItem("全选");

        MenuItem changeCaseItem = new MenuItem("转换大小写");
        MenuItem lineOperationsItem = new MenuItem("行操作");
        MenuItem multiLineMergerItem = new MenuItem("多行合并");
        MenuItem multiLineEditItem = new MenuItem("多行编辑");
        MenuItem setOnlyReadItem = new MenuItem("设为只读");

        MenuItem insertDateItem = new MenuItem("插入日期");

        editMenu.add(undoItem);
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(deleteItem);
        editMenu.add(selectAllItem);

        editMenu.add(changeCaseItem);
        editMenu.add(lineOperationsItem);
        editMenu.add(multiLineMergerItem);
        editMenu.add(multiLineEditItem);
        editMenu.add(setOnlyReadItem);

        editMenu.add(insertDateItem);

        Menu formatMenuInEditMenu = new Menu("格式");
        CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
        MenuItem commentItem = new MenuItem("注释");
        MenuItem uncommentItem = new MenuItem("取消注释");

        formatMenuInEditMenu.add(autoWrap);
        formatMenuInEditMenu.add(commentItem);
        formatMenuInEditMenu.add(uncommentItem);

        //将格式化菜单添加到编辑菜单中，作为二级菜单
        editMenu.add(new MenuItem("-"));
        editMenu.add(formatMenuInEditMenu);
    }

    public Menu getMenu() {
        return editMenu;
    }
}
