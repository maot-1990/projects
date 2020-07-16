package com.ezreal.demo.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * Created by tao.mao on 2020/6/22.
 */
public class Server {

    ServerSocket serverSocket;

    public Server() throws Exception {
        serverSocket = new ServerSocket(8099);
    }

    public void accept() throws Exception {
        Socket socket = serverSocket.accept();
        while (true) {
            InputStream is = socket.getInputStream();
            int i;
            byte[] bytes = new byte[48];
            int k = 0;
            while ( (i = is.read()) > 0) {
                bytes[k++] = (byte)i;
                byte[] bytes1 = new byte[]{(byte) i};
                if (new String(bytes1).equals("#")) {
                    break;
                }
            }
            System.out.println("服务端接收的消息：" + new String(bytes, "UTF-8"));
            //socket.shutdownInput();

            OutputStream os = socket.getOutputStream();
            os.write(bytes);
            os.flush();
            //socket.shutdownOutput();

            //is.close();
            //os.close();
            // socket.close();
            TimeUnit.SECONDS.sleep(1);

        }

    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.accept();
    }
}
