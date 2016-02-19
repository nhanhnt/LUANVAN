package com.shop.test;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.axis2.AxisFault;

import com.ftl.util.DateUtil;
import com.shop.services.CityStub;
import com.shop.services.DangkyStub;
import com.shop.services.DmchaStub;
import com.shop.services.DmchaStub.Getdmcha;
import com.shop.services.DmconStub;
import com.shop.services.DmconStub.Getdmcon;
import com.shop.services.DmconStub.GetdmconResponse;
import com.shop.services.HelloworldStub;
import com.shop.services.MuahangStub;
import com.shop.services.HelloworldStub.Helo;
import com.shop.services.HelloworldStub.HeloResponse;
import com.shop.services.Km2CityStub;
import com.shop.services.Km2CityStub.Km2City;
import com.shop.services.Km2CityStub.Km2CityResponse;
import com.shop.services.MuahangStub.Getlistmh;
import com.shop.services.MuahangStub.GetlistmhResponse;
import com.shop.services.MuahangStub.Getlistmh_sum;
import com.shop.services.SanphamStub;
import com.shop.services.SanphamStub.Getsp;
import com.shop.services.SanphamStub.GetspResponse;
import com.shop.services.SanphamctStub;
import com.shop.services.CityStub.Getcity;
import com.shop.services.CityStub.GetcityResponse;
import com.shop.services.DangkyStub.Registry;
import com.shop.services.DangkyStub.RegistryResponse;
import com.shop.services.SanphamctStub.Getspct;
import com.shop.services.SanphamctStub.GetspctResponse;
import com.shop.services.UpdatehoadonStub;
import com.shop.services.UpdatehoadonStub.Capnhathoadon;
import com.shop.services.UpdatehoadonStub.CapnhathoadonResponse;

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
//			String taikhoan="nhanhnt";
//			String email="";
//			String matkhau="";
//			DangkyStub dkstub=new DangkyStub();
//			Registry reg=new Registry();
//			reg.setUsername(taikhoan);
//			reg.setEmail(email);
//			reg.setPassword(matkhau);
//			RegistryResponse responsedk=dkstub.registry(reg);
//			System.out.println(responsedk.get_return());
			
//			MuahangStub muahangstub=new MuahangStub();
//			Getlistmh getlistmh =new Getlistmh();
//			getlistmh.setId_hoadon(14);
//			GetlistmhResponse hres=muahangstub.getlistmh(getlistmh);
//			for (int i = 0; i < hres.get_return().length; i++) {
//				System.out.println(hres.get_return()[i].getId_chitiethoadon());
//				System.out.println(hres.get_return()[i].getId_sanpham());
//				System.out.println(hres.get_return()[i].getTentaikhoan());
//				System.out.println(hres.get_return()[i].getHinhanh());
//				System.out.println(hres.get_return()[i].getTensanpham());
//				System.out.println(hres.get_return()[i].getSoluong());
//				System.out.println(hres.get_return()[i].getDongia());
//				System.out.println(hres.get_return()[i].getGiamgia());
//				System.out.println(hres.get_return()[i].getDiachigiaohang());
//				System.out.println(hres.get_return()[i].getPhuongthucthanhtoan());
//				System.out.println(hres.get_return()[i].getNgaygiaohang());
//				System.out.println(hres.get_return()[i].getTong());
//				
//				
//			}
//			Getlistmh_sum s=new Getlistmh_sum();
//			s.setId_hoadon(14);
//			System.out.println(muahangstub.getlistmh_sum(s).get_return());
//			CityStub citystub=new CityStub();
//			Getcity ct=new Getcity();
//			GetcityResponse ctress=citystub.getcity(ct);
//			for (int i = 0; i < ctress.get_return().length; i++) {
//				System.out.println(ctress.get_return()[i].getCity());			
//			}	
			
//			Km2CityStub kmstub=new Km2CityStub();
//			Km2City km=new Km2City();
//			km.setTp1("TP Huế");
//			km.setTp2("TP Đà Nẵng");
//			Km2CityResponse res=kmstub.km2City(km);
//			System.out.println(res.get_return());
			
//			UpdatehoadonStub upstub=new UpdatehoadonStub();
//			Capnhathoadon capnhat=new Capnhathoadon();
//			capnhat.setId_hoadon(Integer.toString(14));
//			capnhat.setDiachi("93 nguyeen trai");
//			capnhat.setTp("TP Đà nẵng");
//			capnhat.setPhuongthuc("Trả tiền khi nhận hàng");
//			capnhat.setNgaygiao("2016-02-28");
//			capnhat.setPhiship(Integer.toString(12000));
//			CapnhathoadonResponse res=upstub.capnhathoadon(capnhat);
//			System.out.println(res.get_return());
			
			String phiship="";
			Km2CityStub kmstub=new Km2CityStub();
			Km2City km2=new Km2City();
			km2.setTp1("TP Huế");
			km2.setTp2("Thanh Hóa");
			Km2CityResponse kmres=kmstub.km2City(km2);
			phiship=kmres.get_return().toString();
			System.out.println(phiship);
			
			DateFormat dateformat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date=new Date();
			date=DateUtil.addDay(date,3);
			System.out.println(dateformat.format(date));
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
