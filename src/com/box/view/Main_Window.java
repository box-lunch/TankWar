package com.box.view;
import com.box.character.Protagonist;
import com.box.untils.MyClassAnnotation;
import com.box.untils.MyConstructAnnotation;
import com.box.untils.MyMethonAnnotation;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * @author box_lunch
 */
@MyClassAnnotation(desc="主窗口", uri="BY box_lunch")
public class Main_Window extends  JFrame {
    public static final int WINDOW_WIDTH =920;
    public static final int WINDOW_HEIGHT = 800;
    public static int y = 50;
    public static int x = 50;

    /** 新建一个Tank
     */
    Protagonist Tank=new Protagonist(x,y);

    public static void main(String[] args) {
        Main_Window f = new Main_Window();
        f.lunchJFram("坦克大战ver0.1");
    }


    @MyMethonAnnotation(desc = "绘制窗口", uri = "")
    public void lunchJFram(String s) {
        this.setTitle(s);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        TankP a = new TankP();
        KeyAdapter t=new ListenKeyBoard();
        this.getContentPane().add(a);
        this.addKeyListener(t);
    }

    class ListenKeyBoard extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            Tank.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            Tank.keyPressed(e);
        }
    }

    @MyClassAnnotation(desc = "绘制坦克",uri = "在背景基础上")
    class TankP extends ChessPanel{
        @MyConstructAnnotation(desc = "开启线程")
        TankP() {
            Thread t = new RePaint();
            t.start();
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Tank.draw(g);
        }

        @MyClassAnnotation(desc="每隔一段时间重绘",uri = "")
        public class RePaint extends Thread{
            @Override
            public void run() {
                while(true){
                    repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}



