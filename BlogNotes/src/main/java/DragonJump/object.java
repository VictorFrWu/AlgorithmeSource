package DragonJump;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * 障碍物类
 */
public class object {
    kLong klong=new kLong();
    Random r = new Random();
    int x, y;
    public boolean judge=false;
    BufferedImage image;
    BufferedImage cactus01, cactus02, cactus03,bird1,bird2;//创建仙人掌+鸟
    int speed = BackgroundImage.SPEED -1;
    int temp = r.nextInt(4) + 1;//1-2-3

    public object() {
        //读取图片
        try {
            cactus01 = ImageIO.read(new File("image/cactus01.png"));
            cactus02 = ImageIO.read(new File("image/cactus02.png"));
            cactus03 = ImageIO.read(new File("image/cactus03.png"));
              bird1= ImageIO.read(new File("image/bird1.png"));
              bird2= ImageIO.read(new File("image/bird2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        x = 800;
        y = 209;

        //随机输出障碍物
        switch (temp) {
            case 1:
                image = cactus01;
                break;
            case 2:
                image = cactus02;
                break;
            case 3:
                image = cactus03;
                y = 200;
                break;
                default:
                    judge=true;
        }


    }

    //鸟的运动
    void bridMove() {
        if (judge){
//            if (temp>2){
//                y-=20;
//            }
        int tmp = klong.stepTime / 100 % 2;
        if (tmp == 1) {
            image = bird1;
        } else {
            image = bird2;
        }

        klong.stepTime += klong.fresh;
      }
}

    //滚动
    public void move() {
        x -= speed;
        x -= speed;
    }


    //死亡区域
    public Rectangle bounds() {
        return new Rectangle(x,y+2,image.getWidth()-2,image.getHeight()-10);
    }


}
