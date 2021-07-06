package Main;

import threadtools.Task;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程http服务器入口
 */

public class Bootstrap {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);

        int counter = 0;

        while (true) {
            Socket accept = server.accept();
            counter++;

            System.out.println(counter+ " "  + "接收请求...");

            //将接收到的请求用线程处理
            new Thread(new Task(accept)).start();

        }
    }

}
