package com.yk.FileToolsClass;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandom {
    public static void main(String[] args) {
        File demo = new File("demo");
        if(!demo.exists())
        {
            System.out.println("创建成功！");
            demo.mkdir();
        }

        File file = new File(demo,"raf.dat");
        try {
            if(!file.exists())
            {
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file,"rw");

            System.out.println(raf.getFilePointer());
            raf.write('A');
            System.out.println(raf.getFilePointer());
            raf.write('B');
            System.out.println(raf.getFilePointer());
            int i = 0x7fffffff;
            raf.write( i >>> 24);//写入高八位
            raf.write( i >>> 16);//
            raf.write( i >>> 8);//
            raf.write(i);//
            System.out.println(raf.getFilePointer());
            raf.writeInt(i);
            System.out.println(raf.getFilePointer());
            String s = "铠";
            byte [] gbk = s.getBytes("UTF-8");
            raf.write(gbk);
            System.out.println(raf.getFilePointer());
            System.out.println("------------------------------------------");
            System.out.println("------------------------------------------");
            raf.seek(0);
            System.out.println(raf.getFilePointer());
            byte [] buf = new byte[(int)raf.length()];
            raf.read(buf);
            System.out.println(new String(buf,"UTF-8"));
            System.out.println(raf.getFilePointer());
            System.out.println("------------------------------------------");
            for (byte b:buf) {
                System.out.println(Integer.toHexString(b & 0xff) + " ");
            }


            raf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
