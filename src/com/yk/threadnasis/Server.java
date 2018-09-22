package com.yk.threadnasis;
/*
服务端，基于tcp协议
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //创建一个serversocket，指定绑定的端口，监听
        try {
            ServerSocket serverSocket = new ServerSocket(1946);
            //开始监听
            System.out.println("---服务器即将启动，等待客户端链接---");
            Socket accept =  serverSocket.accept();//阻塞状态
            //获取输入流，读取信息
            InputStream inputStream =  accept.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(isr);

            String info = null;
            while((info = bufferedReader.readLine()) != null)
            {
                System.out.println(info);
            }

            bufferedReader.close();
            isr.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
