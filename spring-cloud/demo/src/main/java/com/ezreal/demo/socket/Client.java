package com.ezreal.demo.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * Created by tao.mao on 2020/6/22.
 */
public class Client {

    Socket socket;

    public Client() throws Exception {
        socket = new Socket("127.0.0.1", 8099);
    }

    public void send() throws Exception {
        while (true) {
            // socket = new Socket("127.0.0.1", 8099);
            OutputStream os = socket.getOutputStream();
            String send = "hello server";
            os.write(send.getBytes());
            // 结束标记，要不然in.read()会一直阻塞，直到out.close()，会返回-1
            // 发送结束标记
            os.write("#".getBytes());
            os.flush();

            //socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            int i = 0;
            byte[] bytes = new byte[48];
            int k = 0;
            while ((i = is.read()) > -1) {
                bytes[k++] = (byte) i;
                byte[] bytes1 = new byte[] {(byte) i};
                if (new String(bytes1).equals("#")) {
                    break;
                }
            }
            System.out.println("客户端接收到服务端消息：" + new String(bytes, "UTF-8"));

            // socket.shutdownInput();
            //os.close();
            //is.close();
            // socket.close();
            TimeUnit.SECONDS.sleep(1);

        }

    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.send();
    }
}
