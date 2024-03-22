package com.CYT.mainFrame;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    public RegisterFrame() throws HeadlessException {
        this.setSize(488, 430);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Register");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
    }

}
