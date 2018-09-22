package com.yk.threadnasis;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {

        InetAddress address = InetAddress.getByName("localhost");
        int port = 1764;
        byte [] data = "用户名:admin|密码：123".getBytes();
        //创建数据报
        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);

        //发送数据
        DatagramSocket socket = new DatagramSocket();

        //向服务器发送数据报
        socket.send(packet);

        System.out.println("------------------------------------------");
        //相应数据
        byte [] data3 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data3,data3.length);
        socket.receive(packet1);
        String reply = new String(data3, 0, packet1.getLength());
        System.out.println(reply);
        socket.close();
    }
}
