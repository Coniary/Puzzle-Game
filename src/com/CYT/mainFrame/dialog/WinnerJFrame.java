package com.CYT.mainFrame.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WinnerJFrame extends JFrame implements MouseListener {
    /* 单例 */
    private JLabel jLabel;
    private JButton jButton;
    private int steps = 0;
    private static WinnerJFrame instance = new WinnerJFrame();
    private WinnerJFrame() throws HeadlessException {
        this.setSize(603 - 100, 280 - 50 - 20);
        this.setTitle("拼图已完成");
        this.setResizable(false);
        // 设置窗体在最上方
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        // 取消输出布局
        this.getContentPane().setLayout(null);

        init();
    }
    public static WinnerJFrame getInstance() {
        return instance;
    }
    public void showWindow(int steps) {
        this.steps = steps;
        this.setVisible(true);

        initUI();

    }


    private void init() {
        initUI();


    }

    private void initUI() {
        this.getContentPane().removeAll();

        jLabel = new JLabel("<html>" + "拼图已完成! 你一共走了" + steps + "步" + "</html>");
        jLabel.setBounds(40, 20 + 10, 300, 100);
        jLabel.setFont(new Font("微软雅黑", Font.ITALIC, 20));
        this.add(jLabel);

        jButton = new JButton("完成");
        jButton.setBounds(340, 60, 100, 50);
        jButton.addMouseListener(this);
        this.add(jButton);

        this.getContentPane().repaint();
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
