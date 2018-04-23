package com.box.view;

import com.box.untils.MyClassAnnotation;

import javax.swing.*;
import java.awt.*;


public class Paint extends JFrame{


}


@MyClassAnnotation(desc = "绘制背景",uri = "")
class ChessPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Toolkit kit=Toolkit.getDefaultToolkit();
        Image img=kit.getImage("src/com/box/Image/1.jpg");
        g.drawImage(img, 0,0, this.getWidth(),this.getHeight(),null);

    }
}

