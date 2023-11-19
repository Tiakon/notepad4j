package cn.tiakon.notepad4j.entity.menubar;

import cn.tiakon.notepad4j.util.ImagePathUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class FileMenuInMenuBar {
    private final JMenu fileMenu;
    private final FileDialog fd1;
    private final FileDialog fd2;
    private   JTextArea textArea;

    final int FRAME_DISTANCE = 20;
    private final int DESKTOP_WIDTH = 480;
    private final int DESKTOP_HEIGHT = 360;
    //定义内部窗口为的大小
    private int width = 230;
    private int height = DESKTOP_HEIGHT;

    //定义下一个内部窗口的横轴坐标
    private int nextFrameX = 0;

    public FileMenuInMenuBar(JFrame frame,JDesktopPane desktop , JTextArea textArea) {
        this.textArea = textArea;
        this.fd1 = new FileDialog(frame, "选择需要加载的文件", FileDialog.LOAD);
        this.fd2 = new FileDialog(frame, "选择需要保存的文件", FileDialog.SAVE);
        this.fileMenu = new JMenu("文件");

        // JMenuItem newItem = new JMenuItem("新建");

        //定义Action，用于快捷创建菜单项和工具按钮
        Action newAction = new AbstractAction("新建", new ImageIcon(ImagePathUtil.getImageFromSystemResource("component/new.png"))) {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建内部窗口
                JInternalFrame iframe = new JInternalFrame("新文档", true, true, true, true);
                //往内部窗口中添加一个8行40列的文本框
                iframe.add(new JScrollPane(new JTextArea(8, 40)));
                //将内部窗口添加到虚拟桌面中
                desktop.add(iframe);
                //设置内部窗口的原始位置
                iframe.reshape(nextFrameX, 0, width, height);
                //使该窗口可见
                iframe.show();
                //计算下一个内部窗口的位置
                nextFrameX += FRAME_DISTANCE;
                if (nextFrameX > DESKTOP_WIDTH - width) nextFrameX = 0;
            }
        };

        JMenuItem openItem = new JMenuItem("打开");
        openItem.addActionListener(getActionListenerForOpenItem());

        JMenuItem saveItem = new JMenuItem("保存");
        saveItem.addActionListener(getActionListenerForSaveItem());
        JMenuItem saveAsItem = new JMenuItem("另存为");

        Action exitAction = new AbstractAction("退出", new ImageIcon(ImagePathUtil.getImageFromSystemResource("component/exit.png"))) {
            @Override
            public void actionPerformed(ActionEvent e) {
                //结束当前程序
                System.exit(0);
            }
        };

        // JMenuItem exitItem = new JMenuItem("退出");
        // exitItem.addActionListener(getActionListenerForExitItem());

        fileMenu.add(newAction);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(exitAction);
    }


    public FileMenuInMenuBar(JFrame frame,JDesktopPane desktop ) {

        this.fd1 = new FileDialog(frame, "选择需要加载的文件", FileDialog.LOAD);
        this.fd2 = new FileDialog(frame, "选择需要保存的文件", FileDialog.SAVE);

        this.fileMenu = new JMenu("文件");

        // JMenuItem newItem = new JMenuItem("新建");

        //定义Action，用于快捷创建菜单项和工具按钮
        Action newAction = new AbstractAction("新建", new ImageIcon(ImagePathUtil.getImageFromSystemResource("component/new.png"))) {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建内部窗口
                JInternalFrame iframe = new JInternalFrame("新文档", true, true, true, true);
                //往内部窗口中添加一个8行40列的文本框
                iframe.add(new JScrollPane(new JTextArea(8, 40)));
                //将内部窗口添加到虚拟桌面中
                desktop.add(iframe);
                //设置内部窗口的原始位置
                iframe.reshape(nextFrameX, 0, width, height);
                //使该窗口可见
                iframe.show();
                //计算下一个内部窗口的位置
                nextFrameX += FRAME_DISTANCE;
                if (nextFrameX > DESKTOP_WIDTH - width) nextFrameX = 0;
            }
        };

        JMenuItem openItem = new JMenuItem("打开");
        openItem.addActionListener(getActionListenerForOpenItem());

        JMenuItem saveItem = new JMenuItem("保存");
        saveItem.addActionListener(getActionListenerForSaveItem());
        JMenuItem saveAsItem = new JMenuItem("另存为");

        Action exitAction = new AbstractAction("退出", new ImageIcon(ImagePathUtil.getImageFromSystemResource("component/exit.png"))) {
            @Override
            public void actionPerformed(ActionEvent e) {
                //结束当前程序
                System.exit(0);
            }
        };

        // JMenuItem exitItem = new JMenuItem("退出");
        // exitItem.addActionListener(getActionListenerForExitItem());

        fileMenu.add(newAction);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(exitAction);
    }

    private ActionListener getActionListenerForOpenItem() {
        return e -> {
            fd1.setVisible(true);
            // final int selectionStart = textArea.getSelectionStart();
            // final int selectionEnd = textArea.getSelectionEnd();
            // System.out.printf("selectionStart:%d, selectionEnd:%d", selectionStart, selectionEnd);
            textArea.replaceRange("", 0, textArea.getText().length());
            final String fileDir = fd1.getDirectory();
            final String fileName = fd1.getFile();
            System.out.println("用户选择的文件路径:" + fileDir);
            System.out.println("用户选择的文件名称:" + fileName);
            if (fileDir != null && fileName != null) {
                final File file = new File(fileDir.concat(fileName));
                try (final FileReader fileReader = new FileReader(file);
                     final BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        textArea.append(line);
                        textArea.append("\n");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

    private ActionListener getActionListenerForSaveItem() {
        return e -> {
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
                    final String text = textArea.getText();
                    System.out.println(text);
                    bufferedWriter.write(text);
                    bufferedWriter.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

    private ActionListener getActionListenerForExitItem() {
        return e -> {
            String command = e.getActionCommand();
            if ("退出".equals(command)) System.exit(0);
        };
    }

    public JMenu getMenu() {
        return fileMenu;
    }
}
