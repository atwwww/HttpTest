package Handler;

import entity.Resquest;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求构建，主要操作socket传输来的http格式内容，将其规格化为请求实体
 */

public class RequestHandler {
    /**
     *
     * @param socket
     * @return
     * @throws IOException
     * description: 将socket中数据读出，然后对http请求数据进行分割处理，构造Request实例
     */
    public static Resquest resquestHandler(Socket socket) throws IOException{

        Resquest res = new Resquest();

        //从Socket接收到请求信息放在byte数组中
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String request = "";
        if(len > 0){
            request = new String(bytes,0,len);
        }


        //第一部分包括请求行和请求头，第二部分是请求体
        String[] Line_HeadAndBody = request.split("\r\n\r\n");

        //对第一部分操作，分离出请求行和请求头。[0]为请求行 1到截至为请求头
        String[] LineAndHead = Line_HeadAndBody[0].split("\r\n");

        //分割请求行[0]为请求类型 [1]为请求资源 [2]为http版本号
        String[] Line = LineAndHead[0].split(" ");
        res.setRequestType(Line[0]);
        res.setUrl(Line[1]);
        res.setProtocol(Line[2]);

        //分割请求
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i < LineAndHead.length; i++) {
            if(LineAndHead[i] == null || "".equals(LineAndHead[i])){
                break;
            }
            String[] temp = LineAndHead[i].split(": ");
            map.put(temp[0],temp[1]);
        }
        res.setHead(map);

        //BODY
        if(Line_HeadAndBody.length == 2){
            res.setBody(Line_HeadAndBody[1]);
        }

        //此时不需要关闭socket，因为还没有返回信息

        return res;

    }
}
