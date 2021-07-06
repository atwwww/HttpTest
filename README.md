# HttpTest
Some practice of Http

## 1.Structure
* sources------html files  
else.html  
home.html  
index.html

* src------src Java file  
    * entity  
    Response.java-- store the http  request  
    Request.java-- store the http response
    * Handler  
    RequestHandler.java-- format the requset  
    ResponseHandler.java-- format the response  
    * threadtools  
    Task.java-- use handler to deal with a accept
    * Main
    BootStrap.java-- listen, create thread to deal with the raw http request

## 2.Code implementation
* create a socket to liten the port you will visit
* when a visit is reaching, start a thread to deal with it, at the same time, main thread listen new accept
* use some self-defined entity and method to format the http request and response

## 3.Start

* git clone https://github.com/atwwww/HttpTest.git  
* open this project in IntelliJ(for simpler, you can open it in any other idea)
* type "127.0.0.1:9999/index" or  
"127.0.0.1:9999/home" or  
"127.0.0.1:9999" or
"127.0.0.1:9999/fajfdaljf"(a random page you like)

the browser will display different content as you type different pages