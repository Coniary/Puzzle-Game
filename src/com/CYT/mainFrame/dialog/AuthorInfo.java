package com.CYT.mainFrame.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AuthorInfo extends JFrame implements MouseListener {

    JLabel jLabel;
    JButton jButton;
    private static  AuthorInfo instance = new AuthorInfo();
    private AuthorInfo() throws HeadlessException {
        this.setSize(503, 210);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        //取消组件布局
        this.getContentPane().setLayout(null);

        init();
    }
    private void init() {
        jLabel = new JLabel("<html>" + "这是由Coniary撰写的拼图小游戏,如果喜欢可以在Github中给作者点赞。" + "</html>");
        jLabel.setBounds(20, 0, 300, 200);
        jLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        this.add(jLabel);

        jButton = new JButton("我已知晓");
        jButton.setBounds(340, 85, 100, 40);
        jButton.addMouseListener(this);
        this.add(jButton);
    }

    public static AuthorInfo getInstance() {
        return instance;
    }
    public void showWindow() {
        this.setVisible(true);
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
