package cn.tiakon.notepad4j.core;

import cn.tiakon.notepad4j.entity.ColorSets;
import cn.tiakon.notepad4j.entity.menubar.EditMenuInMenuBar;
import cn.tiakon.notepad4j.entity.menubar.FileMenuInMenuBar;
import cn.tiakon.notepad4j.entity.FontSets;

import java.awt.*;
import java.util.Objects;

/**
 * -Dfile.encoding=gbk
 *
 * @author tiankai.me@gmail.com on 2022/7/3 18:38.
 */
public class NotepadFrame {

    public static void main(String[] args) {
        Frame frame = new Frame("Notepad4j");
        TextArea textArea = getTextArea();
        final MenuBar menuBar = getMenuBar(frame, textArea);
        frame.setMenuBar(menuBar);
        frame.setBackground(ColorSets.FRAME_BG);
        CardLayout cardLayout = new CardLayout();
        final Panel panel = new Panel();
        panel.setBounds(50, 50, 300, 300);
        // panel.setLayout(cardLayout);
        final Button button = new Button("新建文件");
        button.setSize(new Dimension(50, 50));
        panel.add(button);
        panel.add(textArea);
        // panel.setPreferredSize(new Dimension(200, 200));
        frame.add(panel);
        //把文本域添加到frame中
        // frame.add(textArea);
        //设置frame最佳大小并可见
        // frame.pack();
        frame.setBounds(20, 20, 500, 500);
        frame.setIconImage(getImageFromResource("/logo.png"));
        frame.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        frame.setVisible(true);
    }

    public static MenuBar getMenuBar(Frame frame, TextArea textArea) {
        MenuBar menuBar = new MenuBar();
        final FileMenuInMenuBar fileMenuInMenuBar = new FileMenuInMenuBar(frame, textArea);
        final EditMenuInMenuBar editMenuInMenuBar = new EditMenuInMenuBar(frame, textArea);
        menuBar.add(fileMenuInMenuBar.getFileMenu());
        menuBar.add(editMenuInMenuBar.getEditMenu());
        return menuBar;
    }

    public static TextArea getTextArea() {
        TextArea textArea = new TextArea(5, 10);
        textArea.setBounds(30, 30, 50, 50);
        textArea.setLocation(50, 50);
        textArea.setBackground(ColorSets.PANEL_TEXTAREA_BG);
        textArea.setForeground(ColorSets.PANEL_TEXTAREA_FG);
        textArea.setFont(FontSets.PANEL_TEXTAREA);
        return textArea;
    }

    public static Image getImageFromResource(String imagePath) {
        final String logoPath = Objects.requireNonNull(NotepadFrame.class.getResource(imagePath)).getPath();
        return Toolkit.getDefaultToolkit().getImage(logoPath);
    }

}
