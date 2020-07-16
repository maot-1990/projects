package com.ezreal.demo.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * Created by tao.mao on 2020/6/22.
 */
public class ServerChannel {

    public ServerChannel() throws Exception {
    }

    public void accept() throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 9008));
        // serverSocketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            socketChannel.read(buffer);
            byte[] bytes = new byte[1024];
            int k = 0;
            int i;
            buffer.flip();
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                bytes[k++] = b;
                byte[] bytes1 = new byte[]{(b)};
                if (new String(bytes1).equals("#")) {
                    break;
                }
            }
            System.out.println("服务端接收的消息：" + new String(bytes, "UTF-8"));
            //socket.shutdownInput();
            buffer.flip();
            socketChannel.write(buffer);

            //socket.shutdownOutput();

            //is.close();
            //os.close();
            // socket.close();
            TimeUnit.SECONDS.sleep(1);

        }

    }

    public static void main(String[] args) throws Exception {
        ServerChannel server = new ServerChannel();
        server.accept();
    }
}
