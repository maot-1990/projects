/*
 * Copyright 2020 PHOENIXFIN PTE. LTD.
 */

package com.ezreal.common.scoket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tao.mao on 2020/3/30.
 */
@Slf4j
public class ServerScoket {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9005);

        Socket socket = null;
        while (true) {
            socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedReader is = new BufferedReader(new InputStreamReader(inputStream));
            String msg = null;
            String msgAll = "";
            while ((msg = is.readLine()) != null) {
                msgAll += msg;
                System.out.println("服务端接收到的消息：" + msg);
            }
            socket.shutdownInput();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.write(msgAll);
            writer.flush();
            socket.shutdownOutput();
            inputStream.close();
            outputStream.close();
            socket.close();
        }

    }
}
