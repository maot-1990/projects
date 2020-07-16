package com.ezreal.demo.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by tao.mao on 2020/6/22.
 */
public class Channel {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/ezreal/Desktop/hehe.txt");
        FileChannel channel = FileChannel.open(file.toPath());
        ByteBuffer byteBuffer = ByteBuffer.allocate(4086);
        channel.read(byteBuffer);
        byteBuffer.flip();
        byte[] bytes = new byte[11];
        while (byteBuffer.hasRemaining()) {
            byteBuffer.get(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            bytes = new byte[byteBuffer.remaining()];

        }
        FileOutputStream fos = new FileOutputStream("/Users/ezreal/Desktop/haha.txt");
        WritableByteChannel writableByteChannel = Channels.newChannel(fos);
        channel.transferTo(0, 10, writableByteChannel);

        ByteBuffer writeBuffer = ByteBuffer.allocate(24);
        writeBuffer.put("我是来打酱油的".getBytes());
        System.out.println(writeBuffer.remaining());
        writeBuffer.flip();
        writableByteChannel.write(writeBuffer);
        fos.flush();
        fos.close();
        writableByteChannel.close();


    }
}
