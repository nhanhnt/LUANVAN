package com.shop.test;

import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;
import com.shop.services.DmchaStub;
import com.shop.services.DmchaStub.Getdmcha;
import com.shop.services.DmconStub;
import com.shop.services.DmconStub.Getdmcon;
import com.shop.services.DmconStub.GetdmconResponse;
import com.shop.services.HelloworldStub;
import com.shop.services.HelloworldStub.Helo;
import com.shop.services.HelloworldStub.HeloResponse;

public class check {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		
		try {
			DmchaStub dmcha=new DmchaStub();
			Getdmcha cha=new Getdmcha();
			for (int i = 0; i < dmcha.getdmcha(new Getdmcha()).get_return().length; i++) {
				System.out.println(dmcha.getdmcha(new Getdmcha()).get_return()[i].getTendanhmuc());
			}
			
			System.out.println(dmcha.getdmcha(new Getdmcha()).get_return().length);
			
			HelloworldStub helo=new HelloworldStub();
			Helo h=new Helo();
			h.setParam("123");
			HeloResponse res=helo.helo(h);
			System.out.println(res.get_return().toString());
			
			DmconStub dmconstub=new DmconStub();
			Getdmcon dmcon=new Getdmcon();
			dmcon.setDmcha(Integer.parseInt("2"));
			GetdmconResponse redmcon=dmconstub.getdmcon(dmcon);
			// ở đây in ra được list gồm 3 phần tử, nhưng muốn lấy tên của nó ra thì thế nào
			
			System.out.println(redmcon.get_return().length);
			for (int i = 0; i < redmcon.get_return().length; i++) {
				System.out.println(redmcon.get_return()[i].getTendanhmuc());
			}
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
