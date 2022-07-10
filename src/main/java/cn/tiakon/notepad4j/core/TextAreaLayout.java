package cn.tiakon.notepad4j.core;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// 自定义布局器
class TextAreaLayout extends LayoutAdapter {

    private final List<Component> components = new ArrayList<>();

    // 向面板容器中添加组件，最终会调用布局管理器的添加函数
    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        components.add(comp);
    }

    // 向面板容器中移除组件，最终会调用布局管理器的移除函数
    @Override
    public void removeLayoutComponent(Component comp) {
        components.remove(comp);
    }

    // 布局操作
    @Override
    public void layoutContainer(Container parent) {
        System.out.println("layoutContainer...");
        final String parentName = parent.getName();
        final int height = parent.getHeight();
        final int width = parent.getWidth();
        System.out.printf("%s,%d,%d %n", parentName, height, width);

        for (Component component : components) {

            // final Button button = new Button("新建文件");
            // button.setSize(new Dimension(50, 50));
            // panel.add(button);

            final String componentName = component.getName();
            final int x = component.getX();
            final int y = component.getY();
            final int height1 = component.getWidth();
            final int width1 = component.getHeight();
            System.out.printf("%s,%d,%d,%d,%d %n", componentName, x, y, height1, width1);
        }

    }

}
