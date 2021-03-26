package com.chidan.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HP
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("server is running...");
        while (true){
            Socket accept = serverSocket.accept();
            System.out.println("connected from " + accept.getRemoteSocketAddress());
            Thread t = new Handler(accept);
            t.start();
        }
    }
}
