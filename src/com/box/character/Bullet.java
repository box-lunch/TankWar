package com.box.character;

import com.box.untils.MyClassAnnotation;

import java.awt.*;

@MyClassAnnotation(desc = "子弹",uri = "")
public class Bullet {
    private int x;
    private int y;
    Bullet(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void Draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillOval(x, y, 5,5);
        g.setColor(c);
    }
}
