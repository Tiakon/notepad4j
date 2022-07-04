package cn.tiakon.notepad4j.core;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @author tiankai.me@gmail.com on 2022/7/3 18:38.
 */
public class NotepadFrame {

    public static void main(String[] args) {
        //创建窗口
        Frame frame = new Frame("notepad4j");
        //创建菜单条组件
        MenuBar menuBar = new MenuBar();
        final MenuBar fileMenuBar = new MenuBar();

        //创建文件菜单组件
        Menu fileMenu = new Menu("文件");
        //创建编辑菜单组件
        Menu editMenu = new Menu("编辑");
        //创建新建菜单项
        MenuItem newItem = new MenuItem("新建");
        //创建打开菜单项
        MenuItem openItem = new MenuItem("打开");
        //创建保存菜单项
        MenuItem saveItem = new MenuItem("保存");
        FileDialog fd1 = new FileDialog(frame, "选择需要加载的文件", FileDialog.LOAD);
        FileDialog fd2 = new FileDialog(frame, "选择需要保存的文件", FileDialog.SAVE);
        //创建退出菜单项
        MenuItem exitItem = new MenuItem("退出");
        //创建自动换行选择框菜单项
        CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
        //创建复制菜单项
        MenuItem copyItem = new MenuItem("复制");
        //创建粘贴菜单项
        MenuItem pasteItem = new MenuItem("粘贴");
        //创建格式菜单
        Menu formatMenu = new Menu("格式");
        //创建注释菜单项
        MenuItem commentItem = new MenuItem("注释");
        //创建取消注释菜单项
        MenuItem cancelItem = new MenuItem("取消注释");
        //创建一个文本域
        TextArea ta = new TextArea(50, 100);
        //定义菜单事件监听器
        ActionListener listener = e -> {
            String command = e.getActionCommand();
            ta.append("单击“" + command + "”菜单\n");
            if (command.equals("退出")) {
                System.exit(0);
            }
        };
        //为注释菜单项和退出菜单项注册监听器
        openItem.addActionListener(e -> {
            fd1.setVisible(true);
            // final int selectionStart = ta.getSelectionStart();
            // final int selectionEnd = ta.getSelectionEnd();
            // System.out.printf("selectionStart:%d, selectionEnd:%d", selectionStart, selectionEnd);
            ta.replaceRange("", 0, ta.getText().length());
            final String fileDir = fd1.getDirectory();
            final String fileName = fd1.getFile();
            //打印用户选择的文件路径和名称
            System.out.println("用户选择的文件路径:" + fileDir);
            System.out.println("用户选择的文件名称:" + fileName);
            if (fileDir != null && fileName != null) {
                final File file = new File(fileDir.concat(fileName));
                try (final FileReader fileReader = new FileReader(file);
                     final BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        ta.append(line);
                        ta.append("\n");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        saveItem.addActionListener(e -> {
            fd2.setVisible(true);
            final String fileDir = fd2.getDirectory();
            final String fileName = fd2.getFile();
            //打印用户选择的文件路径和名称
            System.out.println("用户选择的文件路径:" + fd2.getDirectory());
            System.out.println("用户选择的文件名称:" + fd2.getFile());
            if (fileDir != null && fileName != null) {
                final File file = new File(fileDir.concat(fileName));
                try (final FileWriter fileWriter = new FileWriter(file, false);
                     final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    final String text = ta.getText();
                    System.out.println(text);
                    bufferedWriter.write(text);
                    bufferedWriter.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        commentItem.addActionListener(listener);
        exitItem.addActionListener(listener);
        //为文件菜单fileMenu添加菜单项
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        //为编辑菜单editMenu添加菜单项
        editMenu.add(autoWrap);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        //为格式化菜单formatMenu添加菜单项
        formatMenu.add(commentItem);
        formatMenu.add(cancelItem);
        //将格式化菜单添加到编辑菜单中，作为二级菜单
        editMenu.add(new MenuItem("-"));
        editMenu.add(formatMenu);
        //将文件菜单和编辑菜单添加到菜单条中
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        //把菜单条设置到frame窗口上
        frame.setMenuBar(menuBar);
        frame.setBackground(new Color(3, 0, 0));
        //把文本域添加到frame中
        frame.add(ta);
        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }

}
