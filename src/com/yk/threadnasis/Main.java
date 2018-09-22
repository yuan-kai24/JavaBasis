package com.yk.threadnasis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
//        try {
//            InetAddress localHost = InetAddress.getLocalHost();
//            System.out.println(localHost.getCanonicalHostName());
//            System.out.println(localHost.getHostAddress());
//            byte[] address = localHost.getAddress();
//            System.out.println(address.toString());
//            System.out.println(localHost);
//            System.out.println("------------------------------------------");
//            InetAddress byName = InetAddress.getByName(localHost.getHostName());
//            System.out.println(byName.getHostName());
//            System.out.println(byName.getHostAddress());
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
        try {
            URL url = new URL("http://www.baidu.com");
            try {
                //获取字节流
                InputStream inputStream = url.openStream();
                //转换为字符流
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                //转换为缓冲流
                BufferedReader br = new BufferedReader(inputStreamReader);
                //读取数据
                String data = br.readLine();
                while (data != null)
                {
                    System.out.println(data);
                    data = br.readLine();
                }
                br.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
