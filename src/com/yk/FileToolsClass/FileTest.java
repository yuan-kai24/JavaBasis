package com.yk.FileToolsClass;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        File fl = new File("F:\\IDEA_Java\\JavaBasis\\src\\com\\yk\\FileToolsClass\\source\\test");
        File fl2 = new File("F:\\IDEA_Java\\JavaBasis\\src\\com\\yk\\FileToolsClass\\source\\ty2\\123\\test");
       FileSystemView systemView = new FileSystemView() {
           @Override
           public File createNewFolder(File containingDir) throws IOException {
               return null;
           }
       };

        try {
            //fl2.createNewFile();
            //System.out.println(fl2.mkdirs());
            fl2.renameTo(new File("F:\\IDEA_Java\\JavaBasis\\src\\com\\yk\\FileToolsClass\\source\\ty2\\test\\tes"));
            //System.out.println(fl2.delete());
            FileInputStream fin = new FileInputStream(fl);

            byte [] by = new byte[1024];
            int len = fin.read(by);
            StringBuilder str = new StringBuilder();
            while (len != -1){
                str.append(new String(by));
                len = fin.read(by);
                System.out.println(len);
            }
            FileOutputStream fout = new FileOutputStream(fl);
            str.append("哈哈哈\r\n");
            fout.write(str.toString().getBytes("utf-8"));
            //new FileOutputStream(fl2).write(str.toString().getBytes("utf-8"));
            fout.close();
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

interface abc{
    public void ac();
}