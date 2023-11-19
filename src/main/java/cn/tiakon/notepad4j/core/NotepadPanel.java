package cn.tiakon.notepad4j.core;

import java.awt.*;

/**
 * @author tiankai.me@gmail.com on 2022/7/9 20:36.
 */
public class NotepadPanel extends Panel {

    public NotepadPanel() {
        final TextAreaLayout textAreaLayout = new TextAreaLayout();
        setLayout(textAreaLayout);
        setBounds(0, 0, 800, 1000);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        System.out.println("paintComponents...");
    }


}
