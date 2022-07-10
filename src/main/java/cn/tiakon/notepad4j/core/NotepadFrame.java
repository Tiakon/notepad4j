package cn.tiakon.notepad4j.core;

import cn.tiakon.notepad4j.entity.ColorSets;
import cn.tiakon.notepad4j.entity.LableTextArea;
import cn.tiakon.notepad4j.entity.menubar.*;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Optional;

/**
 * -Dfile.encoding=gbk
 *  todo: 1. 支持打开多文件，多文件名标签切换
 *  todo: 2. 记录记事本大小，位置
 *
 * @author tiankai.me@gmail.com on 2022/7/3 18:38.
 */
public class NotepadFrame extends Frame {

    public NotepadFrame(String title) throws HeadlessException {
        super(title);

        NotepadPanel panel = new NotepadPanel();

        final LableTextArea lableTextArea = new LableTextArea(panel);
        final TextArea textArea = lableTextArea.getTextArea();

        this.setMenuBar(createMenuBar(textArea));
        this.setBackground(ColorSets.FRAME_BG);

        this.add(panel);
        this.addWindowListener(getWindowListener());
        this.addComponentListener(getComponentListener(this, panel));
        this.addContainerListener(getContainerListener());

        this.setBounds(50, 50, 800, 1000);
        this.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        this.setIconImage(getImageFromResource("/logo.png"));
        // 根据内容大小设置窗体大小
        // this.pack();
        this.setVisible(true);
    }

    private WindowListener getWindowListener() {
        return new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                System.out.println("windowOpened...");
            }


            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("windowClosing...");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                System.out.println("windowClosed...");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                super.windowIconified(e);
                System.out.println("windowIconified...");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                super.windowDeiconified(e);
                System.out.println("windowDeiconified...");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                super.windowActivated(e);
                System.out.println("windowActivated...");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                super.windowDeactivated(e);
                System.out.println("windowDeactivated...");
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {
                super.windowGainedFocus(e);
                System.out.println("windowGainedFocus...");
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                super.windowLostFocus(e);
                System.out.println("windowLostFocus...");
            }

            @Override
            public void windowStateChanged(WindowEvent e) {
                super.windowStateChanged(e);
                System.out.println("windowStateChanged...");
            }
        };
    }

    private ComponentListener getComponentListener(NotepadFrame frame, Panel panel) {
        return new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                System.out.printf("frame -> X:%d Y:%d width:%d height:%d componentResized... %n", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
                System.out.printf("panel -> X:%d Y:%d width:%d height:%d componentResized... %n", panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight());
                // textArea.setSize(new Dimension(panel.getWidth(), panel.getHeight()));
            }
        };
    }

    private ContainerListener getContainerListener() {
        return new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                System.out.println("componentAdded...");
                super.componentAdded(e);
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                System.out.println("componentRemoved...");
                super.componentRemoved(e);
            }
        };
    }

    public MenuBar createMenuBar(TextArea textArea) {
        MenuBar menuBar = new MenuBar();
        final FileMenuInMenuBar fileMenuInMenuBar = new FileMenuInMenuBar(this, textArea);
        final EditMenuInMenuBar editMenuInMenuBar = new EditMenuInMenuBar(this, textArea);
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
        final Optional<URL> urlOptional = Optional.ofNullable(NotepadFrame.class.getResource(imagePath));
        if (urlOptional.isEmpty()) {
            throw new NullPointerException(String.format("The resource %s is null.", imagePath));
        }
        final String logoPath = urlOptional.get().getPath();
        return Toolkit.getDefaultToolkit().getImage(logoPath);
    }

    public static void main(String[] args) {
        new NotepadFrame("Notepad4j");
    }

}
