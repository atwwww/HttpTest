package entity;

/**
 * 响应实体，主要是构建响应信息，为响应处理器使用方便
 */

public class Response {

    private final String CRLF = "\r\n";

    //响应行
    private StringBuilder responseLine;

    //响应头
    private StringBuilder responseHead;

    //响应体
    private String html;

    //构建响应行
    public void buildLine(int code){
        responseLine = new StringBuilder();
        responseLine.append("HTTP/1.1 ").append(code).append(" ");

        switch (code){
            case 200:
                responseLine.append("OK");
                break;
            case 404:
                responseLine.append("NOT FOUND");
                break;
            case 505:
                responseLine.append("SEVER ERROR");
                break;
        }
        responseLine.append(CRLF);
    }

    public void buildHead(int lenth){
        responseHead = new StringBuilder();
        responseHead.append("content-type: text/html;charset=utf-8").append(CRLF)
                .append("contentlength: ").append(lenth).append(CRLF)
                .append(CRLF);
    }

    public void buildHtml(String content){
        html = content;
    }

    public String getResponseLine() {
        return responseLine.toString();
    }

    public String getResponseHead() {
        return responseHead.toString();
    }

    public String getHtml() {
        return html;
    }
}
