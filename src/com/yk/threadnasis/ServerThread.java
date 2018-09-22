package com.yk.threadnasis;

/*
服务器端线程
 */

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        //读取客户端传入信息
        try {
            inputStream = socket.getInputStream();
            reader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(reader);

            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("收到客户端：" + info);

            }
            InetAddress address = socket.getInetAddress();
            System.out.println(address.getHostAddress());
            socket.shutdownInput();

            //输出流
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("服务端已经收到了信息！");
            printWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (bufferedReader != null)
                    bufferedReader.close();
                if (reader != null)
                    reader.close();
                if (inputStream != null)
                    inputStream.close();

                if (printWriter != null)
                    printWriter.close();
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
