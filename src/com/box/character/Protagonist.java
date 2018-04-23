package com.box.character;

import com.box.untils.MyClassAnnotation;
import com.box.untils.MyConstructAnnotation;
import com.box.untils.MyMethonAnnotation;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author box_lunch
 * @date 2018-4-23
 */
@MyClassAnnotation(desc = "坦克",uri = "")
public class Protagonist {
    /**坦克所在的X,Y坐标
    */
    private int x,y;
    /**移动距离
     */
    private static final int XSPEED=5;
    private static final int YSPEED=5;
    /**定义4个方向
     */
    private boolean bl=false;
    private boolean br=false;
    private boolean bu=false;
    private boolean bd=false;
    /**声明8个方向
     */
    enum Direction{
        /**左
        */L,
        /**左上
        */LU ,
        /**上
        */U,
        /**右上
        */RU,
        /**右
        */R,
        /**右下
        */RD,
        /**下
        */D,
        /**左下
        */LD,
        /**无动作
        */STOP
    }
    /**声明dir并定义
     */
    private  Direction dir = Direction.STOP;

    @MyConstructAnnotation(desc = "构造坦克")
    public Protagonist(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @MyMethonAnnotation(desc = "画出自己" ,uri = "调用本类的move")
    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, 30,30);
        g.setColor(c);
        move();
    }
    @MyMethonAnnotation(desc = "移动的函数",uri = "根据locatDirection设定的dir值")
    private void move(){
        switch (dir){
            case L:
                x -=XSPEED;
                break;
            case LD:
                x-=(int)(Math.sqrt(XSPEED*XSPEED+YSPEED*YSPEED));
                y+=(int)(Math.sqrt(XSPEED*XSPEED+YSPEED*YSPEED));
                        break;
            case U:
                y-=YSPEED;
                break;
            case LU:
                x-=(int)(Math.sqrt(XSPEED*XSPEED+YSPEED*YSPEED));
                y-=(int)(Math.sqrt(XSPEED*XSPEED+YSPEED*YSPEED));
                        break;
            case R:
                x+=XSPEED;
                break;
            case RD:
                x+=(int)(Math.sqrt(XSPEED*XSPEED+YSPEED*YSPEED));
                y+=(int)(Math.sqrt(XSPEED*XSPEED+YSPEED*YSPEED));
                        break;
            case D:
                y+=YSPEED;
                break;
            case RU:
                x+=(int)(Math.sqrt(XSPEED*XSPEED+YSPEED*YSPEED));
                y-=(int)(Math.sqrt(XSPEED*XSPEED+YSPEED*YSPEED));
                        break;
            case STOP:
                break;
                default:
                    break;
        }
    }

    @MyMethonAnnotation(desc = "监听键盘按下的操作",uri = "每一下都会设定相对应的bool为true")
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_RIGHT :
                br=true;
                break;
            case KeyEvent.VK_LEFT :
                bl=true;
                break;
            case KeyEvent.VK_DOWN :
                bd=true;
                break;
            case KeyEvent.VK_UP :
                bu=true;
                break;
            default:
                break;
        }
        locateDirection();
    }
    @MyMethonAnnotation(desc = "监听键盘放开的操作",uri = "每一下都会设定相对应的bool为false")
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_RIGHT :
                br=false;
                break;
            case KeyEvent.VK_LEFT :
                bl=false;
                break;
            case KeyEvent.VK_DOWN :
                bd=false;
                break;
            case KeyEvent.VK_UP :
                bu=false;
                break;
            default:
                break;
        }
        locateDirection();
    }
    @MyMethonAnnotation(desc = "设定dir",uri = "由keyPressed或keyReleased每次的设定来设置dir值")
    private void locateDirection(){
        if(bl && !bu && !br && !bd) {dir =Direction.L;}
        else if(!bl && !bu && br && !bd) {dir =Direction.R;}
        else if(!bl && bu && !br && !bd) {dir =Direction.U;}
        else if(!bl && !bu && !br && bd) {dir =Direction.D;}
        else if(bl && bu && !br && !bd) {dir =Direction.LU;}
        else if(bl && !bu && !br && bd) {dir =Direction.LD;}
        else if(!bl && !bu && br && bd) {dir =Direction.RD;}
        else if(!bl && bu && br && !bd) {dir =Direction.RU;}
        else if(!bl && !bu && !br && !bd) {dir =Direction.STOP;}

    }
}
