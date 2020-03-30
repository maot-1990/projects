/*
 * Copyright 2020 PHOENIXFIN PTE. LTD.
 */

package com.ezreal.common.scoket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by tao.mao on 2020/3/30.
 */
@Slf4j
public class ClientScoket {

    public static void main(String[] args) throws Exception {
        int i = 0;
        while ( true) {
            Socket socket = new Socket("127.0.0.1", 9005);
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            Scanner input = new Scanner(System.in);
            String str = input.next();
            os.write(str);
            os.flush();
            socket.shutdownOutput();
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = null;
            while ((msg = is.readLine()) != null) {
                System.out.println("客户端接收到的消息：" + msg);
            }
            socket.shutdownInput();
            is.close();
            os.close();
            socket.close();
        }

    }
}
