package cn.tiakon.notepad4j.entity.menubar;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;

public class FileMenuInMenuBar {

    private final Menu fileMenu;
    private final MenuItem newItem;
    private final MenuItem openItem;
    private final MenuItem saveItem;
    private final MenuItem exitItem;

    public FileMenuInMenuBar(Frame frame, TextArea textArea) {
        FileDialog fd1 = new FileDialog(frame, "选择需要加载的文件", FileDialog.LOAD);
        FileDialog fd2 = new FileDialog(frame, "选择需要保存的文件", FileDialog.SAVE);

        this.fileMenu = new Menu("文件");

        this.newItem = new MenuItem("新建");

        this.openItem = new MenuItem("打开");
        openItem.addActionListener(e -> {
            fd1.setVisible(true);
            // final int selectionStart = textArea.getSelectionStart();
            // final int selectionEnd = textArea.getSelectionEnd();
            // System.out.printf("selectionStart:%d, selectionEnd:%d", selectionStart, selectionEnd);
            textArea.replaceRange("", 0, textArea.getText().length());
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
                        textArea.append(line);
                        textArea.append("\n");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.saveItem = new MenuItem("保存");
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
                    final String text = textArea.getText();
                    System.out.println(text);
                    bufferedWriter.write(text);
                    bufferedWriter.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.exitItem = new MenuItem("退出");
        ActionListener listener = e -> {
            String command = e.getActionCommand();
            if ("退出".equals(command)) {
                System.exit(0);
            }
        };
        exitItem.addActionListener(listener);

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
    }

    public Menu getFileMenu() {
        return fileMenu;
    }
}
