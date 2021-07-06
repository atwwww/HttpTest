package threadtools;

import Handler.RequestHandler;
import Handler.ResponseHandler;
import entity.Response;
import entity.Resquest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 构建多线程处理器
 */

public class Task implements Runnable{

    Socket socket;

    public Task(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        excute(this.socket);
    }

    private void excute(Socket socket) {

        Response response;

        //构建客户端的请求信息，便于在服务端处理
        Resquest resquest = null;
        try {
            resquest = RequestHandler.resquestHandler(socket);
            //根据客户端请求构建服务端请求
            response = ResponseHandler.responseHandler(resquest);
            write(socket, response.getResponseLine() + response.getResponseHead() + response.getHtml());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void write(Socket socket, String response) throws IOException{
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(response.getBytes());
    }
}
