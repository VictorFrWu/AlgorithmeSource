package DragonJump;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;

//线程类
public class FreshThread extends Thread {
    GamePanl p;

    public FreshThread(GamePanl p) {
        this.p = p;//给类成员属性赋值
    }

    @Override
    public void run() {

        while (!p.isFinish()) {
            p.repaint();//重新绘制图片
            try {
                Thread.sleep(p.FRESH);//休眠刷新时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Container c=p.getParent();
        while(!(c instanceof  MainFrame)){
            c=c.getParent();
        }
        MainFrame f= (MainFrame) c;
        JOptionPane.showMessageDialog(f,"         G A M E  O V E R");

       f.restart();

    }

    }



