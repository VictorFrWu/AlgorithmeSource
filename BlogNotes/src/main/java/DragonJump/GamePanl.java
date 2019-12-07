package DragonJump;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 继承窗体面板的图片
 */
public class GamePanl extends JPanel implements KeyListener {
    //主图片
    BufferedImage image;

    //绘图工具，美工
    Graphics2D g2;
    kLong klong;//恐龙
    boolean finish = false;//游戏结束

    static final int FRESH = 10;//刷新时间，毫秒

    BackgroundImage background;



    List<object> list = new ArrayList<object>();//障碍物集合

    int addObjectTimer = 0;
    object ob=new object();


    int score=0;//分数
    int addScoreTimer=0;

    //构造方法
    public GamePanl() {
        image = new BufferedImage(734, 286, BufferedImage.TYPE_INT_BGR);
        g2 = image.createGraphics();
        klong = new kLong();//实例化恐龙类
        background = new BackgroundImage();//实例化背景图片

        list.add(new object());


        FreshThread t = new FreshThread(this);//刷新线程
        t.start();

    }

    private void painImage() {//绘制图片
        klong.move();//让小恐龙移动
        background.roll();//调用滚动图片
        g2.drawImage(background.image, 0, 0, this);//绘制背景
        g2.drawImage(background.image_yun, background.x_yun,background.y_yun, this);//绘制白云

         g2.drawImage(klong.image, klong.x, klong.y, this);//绘制恐龙

        if (addObjectTimer >= 1400) {//计算分数时间判断
            list.add(new object());
            addObjectTimer = 0;
        }

        for (int i = 0; i < list.size(); i++) {
            object o = list.get(i);
            o.move();
            o.bridMove();

            g2.drawImage(o.image, o.x, o.y, this);//绘制障碍



            //判断障碍物是否和头、脚相撞
            if (o.bounds().intersects(klong.bounds1()) || o.bounds().intersects(klong.bounds2())){

                gameOver();//游戏结束

            }
        }
        //分数++
        if (addObjectTimer>=50){
            score+=1;
            addScoreTimer=0;
        }

        //分数显示代码---"%05d"---指的是分数以五位数显示
        g2.drawString(String.format("%05d",score),600,35 );
        g2.drawString("Hi",536,35 );
        g2.drawString(String.format("%05d",+MainFrame.topScore),550,35 );


        addObjectTimer += FRESH;
        addScoreTimer +=FRESH;
    }


    //游戏结束
    public void gameOver(){
        finish=true;
//        image=background.image_over;
        g2.drawImage(background.image_over,background.x_over,background.y_over,null);
        if (score>MainFrame.topScore){//判断最高分
            MainFrame.topScore=score;
        }


    }

    @Override
    public void paint(Graphics g) {
        painImage();
        g.drawImage(image, 0, 0, this);
    }


    public boolean isFinish() {
        return finish;
    }

        //键盘监听
    @Override
    public void keyTyped(KeyEvent e) {//按键类型

    }

    @Override
    public void keyPressed(KeyEvent e) {//按键按下
        int code = e.getKeyCode();//获取按下的编码
        if (code == KeyEvent.VK_SPACE) {
            klong.jump();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {//按键抬起

    }
}
