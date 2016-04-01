package org.example;

import org.mortbay.jetty.Server;
import org.nhan.entity.Number;
import org.nhan.services.Call;

public class check {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Number num=new Number();
		num.setA(5.6);
		num.setB(4.5);
		Call client=new Call("org.example.arithmatics");
		Number result=(Number)client.invoke("multiply",new Double(4.5),new Double(4.7));
		
		
		//test Jetty
//		Server server =new Server(8080);
//		server.start();
//		server.join();
		

	}

}
