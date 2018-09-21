package com.yk.MyClassHome;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ImageSuiy {
    //    1. 遍历某个文件夹下面的所有文件（包含子、孙……文件）
//            2. 编写一个程序将项目中一个文件复制到C盘
//3. 使用非递归方式遍历某个文件夹下面的所有文件（包含子、孙……文件）
//            4. 将你当前项目的所有子孙目录和文件完全复制到桌面
//5. 用自己的名字作为水印添加到上传的图片中
    public static void main(String[] args) throws IOException {
//        new ImageSuiy().dfs("src",0);
        new ImageSuiy().forLabel();
//        File infile = new File("F:\\MyTest");
//        File out = new File("C:\\Users\\YK\\Desktop" + "\\yuankai.zip");
//
//        zipMultiFile(infile,out,true);



    }

    public static void zipMultiFile(File infile ,File zipFile, boolean dirFlag) {
        try {
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            if(infile.isDirectory()){
                File[] files = infile.listFiles();
                for(File fileSec:files){
                    if(dirFlag){
                        recursionZip(zipOut, fileSec, infile.getName() + File.separator);
                    }else{
                        recursionZip(zipOut, fileSec, "");
                    }
                }
            }
            zipOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void recursionZip(ZipOutputStream zipOut, File file, String baseDir) throws Exception{
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File fileSec:files){
                recursionZip(zipOut, fileSec, baseDir + file.getName() + File.separator);
            }
        }else{
            byte[] buf = new byte[1024];
            InputStream input = new FileInputStream(file);
            zipOut.putNextEntry(new ZipEntry(baseDir + file.getName()));
            int len;
            while((len = input.read(buf)) != -1){
                zipOut.write(buf, 0, len);
            }
            input.close();
        }
    }



    public void forLabel() {
        File src = new File("src");
        List<File> currentFiles = Arrays.asList(src.listFiles());//当前操作的文件
        List<File> nextFiles = new ArrayList<>();//下一次操作的文件
        while (!currentFiles.isEmpty()) {
            for (File item : currentFiles) {
                if (item.isFile()) {
                    System.out.println(item.getName());
                    continue;
                }
                if (item.isDirectory()) {
                    File[] children = item.listFiles();
                    if (children != null && children.length > 0) {
                        nextFiles.addAll(Arrays.asList(children));
                        continue;
                    }
                    System.out.println(item.getName());
                }
            }
            currentFiles = new ArrayList<>(nextFiles);
            nextFiles.clear();
        }

    }


    public void dfs(String fl, int count) {
        File file = new File(fl);
        File[] files = file.listFiles();
        for (File f : files) {
            for (int i = 0; i < count; i++) System.out.print("..");
            System.out.println(f.getName());
            if (f.isDirectory()) {
                dfs(f.getAbsolutePath() + "\\", count + 1);
            }
        }
    }

    public static void addTextToImage() throws IOException {
        String in = "F:\\IDEA_Java\\JavaBasis\\resource\\20140814122633546.jpg";
        String out = "F:\\IDEA_Java\\JavaBasis\\resource\\sy.png";
        String sy = "F:\\IDEA_Java\\JavaBasis\\resource\\kksy.png";
        File file = new File(in);
        File syfile = new File(sy);
        Image image = ImageIO.read(file);
        Image image1 = ImageIO.read(syfile);

        BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bi.createGraphics();
        graphics.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
        graphics.drawImage(image1, 0, 0, image.getWidth(null), image.getHeight(null), null);
        graphics.dispose();
        ImageIO.write(bi, "JPG", new FileOutputStream(out));
    }
}
