package com.chidan.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author HP
 */
public class Handler extends Thread{

    Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream input = this.socket.getInputStream()){
            try(OutputStream output = this.socket.getOutputStream()) {
                handle(input, output);
            }
        }catch (Exception e){
            try{
                this.socket.close();
            }catch (IOException io){
                System.out.println("client disconnected.");
            }
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException{
        System.out.println("Process new http request...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        //处理Http请求
        boolean requestOK = false;
        String first = reader.readLine();
        if (first.startsWith("GET")){
            requestOK = true;
        }
        while (true){
            String header = reader.readLine();
            if (header.isEmpty()){
                break;
            }
            System.out.println(header);
        }
        System.out.println(requestOK ? "Response OK": "Response Error");
        if (requestOK){
            // 发送成功响应:
            String data = "<html><body><h1>Hello, world!</h1></body></html>";
            int length = data.getBytes(StandardCharsets.UTF_8).length;
            writer.write("HTTP/1.0 200 OK\r\n");
            writer.write("Connection: close\r\n");
            writer.write("Content-Type: text/html\r\n");
            writer.write("Content-Length: " + length + "\r\n");
            writer.write("\r\n"); // 空行标识Header和Body的分隔
            writer.write(data);
            writer.flush();
        }else {
            // 发送错误响应:
            writer.write("HTTP/1.0 404 Not Found\r\n");
            writer.write("Content-Length: 0\r\n");
            writer.write("\r\n");
            writer.flush();
        }
    }

}
