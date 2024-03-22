package com.CYT.mainFrame;

import javax.swing.*;
import java.awt.*;

public class LoginJFrame extends JFrame {
    public LoginJFrame() throws HeadlessException {
        this.setSize(488, 430);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
    }

}
