package com.CYT.mainFrame;

import com.CYT.mainFrame.dialog.AuthorInfo;
import com.CYT.mainFrame.dialog.How2Play;
import com.CYT.mainFrame.dialog.WinnerJFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;

import static java.lang.System.exit;

public class GameJFrame extends JFrame implements ActionListener, KeyListener {
    // 创建二维数组管理图片数据
    int[][] data;
    // 零号方块坐标
    int x, y;
    int steps = 0;
    JMenuBar jmb;
    JMenu jm1, jm2, jm1_1;
    JMenuItem jm1_2, jm1_3, jm1_4; JMenuItem jm1_1_1;
    JMenuItem jm2_1, jm2_2;

    static WinnerJFrame wj = WinnerJFrame.getInstance();
    static AuthorInfo ai = AuthorInfo.getInstance();
    static How2Play hp = How2Play.getInstance();

    public GameJFrame() throws HeadlessException {
        this.setSize(603, 680);
        this.setTitle("Puzzle_Game Version 1.0");

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.getContentPane().setLayout(null);   // 取消输出布局

        this.addKeyListener(this);
        // 初始化菜单栏
        initMenuBar();

        // 初始化随机数据
        initData();

        // 初始化图像
        initImage();


        this.setVisible(true);
    }

    private void initData() {
        data = new int[4][4];

        int[] base = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();


        // 顺序遍历随机交换数值
        for (int i = 0; i < base.length; i++) {
            int index = r.nextInt(base.length);
            int temp = base[i];
            base[i] = base[index];
            base[index] = temp;
        }


        // 一维数组录入二维
        for (int i = 0; i < base.length; i++) {
            if (base[i] == 0) {
                x = i % 4;
                y = i / 4;
            }

            data[i / 4][i % 4] = base[i];
        }


        // 控制台输出此随机的结果
        System.out.println("图片编号如下:");
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(data[i]));
        }

    }

    private void initMenuBar() {
        jmb = new JMenuBar();

        jm1 = new JMenu("功能");
        // 1#
        jm1_1 = new JMenu("更换图片");
        jm1_1_1 = new JMenuItem("天空");
        jm1_2 = new JMenuItem("重新游戏");
        jm1_3 = new JMenuItem("重新登录");
        jm1_4 = new JMenuItem("关闭游戏");
        // 1##

        jm1.add(jm1_1);
            jm1_1.add(jm1_1_1);
        jm1.add(jm1_2);
        jm1.add(jm1_3);
        jm1.add(jm1_4);

        jm2 = new JMenu("关于");
        // 2#
        jm2_1 = new JMenuItem("作者信息");
        jm2_2 = new JMenuItem("操作说明");

        jm2.add(jm2_1);
        jm2.add(jm2_2);

        //添加组件监听
        jm1_1.addActionListener(this);
        jm1_2.addActionListener(this);
        jm1_3.addActionListener(this);
        jm1_4.addActionListener(this);
        jm2_1.addActionListener(this);
        jm2_2.addActionListener(this);
        jm1_1_1.addActionListener(this);
        //组件封装
        jmb.add(jm1);
        jmb.add(jm2);

        this.setJMenuBar(jmb);
    }
    private void initImage() {
        this.getContentPane().removeAll();

        JLabel tag = new JLabel();
        tag.setText("<html>" + "累计步数: " + steps + "</html>");
        tag.setBounds(10, 10, 100, 70);
        this.add(tag);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel jLabel = new JLabel(new ImageIcon("images/Landscape/Sky/Sky_"+ String.format("%02d", data[i][j]) +".jpg"));
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                if (data[i][j] != 0) jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                else jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.add(jLabel);
            }
        }

        JLabel bg = new JLabel(new ImageIcon("images/Background/Background.png"));
        bg.setBounds(40, 40, 508, 560);
        this.add(bg);

        this.getContentPane().repaint();
    }
    private boolean isWin() {
        boolean tag = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (data[i][j] - data[i][j+1] != 1) {
                    tag = false;
                    break;
                }
            }
        }
        return tag;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == jm1_1) {
            System.out.println("要求更换图片");

        } else if (source == jm1_2) {
            System.out.println("要求重新游戏");
            steps = 0;
            initData();
            initImage();
        } else if (source == jm1_3) {
            System.out.println("要求重新登录");

        } else if (source == jm1_4) {
            System.out.println("要求退出游戏");
            exit(0);
        } else if (source == jm2_1) {
            System.out.println("要求显示作者信息");
            ai.showWindow();
        } else if (source == jm2_2) {
            System.out.println("要求显示操作方法");
            hp.showWindow();
        } else if (source == jm1_1_1) {
            System.out.println("要求使用天空背景");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 39) {
            // 左
            steps++;
            if (x-1 >= 0) {
                data[y][x] = data[y][x-1];
                data[y][x-1] = 0;
                --x;
                initImage();
            }
        } else if (code == 40) {
            // 上
            steps++;
            if (y-1 >= 0) {
                data[y][x] = data[y-1][x];
                data[y-1][x] = 0;
                --y;
                initImage();
            }
        } else if (code == 37) {
            // 右
            steps++;
            if (x+1 <= 3) {
                data[y][x] = data[y][x+1];
                data[y][x+1] = 0;
                ++x;
                initImage();
            }
        } else if (code == 38) {
            // 下
            steps++;
            if (y+1 <= 3) {
                data[y][x] = data[y+1][x];
                data[y+1][x] = 0;
                ++y;
                initImage();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 判断是否胜利
        if (isWin()) {
            // 弹窗宣布胜利
            System.out.println("玩家已完成拼图");
            wj.showWindow(steps);
        }
        // 判断 A键 是否激活
        if (e.getKeyCode() == 65) {

        }
    }
}