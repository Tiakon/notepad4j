package cn.tiakon.notepad4j.entity;

import javax.swing.*;
import java.awt.*;

public class LabelTextArea {

    private final JLabel label;
    private final JTextArea textArea;

    public LabelTextArea(JPanel panel) {
        this.label = createLabel(panel);
        this.textArea = createTextArea(panel);
    }

    public JTextArea createTextArea(JPanel panel) {
        JTextArea textArea = new JTextArea("", 50, 50);
        textArea.setBounds(0, 25, 800, 1000);
        textArea.setBackground(ColorSets.PANEL_TEXTAREA_BG);
        textArea.setForeground(ColorSets.PANEL_TEXTAREA_FG);
        textArea.setFont(FontSets.PANEL_TEXTAREA);
        panel.add(textArea);
        return textArea;
    }

    public JLabel createLabel(JPanel panel) {
        final JLabel label = new JLabel("新建文件");
        label.setBounds(0, 0, 60, 25);
        label.setBackground(new Color(240,240,240));
        label.setForeground(new Color(0, 0, 0));
        panel.add(label);
        return label;
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
