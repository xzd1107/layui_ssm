package service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class myservice {
	 public String say(String name){
	        return "Hello " + name + " , this is SayHelloService !" ;
	    }

	    public static void main(String[] args) {
	        //第一个参数是访问时的url，9091是任意一个不占用的端口
	        Endpoint.publish("http://localhost:9091/Service/myservice", new myservice());
	        System.out.println("service success !");
	    }
}
