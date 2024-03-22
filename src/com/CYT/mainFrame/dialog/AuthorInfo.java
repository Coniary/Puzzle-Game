package com.CYT.mainFrame.dialog;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AuthorInfo extends JFrame implements MouseListener {

    JLabel jLabel;
    JButton jButton;
    private static  AuthorInfo instance = new AuthorInfo();
    private AuthorInfo() {

    }
    public static AuthorInfo getInstance() {
        return instance;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
