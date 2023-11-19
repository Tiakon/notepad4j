package cn.tiakon.notepad4j.core;

import cn.tiakon.notepad4j.entity.ColorSets;
import cn.tiakon.notepad4j.entity.menubar.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Optional;

/**
 * -Dfile.encoding=utf-8
 *  todo: 1. 支持打开多文件，多文件名标签切换
 *  todo: 2. 记录记事本大小，位置
 *
 * @author tiankai.me@gmail.com on 2022/7/3 18:38.
 */
public class NotepadJFrame extends JFrame {
    private final int DESKTOP_WIDTH = 480;
    private final int DESKTOP_HEIGHT = 360;

    public NotepadJFrame(String title) throws HeadlessException {
        super(title);
        // NotepadJPanel panel = new NotepadJPanel();
        // final LabelTextArea labelTextArea = new LabelTextArea(panel);
        // final JTextArea textArea = labelTextArea.getTextArea();

        //创建外部窗口
        //创建虚拟桌面
        JDesktopPane desktop = new JDesktopPane();
        //设置虚拟桌面的最佳大小
        desktop.setPreferredSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));

        this.setJMenuBar(createMenuBar(desktop));
        this.setBackground(ColorSets.FRAME_BG);

        // panel.add();

        this.add(desktop);
        // this.setBounds(200, 200, 800, 1000);
        this.setSize(700, 900);
        this.setLocationRelativeTo(null);
        this.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        this.setIconImage(getImageFromResource("/logo.png"));
        // 根据内容大小设置窗体大小
        // this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JMenuBar createMenuBar(JDesktopPane desktop) {
        JMenuBar menuBar = new JMenuBar();
        final FileMenuInMenuBar fileMenuInMenuBar = new FileMenuInMenuBar(this, desktop);
        final EditMenuInMenuBar editMenuInMenuBar = new EditMenuInMenuBar(this);
        final ViewMenuInMenuBar viewMenuInMenuBar = new ViewMenuInMenuBar();
        final SearchMenuInMenuBar searchMenuInMenuBar = new SearchMenuInMenuBar();
        final HelpMenuInMenuBar helpMenuInMenuBar = new HelpMenuInMenuBar();
        menuBar.add(fileMenuInMenuBar.getMenu());
        menuBar.add(editMenuInMenuBar.getMenu());
        menuBar.add(viewMenuInMenuBar.getMenu());
        menuBar.add(searchMenuInMenuBar.getMenu());
        menuBar.add(helpMenuInMenuBar.getMenu());
        return menuBar;
    }

    public JMenuBar createMenuBar(JDesktopPane desktop, JTextArea textArea) {
        JMenuBar menuBar = new JMenuBar();
        final FileMenuInMenuBar fileMenuInMenuBar = new FileMenuInMenuBar(this, desktop, textArea);
        final EditMenuInMenuBar editMenuInMenuBar = new EditMenuInMenuBar(this);
        final ViewMenuInMenuBar viewMenuInMenuBar = new ViewMenuInMenuBar();
        final SearchMenuInMenuBar searchMenuInMenuBar = new SearchMenuInMenuBar();
        final HelpMenuInMenuBar helpMenuInMenuBar = new HelpMenuInMenuBar();
        menuBar.add(fileMenuInMenuBar.getMenu());
        menuBar.add(editMenuInMenuBar.getMenu());
        menuBar.add(viewMenuInMenuBar.getMenu());
        menuBar.add(searchMenuInMenuBar.getMenu());
        menuBar.add(helpMenuInMenuBar.getMenu());
        return menuBar;
    }

    public static Image getImageFromResource(String imagePath) {
        final Optional<URL> urlOptional = Optional.ofNullable(NotepadJFrame.class.getResource(imagePath));
        if (urlOptional.isEmpty()) {
            throw new NullPointerException(String.format("The resource %s is null.", imagePath));
        }
        final String logoPath = urlOptional.get().getPath();
        return Toolkit.getDefaultToolkit().getImage(logoPath);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NotepadJFrame("Notepad4j"));
    }

}
