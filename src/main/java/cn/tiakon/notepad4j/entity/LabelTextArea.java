package cn.tiakon.notepad4j.entity;

import java.awt.*;

public class LabelTextArea {

    private final Label label;
    private final TextArea textArea;

    public LabelTextArea(Panel panel) {
        this.label = createLabel(panel);
        this.textArea = createTextArea(panel);
    }

    public TextArea createTextArea(Panel panel) {
        TextArea textArea = new TextArea("", 50, 50);
        textArea.setBounds(0, 25, 800, 1000);
        textArea.setBackground(ColorSets.PANEL_TEXTAREA_BG);
        textArea.setForeground(ColorSets.PANEL_TEXTAREA_FG);
        textArea.setFont(FontSets.PANEL_TEXTAREA);
        panel.add(textArea);
        return textArea;
    }

    public Label createLabel(Panel panel) {
        final Label label = new Label("新建文件");
        label.setBounds(0, 0, 60, 25);
        label.setBackground(new Color(240,240,240));
        label.setForeground(new Color(0, 0, 0));
        panel.add(label);
        return label;
    }

    public Label getLabel() {
        return label;
    }

    public TextArea getTextArea() {
        return textArea;
    }
}
