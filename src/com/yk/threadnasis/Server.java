package com.yk.threadnasis;
/*
服务端，基于tcp协议
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //创建一个serversocket，指定绑定的端口，监听
        try {
            ServerSocket serverSocket = new ServerSocket(1945);
            //开始监听
            System.out.println("---服务器即将启动，等待客户端链接---");

            Socket socket = null;
            //记录客户端数量
            int count = 0;
            while(true)
            {
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("有"+ count + "人连接");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
