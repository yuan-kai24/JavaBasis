package com.yk.threadnasis;
/*
客户端
 */

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        //创建客户端
        try {
            Socket localhost = new Socket("192.168.117.1", 1945);
            //获取输出流
            OutputStream outputStream = localhost.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("用户名：admin\r\n密码：123");
            printWriter.flush();
            localhost.shutdownOutput();

            //接受服务端信息
            InputStream inputStream = localhost.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null)
            {
                System.out.println(str);
            }

            //关闭
            printWriter.close();
            outputStream.close();

            inputStreamReader.close();
            inputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
