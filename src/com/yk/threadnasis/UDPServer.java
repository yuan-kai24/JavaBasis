package com.yk.threadnasis;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        //创建服务端
        DatagramSocket socket = new DatagramSocket(1764);

        //创建数据报，接受信息
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);

        //接受信息
        socket.receive(packet);

        String info = new String(data , 0, packet.getLength());
        System.out.println("接收" + info);

        /*
        响应
         */
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        System.out.println(port);
        byte [] data2 = "欢迎您".getBytes();
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length,address,port);
        socket.send(packet2);
        socket.close();

    }
}
