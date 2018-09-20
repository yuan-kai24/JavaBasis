package com.yk.MyClassHome;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageSuiy {
//    1. 遍历某个文件夹下面的所有文件（包含子、孙……文件）
//            2. 编写一个程序将项目中一个文件复制到C盘
//3. 使用非递归方式遍历某个文件夹下面的所有文件（包含子、孙……文件）
//            4. 将你当前项目的所有子孙目录和文件完全复制到桌面
//5. 用自己的名字作为水印添加到上传的图片中
    public static void main(String[] args) throws IOException {
        new ImageSuiy().dfs(".",0);

    }

    public void dfs(String fl,int count)
    {
        File file = new File(fl);
        System.out.println(file.getAbsolutePath());
    }

    public static void addTextToImage() throws IOException{
        String in = "F:\\IDEA_Java\\JavaBasis\\resource\\20140814122633546.jpg";
        String out = "F:\\IDEA_Java\\JavaBasis\\resource\\sy.png";
        String sy = "F:\\IDEA_Java\\JavaBasis\\resource\\kksy.png";
        File file = new File(in);
        File syfile = new File(sy);
        Image image = ImageIO.read(file);
        Image image1 = ImageIO.read(syfile);

        BufferedImage bi = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics =  bi.createGraphics();
        graphics.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
        graphics.drawImage(image1, 0, 0, image.getWidth(null), image.getHeight(null), null);
        graphics.dispose();
        ImageIO.write(bi, "JPG", new FileOutputStream(out));
    }
}
