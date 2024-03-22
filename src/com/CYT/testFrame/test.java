package com.CYT.testFrame;

import com.CYT.mainFrame.GameJFrame;
import com.CYT.mainFrame.dialog.WinnerJFrame;

// 图片尺寸 420 * 420 每一分块为105 * 105
public class test {
    static WinnerJFrame wj = WinnerJFrame.getInstance();
    public static void main(String[] args) {
        new GameJFrame();
    }
}
