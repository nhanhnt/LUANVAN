package org.nhan.webservice.wsClient;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.soap.*;



import org.nhan.webservice.general.*;
import org.nhan.webservice.wsClient.ParseWSDL;

import com.sun.xml.messaging.saaj.util.ByteOutputStream;
import com.sun.xml.ws.encoding.xml.XMLMessage.XMLSource;

import java.util.*;
import java.io.*;

/**
 * This class is used for WebService execution (Here connection to webservice established and wsClient have been runned)
 * @author Reza
 *
 */
public class ExecuteService {

	/**
	 * This method has same functionality as callSynch but it used for Asynchronous 
	 * web service is not implement for this version.
	 * @param wsdlPlace
	 * @param tNS
	 * @param serviceNam
	 * @param portNam
	 * @param operNam
	 * @param inputParams
	 * @param inNS
	 * @return
	 * @throws Exception
	 */
	public void callAsynch(String wsdlPlace,String tNS,String serviceNam
		    , String portNam, String operNam,String inputParams,String inNS) throws Exception {

		
	}
	/**
	 * This method use for creating SOAP message via given parameter and send SOAP Request 
	 * message to WebService then after execution return SOAP response in String.
	 * @param wsdlPlace
	 * @param tNS
	 * @param serviceNam
	 * @param portNam
	 * @param operNam
	 * @param inputParams
	 * @param inNS
	 * @return
	 * @throws Exception
	 */
	public String callSynch(String wsdlPlace,String tNS,String serviceNam
							, String portNam, String operNam,String inputParams,String inNS) throws Exception {
		URL wsdlLocation = new URL(wsdlPlace);
		QName serviceName = new QName(tNS,serviceNam);
		QName portName = new QName( portNam);
		Dispatch<SOAPMessage> disp = null;
		Service myService = Service.create(wsdlLocation,serviceName); // Creating services from qualified name
		Iterator<QName> itPort = myService.getPorts();
		while (itPort.hasNext()){
			QName port = itPort.next();
			if (port.getLocalPart().equalsIgnoreCase(portName.toString()) ) {
				QName port2 = port;
				disp = myService.createDispatch(port2, SOAPMessage.class, Service.Mode.MESSAGE);
			}
		}
		SOAPReqCreator csoapReq = new SOAPReqCreator();
		String soapStr= csoapReq.makeSOAPMessage(tNS, operNam,inputParams,inNS) ;
		SOAPMessage soapReq = csoapReq.makeSOAPmsgFromString(soapStr);
		SOAPMessage response = disp.invoke(soapReq);
		ByteOutputStream  byteOut = new ByteOutputStream();
		response.writeTo(byteOut);
		String respInStr = byteOut.toString();
		
		return respInStr;
	}
	/**
	 * Another callSynch method with same functionality like other one with same name
	 * But this one get SOAP Request message as input and return String as response.
	 * @param SOAPReq
	 * @return
	 * @throws Exception
	 */
	public String callSynch(String SOAPReq) throws Exception {
		URL wsdlLocation = new URL(org.nhan.webservice.general.StateHolder.getChooseWSDL());
		//QName serviceName = new QName(StateHolder.getTargetNameSpace(),StateHolder.getChooseServic());
		QName serviceName = new QName(StateHolder.getChooseServic());
		QName portName = new QName(StateHolder.getChoosePortType());
		
		Dispatch<SOAPMessage> disp = null;
		Service myService = Service.create(wsdlLocation,serviceName); // Creating services from qualified name
		Iterator<QName> itPort = myService.getPorts();
		while (itPort.hasNext()) {
			QName port = itPort.next();
			if (port.getLocalPart().equalsIgnoreCase(portName.toString()) ){
				QName port2 = port;
				disp = myService.createDispatch(port2, SOAPMessage.class, Service.Mode.MESSAGE);
			}
		}
		SOAPReqCreator csoapReq = new SOAPReqCreator();
		System.out.println("[wsClient.ExecuteService.callSynch] " +
				   "portName is: "+portName.toString()+" ServiceName is:"+serviceName.toString());
		SOAPMessage soapReq= csoapReq.makeSOAPmsgFromString(SOAPReq) ;
		//SOAPMessage soapReq = csoapReq.makeSOAPmsgFromString(soapStr);
		SOAPMessage response = disp.invoke(soapReq);
		ByteOutputStream myOut = new ByteOutputStream();
		response.writeTo(myOut);
		String result = new String(myOut.toString());
		return result;
	}
	/**
	 * This is used for developement test 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ExecuteService myWSDL = new ExecuteService();
		myWSDL.execute();
	}
	
	/**
	 * This method used for reading parameters from State Holder, creating SOAP message via 
	 * that parameter and executing Web service with created message.
	 * @throws Exception
	 */
	public void execute() throws Exception {
		ParseWSDL parser = new ParseWSDL(org.nhan.webservice.general.StateHolder.getChooseWSDL());
		String targetNameS = org.nhan.webservice.general.StateHolder.getTargetNameSpace();
		String srvName = org.nhan.webservice.general.StateHolder.getChooseServic();
		String prtName = org.nhan.webservice.general.StateHolder.getChoosePortType();
		String oprName = org.nhan.webservice.general.StateHolder.getChooseOperation();
		String inputs = org.nhan.webservice.general.StateHolder.getChooseMessage();
	    String inNS = org.nhan.webservice.general.StateHolder.getInputNameSpace();
		
		System.out.println(" targetNameSpace: "+targetNameS+" ServiceName: "+srvName+" portName: "+prtName);
		
//		while (itPort.hasNext()) { // For each port in WSDL
//			QName port = itPort.next();
//			}
//		    callSynchDISPATCH("http://www.xmethods.net/sd/CurrencyExchangeService.wsdl"
//					 ,"http://www.xmethods.net/sd/CurrencyExchangeService.wsdl"
//					 ,"CurrencyExchangeService");
//		 http://isokont.isolab.at/Account.wsdl		
		String result =	callSynch(org.nhan.webservice.general.StateHolder.getChooseWSDL()
								, targetNameS, srvName, prtName, oprName
								, inputs, inNS);
		System.out.println("[wsClient.ExecuteService.execute]"+result);
	}
}

