package com.ezreal.demo.socket;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * Created by tao.mao on 2020/6/22.
 */
public class ClientChannel {

    Socket socket;

    public ClientChannel() throws Exception {
    }

    public void send() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9008));

        while (true) {
            String send = "hello server #";
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(send.getBytes());
            buffer.flip();
            socketChannel.write(buffer);

            buffer.clear();
            socketChannel.read(buffer);
            buffer.flip();
            int i = 0;
            byte[] bytes = new byte[1024];
            int k = 0;
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                bytes[k++] = b;
                byte[] bytes1 = new byte[] {b};
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
        ClientChannel client = new ClientChannel();
        client.send();
    }
}
