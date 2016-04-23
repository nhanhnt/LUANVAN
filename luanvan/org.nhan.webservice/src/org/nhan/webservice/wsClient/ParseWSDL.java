package org.nhan.webservice.wsClient;

import javax.wsdl.*;
import javax.wsdl.factory.*;
import javax.wsdl.xml.*;
import javax.xml.namespace.QName;

import javax.xml.stream.*;

import com.ibm.wsdl.*; // JSR-110
import javax.wsdl.extensions.schema.*;
import javax.wsdl.Import ;
import java.util.*;
import java.io.*;
import java.net.*;

/**
 * This class read WSDL file and parse it
 * @author Reza
 *
 */
public class ParseWSDL {
	private WSDLFactory factory ;
	private WSDLReader reader ;
	private Definition def ; 
	private Boolean isSchema;
	public ParseWSDL(){
		
	}
	/**
	 * This is the constructor which is used to initialize parser.
	 * @param wsdlLocation
	 */
	public ParseWSDL(String wsdlLocation){
		try {
			factory = WSDLFactory.newInstance();
			reader = factory.newWSDLReader();
			reader.setFeature("javax.wsdl.verbose", true);
			reader.setFeature("javax.wsdl.importDocuments", true);
			def = reader.readWSDL(null,wsdlLocation);
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
	/**
	 * This method returns the target name space from given WSDL file.
	 * @param wsdlLocation
	 * @return target name space 
	 * @throws Exception
	 */
	public String readTargetNamespace(String wsdlLocation) throws Exception{
		URL url = new URL(wsdlLocation);
		//URLConnection myConn = url.openConnection();
		InputStream in = url.openStream();
		//InputStream in = myConn.getInputStream();
		XMLInputFactory staxFactory = XMLInputFactory.newInstance();
		staxFactory.setProperty(XMLInputFactory.IS_VALIDATING, Boolean.FALSE);
		XMLStreamReader xmlReader = staxFactory.createXMLStreamReader(in);
		String nameSpace= null;
		String elemName = null;
		while (xmlReader.hasNext()) {
		   if (xmlReader.isStartElement()  ) {
			   if (xmlReader.getLocalName().equals("definitions")){
				   elemName = xmlReader.getAttributeValue(null, "targetNamespace");   
				   if (elemName != null)   
				   in.close();
					return elemName;	 
			   }
			  }
		   xmlReader.next();
		}
		in.close();
		return null;
	}
	 
	/**
	 * This method reads Input NameSpace from Given WSDL file and specified Operation Name.
	 * @param wsdlLocation
	 * @param operationName
	 * @return input namespace
	 * @throws Exception
	 */
	public String readInputNameSpace(String wsdlLocation,String operationName) throws Exception{
		URL url = new URL(wsdlLocation);
		//URLConnection myConn = url.openConnection();
		InputStream in = url.openStream();
		//InputStream in = myConn.getInputStream();
		XMLInputFactory staxFactory = XMLInputFactory.newInstance();
		staxFactory.setProperty(XMLInputFactory.IS_VALIDATING, Boolean.FALSE);
		XMLStreamReader xmlReader = staxFactory.createXMLStreamReader(in);
		boolean isOper = false;
		boolean isChild = false;
		String result = null;
		while (xmlReader.hasNext()) {
		  if (xmlReader.isStartElement()  ) {
			   if ( xmlReader.getLocalName().equalsIgnoreCase("operation") )
			   { 
				   if (( (xmlReader.getAttributeValue(null,"name")!=null) &&
						   xmlReader.getAttributeValue(null,"name").equalsIgnoreCase(operationName)))
				   {
					   isOper = true;
				   }
			   }
			   if (xmlReader.getLocalName().equalsIgnoreCase("input") ){
					   if (isOper){
						   isChild = true;
					   }
					   //return xmlReader.getAttributeValue(null,"namespace");
			   }
			   if (isOper && isChild){
				   if (xmlReader.getLocalName().equalsIgnoreCase("body")){
					   result = xmlReader.getAttributeValue(null,"namespace");
					   isOper = false; //because required one founded
					   isChild = false; //because required one founded 
				   }
			   }
		   }
		   xmlReader.next() ;
		}
		return result;
	}
	/**
	 * This method read Name attribute for accosiated Port element from a given Service Name
	 * It defines private because it used in readAllServices method only
	 * THIS METHOD FUNCTION EXACTLY AS readAllports BUT IMPLEMENTED VIA STAX.
	 * @param wsdlLoc
	 * @param serviceName
	 * @return array of String contains ports
	 * @throws Exception
	 */
	private String[] readPortNAMESFromServiceName(String wsdlLoc,String serviceName) throws Exception{
		String returnPorts = "";
		URL url = new URL(wsdlLoc);
		InputStream in = url.openStream();
		XMLInputFactory staxFactory = XMLInputFactory.newInstance();
        staxFactory.setProperty(XMLInputFactory.IS_VALIDATING, Boolean.FALSE);
        XMLStreamReader xmlReader = staxFactory.createXMLStreamReader(in);
        String port = null;
        Boolean isService = true;
        while (xmlReader.hasNext()){
           if (xmlReader.isStartElement()  )
     	   {
     		   if ( xmlReader.getLocalName().equalsIgnoreCase("services") && 
     			  xmlReader.getAttributeValue(0).equals(serviceName)  ) { //0=Attribute name
     			  isService = true;   
     		   }
     		   if (xmlReader.getLocalName().equalsIgnoreCase("port") && isService){
     			  //System.out.println("[wsClient.ParseWSDL.readPortNamefromServiceName] This is Port Name:"+ xmlReader.getAttributeValue(0));
     			  returnPorts = returnPorts +","+xmlReader.getAttributeValue(0); //0=Attribute name
     		   }
     	   }
           if (xmlReader.isEndElement()){
        	   // This means we reach the end of the services and should reset boolean value
        	   if (xmlReader.getLocalName().equalsIgnoreCase("services")){ 
        		   isService = false; 
        	   }
           }
     	   xmlReader.next();
        }
        returnPorts = returnPorts.substring(1, returnPorts.length());
        String[] returnFinal = returnPorts.split(",");
		return returnFinal;
	}
	
	/**  
	 * WSDL file provided as argument and all available Services returend. 
	 * @param wsdlLocation
	 * @return
	 * @throws Exception
	 */
	public String[] readAllServices(String wsdlLocation) throws Exception
	{
		Map allServices = def.getAllServices();
		Iterator it =  allServices.entrySet().iterator();
		String[] allServiceName = new String[allServices.size()];
		// iterate trough Each Service in WSDL file 
		for (int i=0; i<allServices.size(); i++) 
		{
//------------- Following line written to get entry type of hashmap-------------//
			Object curr = it.next();
			Map.Entry entry = (Map.Entry)curr ;
			Object key = entry.getKey(); //javax.xml.namespace.QName
			Object value = entry.getValue(); //com.ibm.wsdl.PortTypeImpl 
//			System.out.println("HashMap key Type is:" +key.getClass().toString()+"------------"+key.toString() );
//			System.out.println("HashMap value Type is:" +value.getClass().toString()+"------------"+value.toString() );
//------------------------------------------------------------------------------//			
			ServiceImpl currService =(ServiceImpl)allServices.get(key);
			String currServName = currService.getQName().getLocalPart();
			allServiceName[i] = currServName;
		}
		return allServiceName;
	}
	/**
	 * This method reads Name attribute for accosiated Port element from a given Service Name
	 * It defines private because it used in readAllServices method only.
	 * @param serviceName
	 * @param wsdlLOC
	 * @return Array of available ports
	 * @throws Exception
	 */
	public String[] readAllports(String serviceName, String wsdlLOC) throws Exception {
		String tNS = readTargetNamespace(wsdlLOC);
		Service service = def.getService(new QName(tNS,serviceName) );
		Map allPorts = service.getPorts();
		Iterator it = allPorts.entrySet().iterator();
		String ports = "";
		while (it.hasNext()){
			Object curr = it.next();
			Map.Entry entry = (Map.Entry)curr ;
			Object key = entry.getKey(); //java.lang.String
			Object value = entry.getValue(); //com.ibm.wsdl.PortImpl 
			ports = ports +","+key;
		}
		ports = ports.substring(1,ports.length());
		String[] portsFinal = ports.split(",");
		return portsFinal;
	}
	/** 
	 * Give a Service Name and Port name as Argument then return all associated operations.
	 * @param currServName
	 * @param currPort
	 * @return Array of String contain Operations
	 * @throws Exception
	 */
	public String[] readOperations(String currServName,String currPortName,String wsdlLoc) throws Exception{
		Service service = def.getService(new QName(readTargetNamespace(wsdlLoc),currServName) );
		Port port = service.getPort(currPortName);
		//System.out.println("[wsClient.ParseWSDL.readoperations] This number of port(s) has been readen for given services:"+currPortName.length());
		Binding binding = port.getBinding();
		PortType portType = binding.getPortType();
		List operations = portType.getOperations();
		Iterator it = operations.iterator();
		String allopers=null;
		while (it.hasNext()){
			Operation oper = (Operation)it.next();
			//System.out.println("[wsClient.ParseWSDL.readoperations] Operation: "+oper.getName());
			allopers=oper.getName()+","+allopers;
		}
		allopers = allopers.substring(0,allopers.length()-5); // to remove ",null" from end
		String[] results = allopers.split(",");
		return results;
	}
	/**
	 * This method reads all associated Inputs from given parameters.
	 * @param currServName
	 * @param currPortName
	 * @param wsdlLoc
	 * @param operNam
	 * @return String which contain Inputparameters for given operation.
	 * @throws Exception
	 */
	public String readInputParam(String currServName,String currPortName,String wsdlLoc,String operNam) throws Exception{
		
		Service service = def.getService(new QName(readTargetNamespace(wsdlLoc),currServName) );
		Port port = service.getPort(currPortName);
		//System.out.println("[wsClient.ParseWSDL.readoperations] This number of port(s) has been readen for given services:"+currPortName.length());
		Binding binding = port.getBinding();
		PortType portType = binding.getPortType();
		List operations = portType.getOperations();
		Iterator it = operations.iterator();
		Operation needOper = null; 
		while (it.hasNext()){
			Operation oper = (Operation)it.next();
			if (oper.getName().equalsIgnoreCase(operNam)){
				needOper = oper;
			}
		}
		List order = needOper.getParameterOrdering(); //If parameters are in Order
		String part = "";
		
		if (order != null){ // There is order
			//System.out.println("THERE IS ORDER REQUIRED");
			Input in = needOper.getInput();
			Message msg = in.getMessage();
			Map parts = msg.getParts();
			
			for (int i=0; i<order.size(); i++){
				Iterator it2 =  parts.entrySet().iterator(); 
				while (it2.hasNext()) {  // for each MESSAGE PART
					Object curr = it2.next();
					Map.Entry entry = (Map.Entry)curr ;
					Object key = entry.getKey(); 
					Object value = entry.getValue();  
//					System.out.println(" KEY is: "+key); //java.lang.String
//					System.out.println(" VALUE is: "+value); //com.ibm.wsdl.PartImpl
					PartImpl partimp = (PartImpl)parts.get(key.toString());
					System.out.println("[wsClient.ParseWSDL.readInput]PartName is: "+partimp.getName()); //parameters
					if (partimp.getElementName() != null) { // Contain schema
						System.out.println("SCHEMA");
						//name, type, element
						//List nativeAtt = partimp.getNativeAttributeNames();
						System.out.println("These arguments contain in Schema and not supported in this version\n"+
											"you can read WSDL and associated SOAP schema manually and create your\n"+
											"SOAP request because there is no automatic support for this");
					}
					else { // Standard data type (Null means it should not been readen from XSD file)
						if (partimp.getName().equals(order.get(i))){
							part = part+
							"<"+partimp.getName()+" xsi:type=\"xs:"+partimp.getTypeName().getLocalPart()+"\">"+"-----"+"</"+partimp.getName()+">";
							//System.out.println("cccccc: "+part);
						}
					}
				}
			} 
		}
		else { // There is No order
			//System.out.println("THERE IS NO NEED FOR ORDERING");
			Input in = needOper.getInput();
			Message msg = in.getMessage();
			Map parts = msg.getParts();
			Iterator it2 =  parts.entrySet().iterator(); 
			while (it2.hasNext()) {  // for each MESSAGE PART
				Object curr = it2.next();
				Map.Entry entry = (Map.Entry)curr ;
				Object key = entry.getKey(); 
				Object value = entry.getValue();  
//				System.out.println(" KEY is: "+key); //java.lang.String
//				System.out.println(" VALUE is: "+value); //com.ibm.wsdl.PartImpl
				PartImpl partimp = (PartImpl)parts.get(key.toString());
				//System.out.println("[wsClient.ParseWSDL.readInput]PartName is: "+partimp.getName()); //parameters
				if (partimp.getElementName() != null) { // Contain schema
					System.out.println("SCHEMA");
					//name, type, element
					//List nativeAtt = partimp.getNativeAttributeNames();
					System.out.println("These arguments contain in Schema and not supported in this version\n"+
										"you can read WSDL and associated SOAP schema manually and create your\n"+
										"SOAP request because there is no automatic support for this");
					return null;
				}
				else { // Standard data type (Null means it should not been readen from XSD file)
					part = part+
					"<"+partimp.getName()+" xsi:type=\"xs:"+partimp.getTypeName().getLocalPart()+"\">"+"-----"+"</"+partimp.getName()+">";
					//System.out.println("[wsClient.ParseWSDL.readInput] use this for SOAP req: \n"+part);
				}
			}
		}
		return part;
	}
	
	/**
	 * This method reads inputs for given operation but its usage is for creating piple line 
	 * @param currServName
	 * @param currPortName
	 * @param wsdlLoc
	 * @param operNam
	 * @return
	 * @throws Exception
	 */
	public ArrayList readinputs4Pipeline(String currServName,String currPortName,
									    String wsdlLoc,String operNam) throws Exception{
			
			Service service = def.getService(new QName(readTargetNamespace(wsdlLoc),currServName) );
			Port port = service.getPort(currPortName);
			//System.out.println("[wsClient.ParseWSDL.readoperations] This number of port(s) has been readen for given services:"+currPortName.length());
			Binding binding = port.getBinding();
			PortType portType = binding.getPortType();
			List operations = portType.getOperations();
			Iterator it = operations.iterator();
			Operation needOper = null;
			while (it.hasNext()){
				Operation oper = (Operation)it.next();
				if (oper.getName().equalsIgnoreCase(operNam)){
					needOper = oper;
				}
			}
			Input in = needOper.getInput();
			Message msg = in.getMessage();
			Map parts = msg.getParts();
			Iterator it2 =  parts.entrySet().iterator(); 
			ArrayList part = new ArrayList();
			while (it2.hasNext()) {  // for each MESSAGE PART
				Object curr = it2.next();
				Map.Entry entry = (Map.Entry)curr ;
				Object key = entry.getKey(); 
				Object value = entry.getValue();  
				PartImpl partimp = (PartImpl)parts.get(key.toString());
				if (partimp.getElementName() != null) { // Contain schema
					System.out.println("SCHEMA");
					//name, type, element
					//List nativeAtt = partimp.getNativeAttributeNames();
					System.out.println("These arguments contain in Schema and not supported in this version\n"+
										"you can read WSDL and associated SOAP schema manually and create your\n"+
										"SOAP request because there is no automatic support for this");
					return null;
				}
				else { // Standard data type (Null means it should not been readen from XSD file)
					part.add(partimp.getName());
				}
			}
			return part;
	}
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		ParseWSDL myParse = new ParseWSDL("http://isokont.isolab.at/Account.wsdl");
		myParse.readInputParam("AccountService","Account", "http://isokont.isolab.at/Account.wsdl","check");
		//String allParts = myParse.readInputParam( "CurrencyExchangeService","CurrencyExchangePort","http://www.xmethods.net/sd/CurrencyExchangeService.wsdl","getRate");		
//		System.out.println(myParse.readInputNameSpace("http://isokont.isolab.at/Account.wsdl",
//									"check"));
//		System.out.println(myParse.readInputNameSpace("
//		ParseWSDL myParse = new ParseWSDL("http://localhost:8080/TestENDP/TestENDPService?WSDL");
//		myParse.readInputParam("TestENDPService", "TestENDPPort", "http://localhost:8080/TestENDP/TestENDPService?WSDL", "add");
	}
	
	public Boolean getIsSchema() {
		return isSchema;
	}

	public void setIsSchema(Boolean isSchema) {
		this.isSchema = isSchema;
	}
	
}
