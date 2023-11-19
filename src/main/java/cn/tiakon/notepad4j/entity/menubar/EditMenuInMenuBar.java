package cn.tiakon.notepad4j.entity.menubar;

import javax.swing.*;

public class EditMenuInMenuBar {
    private final JMenu editMenu;
    public EditMenuInMenuBar(JFrame frame) {
        this.editMenu = new JMenu("编辑");
        JMenuItem undoItem = new JMenuItem("撤销");
        JMenuItem cutItem = new JMenuItem("剪切");
        JMenuItem copyItem = new JMenuItem("复制");
        JMenuItem pasteItem = new JMenuItem("粘贴");
        JMenuItem deleteItem = new JMenuItem("删除");
        JMenuItem selectAllItem = new JMenuItem("全选");

        JMenuItem changeCaseItem = new JMenuItem("转换大小写");
        JMenuItem lineOperationsItem = new JMenuItem("行操作");
        JMenuItem multiLineMergerItem = new JMenuItem("多行合并");
        JMenuItem multiLineEditItem = new JMenuItem("多行编辑");
        JMenuItem setOnlyReadItem = new JMenuItem("设为只读");

        JMenuItem insertDateItem = new JMenuItem("插入日期");

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

        JMenu formatMenuInEditMenu = new JMenu("格式");
        JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("自动换行");
        JMenuItem commentItem = new JMenuItem("注释");
        JMenuItem uncommentItem = new JMenuItem("取消注释");

        formatMenuInEditMenu.add(autoWrap);
        formatMenuInEditMenu.add(commentItem);
        formatMenuInEditMenu.add(uncommentItem);

        //将格式化菜单添加到编辑菜单中，作为二级菜单
        editMenu.add(new JMenuItem("-"));
        editMenu.add(formatMenuInEditMenu);
    }

    public JMenu getMenu() {
        return editMenu;
    }
}
