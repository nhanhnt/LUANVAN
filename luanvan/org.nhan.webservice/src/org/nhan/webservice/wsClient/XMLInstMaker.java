package org.nhan.webservice.wsClient;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.nhan.webservice.general.Setting;

/**
 * This class is not use for this version.
 * @author Reza
 *
 */
public class XMLInstMaker {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private String schemaLocation ="";
	
	/**
	 * This is not used for this Verison
	 * @param wsdlLocation
	 * @throws Exception
	 */
	public void readSchemaFromUrl2File(String wsdlLocation) throws Exception {
		URL url = new URL(wsdlLocation);
		System.out.println("[wsClient.XMLBeansINSTGEN.readSCHEMAURL2File]: "+"......");
		InputStream in = url.openStream();
		XMLInputFactory staxFactory = XMLInputFactory.newInstance();
		staxFactory.setProperty(XMLInputFactory.IS_VALIDATING, Boolean.FALSE);
		XMLStreamReader xmlReader = staxFactory.createXMLStreamReader(in);
		String nameSpace= null;
		String elemName = null;
		while (xmlReader.hasNext()) {
		   if (xmlReader.isStartElement()  ) {
			   if (xmlReader.getLocalName().equals("import") || 
				   xmlReader.getLocalName().equals("xsd:import") ) {
				   System.out.println("Import founded in document");
				   schemaLocation = xmlReader.getAttributeValue(null, "schemaLocation");
				   //TODO: go and create SCHEMA
			   }
			   if (xmlReader.getLocalName().equals("redefine")){
				   schemaLocation = xmlReader.getAttributeValue(null, "schemaLocation");
				   //TODO: go and create SCHEMA
			   }
			   if (xmlReader.getLocalName().equals("include")){
				   schemaLocation = xmlReader.getAttributeValue(null, "schemaLocation");
				   //TODO: go and create SCHEMA
			   }
		   }
		}
		
	}
//	public void runOScmd() throws Exception {
//	    File workDir = new File(Setting.CLIENT_ARTIFACTS_LOC);
//		Process proc = Runtime.getRuntime().exec("cmd /c sxd2inst ",null,workDir);
//		System.out.println("OS commad:"+null);
//		String line =null;	
//		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//		while ((line = stdInput.readLine()) != null) {
//				System.out.println(line);
//			}
//	}
	

}
