package service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class myservice {
	 public String say(String name){
	        return "Hello " + name + " , this is SayHelloService !" ;
	    }

	    public static void main(String[] args) {
	        //��һ�������Ƿ���ʱ��url��9091������һ����ռ�õĶ˿�
	        Endpoint.publish("http://localhost:9091/Service/myservice", new myservice());
	        System.out.println("service success !");
	    }
}
