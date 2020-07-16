package com.ezreal.demo.nio;

import java.nio.ByteBuffer;

/**
 * Created by tao.mao on 2020/6/22.
 */
public class Buffer {

    public static void main(String[] args) {
        String s = "I am NIO.";
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put(s.getBytes());
        String b = " continue write.";
        buffer.put(b.getBytes());
        /*System.out.println(buffer.mark());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());*/
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }

        // 设置flip后，已经置limit为实际大小的position，所以不能再进行写入了
        // buffer.put(s.getBytes());

        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }

        buffer.clear();
        String c = "I am BIO.";
        buffer.put(c.getBytes());
        buffer.flip();
        buffer.position(1);
        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }
    }
}
