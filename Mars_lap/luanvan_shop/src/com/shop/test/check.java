package com.shop.test;

import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

import com.shop.services.DangkyStub;
import com.shop.services.DmchaStub;
import com.shop.services.DmchaStub.Getdmcha;
import com.shop.services.DmconStub;
import com.shop.services.DmconStub.Getdmcon;
import com.shop.services.DmconStub.GetdmconResponse;
import com.shop.services.HelloworldStub;
import com.shop.services.HelloworldStub.Helo;
import com.shop.services.HelloworldStub.HeloResponse;
import com.shop.services.SanphamStub;
import com.shop.services.SanphamStub.Getsp;
import com.shop.services.SanphamStub.GetspResponse;
import com.shop.services.SanphamctStub;
import com.shop.services.DangkyStub.Registry;
import com.shop.services.DangkyStub.RegistryResponse;
import com.shop.services.SanphamctStub.Getspct;
import com.shop.services.SanphamctStub.GetspctResponse;

public class check {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		
		try {
//			DmchaStub dmcha=new DmchaStub();
//			Getdmcha cha=new Getdmcha();
//			for (int i = 0; i < dmcha.getdmcha(new Getdmcha()).get_return().length; i++) {
//				System.out.println(dmcha.getdmcha(new Getdmcha()).get_return()[i].getTendanhmuc());
//			}
//			
//			System.out.println(dmcha.getdmcha(new Getdmcha()).get_return().length);
//			
//			HelloworldStub helo=new HelloworldStub();
//			Helo h=new Helo();
//			h.setParam("123");
//			HeloResponse res=helo.helo(h);
//			System.out.println(res.get_return().toString());
//			
//			DmconStub dmconstub=new DmconStub();
//			Getdmcon dmcon=new Getdmcon();
//			dmcon.setDmcha(Integer.parseInt("2"));
//			GetdmconResponse redmcon=dmconstub.getdmcon(dmcon);
//			// ở đây in ra được list gồm 3 phần tử, nhưng muốn lấy tên của nó ra thì thế nào
//			
//			System.out.println(redmcon.get_return().length);
//			for (int i = 0; i < redmcon.get_return().length; i++) {
//				System.out.println(redmcon.get_return()[i].getTendanhmuc());
//			}
			
			
//			SanphamStub spstub=new SanphamStub();
//			Getsp sp=new Getsp();
//			sp.setDm(Integer.parseInt("12"));
//			GetspResponse ress=spstub.getsp(sp);
//						
//			System.out.println(ress.get_return().length);
//			for (int i = 0; i < ress.get_return().length; i++) {
//				System.out.println(ress.get_return()[i].getTensanpham());
//			}
//			SanphamctStub spstub=new SanphamctStub();
//			Getspct sp=new Getspct();
//			sp.setId_sp(Integer.parseInt("12"));
//			GetspctResponse ress=spstub.getspct(sp);
//						
//			System.out.println(ress.get_return().length);
//			for (int i = 0; i < ress.get_return().length; i++) {
//				System.out.println(ress.get_return()[i].getTensanpham());
//			}
			String taikhoan="nhanhnt";
			String email="";
			String matkhau="";
			DangkyStub dkstub=new DangkyStub();
			Registry reg=new Registry();
			reg.setUsername(taikhoan);
			reg.setEmail(email);
			reg.setPassword(matkhau);
			RegistryResponse responsedk=dkstub.registry(reg);
			System.out.println(responsedk.get_return());
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
