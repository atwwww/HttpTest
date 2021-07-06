package entity;

import java.util.Map;

/**
 * 请求实体，主要构建客户端请求内容，方便服务端提取客户端请求内容，根据需求回应
 */

public class Resquest {

    //请求方式，GET/POST等
    private String requestType;

    //请求的资源
    private String url;

    //请求的协议
    private String protocol;

    //请求头参数放在map中
    private Map<String, String> head;

    //请求体
    private String Body;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Map<String, String> getHead() {
        return head;
    }

    public void setHead(Map<String, String> head) {
        this.head = head;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    @Override
    public String toString() {
        return "Resquest{" +
                "requestType='" + requestType + '\'' +
                ", url='" + url + '\'' +
                ", protocol='" + protocol + '\'' +
                ", head=" + head +
                ", Body='" + Body + '\'' +
                '}';
    }
}
