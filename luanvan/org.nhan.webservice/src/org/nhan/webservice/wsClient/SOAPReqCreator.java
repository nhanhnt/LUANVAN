package org.nhan.webservice.wsClient;

import java.io.*;
import javax.xml.soap.*;
import javax.xml.namespace.QName;
import java.util.*;
import java.net.URL;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;

import org.nhan.webservice.general.StateHolder;

/**
 * This class is used for SOAP message Administration.
 * @author Reza
 *
 */
public class SOAPReqCreator {
    
	/**
	 * Traget name-space of given WSDL file stored here. 
	 */
	private String targetNameSpace = null;
	
	/**
	 * This method create a SOAP request message from given parameters.
	 * @param targetNS
	 * @param operationName
	 * @param inputParam
	 * @param inputNS
	 * @return SOAPmessage in String format
	 * @throws Exception
	 */
	public String makeSOAPMessage(String targetNS,String operationName,String inputParam,String inputNS) throws Exception {
		String constdata = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" +
				"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"" + 
				" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"" + 
				" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""+
				" xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\"" +
				" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\""+
 				" xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"" + 
 				" xmlns:wsdlsoap=\"http://schemas.xmlsoap.org/wsdl/soap/\">"; 
				//" xmlns:tns=\"" +targetNS+ "\">" ; 
		String body ="<SOAP-ENV:Body>" +
					 "<mns:"+operationName+" xmlns:mns=\""+ inputNS +"\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"+			 
					 inputParam +
					 "</mns:"+operationName+">"+
					 "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
		String result = constdata+body;
		return result;
	}
	
	/**
	 * This method take SOAP message as String and resturn SOAP Message object.
	 * @param msg
	 * @return
	 */
	public SOAPMessage makeSOAPmsgFromString(String msg) {
		try {
			MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage message = factory.createMessage();
            message.getSOAPPart().setContent((Source)new StreamSource(new StringReader(msg)));
            message.saveChanges();
//			SOAPPart soapPart = message.getSOAPPart();
//			SOAPEnvelope soapEnv = soapPart.getEnvelope();
//			SOAPBody body = soapEnv.getBody();
//			message.getSOAPPart().getEnvelope().getBody().addTextNode(
//			     "<http://service4Test/:add>" +
//					"<arg0>1</arg0>"+
//					"<arg1>2</arg1>"+
//				 "</http://service4Test/:add>");
//			System.out.println(".......Message:"+message.getSOAPPart().getEnvelope().getBody());			
			return message;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * This method uses for test purposes.
	 * @return
	 */
	public SOAPMessage makeSOAPmsgFromString_test() {
		try {
			MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage message = factory.createMessage();
            message.getSOAPPart().setContent((Source)new StreamSource(new StringReader(
               "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" +
               "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
               "xmlns:tns=\"http://www.xmethods.net/sd/TemperatureService.wsdl\" " +
               "xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\" " +
               "xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\" " +
               "xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" " +
               "xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
               "<SOAP-ENV:Body>" +
               "<mns:getTemp xmlns:mns=\"urn:xmethods-Temperature\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
               "<zipcode xsi:type=\"xsd:string\">23443</zipcode>" +
               "</mns:getTemp>" +
               "</SOAP-ENV:Body>" +
               "</SOAP-ENV:Envelope>" )));

            message.saveChanges();
			
			//System.out.println(".......Message:"+message.getSOAPPart().getEnvelope().getBody());			
			return message;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * This method uses for test purposes.
	 * @param args
	 */
	public static void main(String args[]){
		SOAPReqCreator soapReq = new SOAPReqCreator();
		soapReq.makeSOAPmsgFromString_test();
	}
	
}
