package com.CYT.mainFrame.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class How2Play extends JFrame implements MouseListener {
    /* 单例 */

    JLabel jLabel;
    JButton jButton;
    private static final How2Play instance = new How2Play();
    public static How2Play getInstance() {
        return instance;
    }
    public void showWindow() {
        this.setVisible(true);
    }
    private How2Play() throws HeadlessException {
        this.setSize(503, 210);
        this.setTitle("操作说明");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        //取消组件布局
        this.getContentPane().setLayout(null);

        init();
    }

    private void init() {
        jLabel = new JLabel( "<html>" + "↑ ↓ ← →来向中心移动滑块,按下 A 键可以短暂预览图片" + "</html>");
        jLabel.setBounds(20, 0, 300, 200);
        jLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        this.add(jLabel);

        jButton = new JButton("我已知晓");
        jButton.setBounds(340, 85, 100, 40);
        jButton.addMouseListener(this);
        this.add(jButton);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
        if (source == jButton) {
            this.dispose();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
