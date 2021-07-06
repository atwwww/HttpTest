package Handler;

import entity.Response;
import entity.Resquest;

import java.io.IOException;
import java.io.InputStream;

/**
 * 响应构建。根据已经构建好的请求实体，构建不同的响应实体
 */

public class ResponseHandler {
    public static Response responseHandler(Resquest resquest) throws IOException{

        int code;
        Response response = new Response();

        if("/index".equals(resquest.getUrl()) || "/".equals(resquest.getUrl())){
            //读对应文件
            String html = readHtml("./index.html");
            //根据文件的读取情况判断响应码
            code = 200;
            response.buildLine(code);
            response.buildHead(html.getBytes().length);
            response.buildHtml(html);
        }else if("/home".equals(resquest.getUrl())){
            //读对应文件
            String html = readHtml("./home.html");
            //根据文件的读取情况判断响应码
            code = 200;
            response.buildLine(code);
            response.buildHead(html.getBytes().length);
            response.buildHtml(html);
        }else{
            //读对应文件
            String html = readHtml("./else.html");
            //根据文件的读取情况判断响应码
            code = 404;
            response.buildLine(code);
            response.buildHead(html.getBytes().length);
            response.buildHtml(html);
        }
        return response;
    }







    //读取html文件内容
    private static String readHtml(String path) throws IOException {
        InputStream resourceAsStream = ResponseHandler.class.getClassLoader().getResourceAsStream(path);
        if(resourceAsStream == null) {
            System.out.println("读取html文件错误...");
            return null;
        }
        StringBuilder str = new StringBuilder();
        byte[] buf = new byte[1024];
        int len;
        while( (len = resourceAsStream.read(buf)) != -1 ){
            str.append(new String(buf,0,len));
        }

        return str.toString();
    }

}
