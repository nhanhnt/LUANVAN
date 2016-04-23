 package org.nhan.webservice.general;

import java.io.*;
import java.util.Scanner;

public class WebServiceRepository {
	
	public void writeInWSDLRep(String wsdl) throws Exception{
		File repFile = new File(org.nhan.webservice.general.Setting.REPOSITORYFILE_LOCATION +
								"\\"+org.nhan.webservice.general.Setting.REPOSITORYFILE_NAME);
		FileWriter write = new FileWriter(repFile,true);
		write.write(wsdl+System.getProperty("line.separator"));
		write.flush();
		write.close();
		write = null;
	}
	public void del4mWSDLRep(String wsdl) throws Exception{
		File repFile = new File(org.nhan.webservice.general.Setting.REPOSITORYFILE_LOCATION+"\\"+org.nhan.webservice.general.Setting.REPOSITORYFILE_NAME);
		File tempFile =  new File(org.nhan.webservice.general.Setting.REPOSITORYFILE_LOCATION+"\\"+"temp.txt");
		FileWriter tmpWrite = new FileWriter(tempFile,true);
		BufferedReader bRead =  new BufferedReader(new FileReader(repFile));
		Scanner scaner = new Scanner(bRead);
		
		while (scaner.hasNext()){
			String tmp = scaner.next();
			if ( !(tmp.equalsIgnoreCase(wsdl))){
				tmpWrite.write(tmp+System.getProperty("line.separator"));
			}
		}
		tmpWrite.flush();
		tmpWrite.close();
		tmpWrite = null;
		bRead.close();
		bRead = null;
		if ( !repFile.delete()){
			System.out.println("Correct here to show file delete Error");
		}
		tempFile.renameTo(new File(org.nhan.webservice.general.Setting.REPOSITORYFILE_LOCATION+"\\"+org.nhan.webservice.general.Setting.REPOSITORYFILE_NAME));	
	}
	/**
	 * This method read content of repository file and return array of string for each line in repository file.
	 * @return array of String which contain WSDL locations
	 * @throws Exception
	 */
	public String[] readAllWSDLs() throws Exception{
		File repFile = new File(org.nhan.webservice.general.Setting.REPOSITORYFILE_LOCATION+"\\"+org.nhan.webservice.general.Setting.REPOSITORYFILE_NAME);
		if (repFile.isFile()){
			BufferedReader bRead =  new BufferedReader(new FileReader(repFile));
			String reads="";
			Scanner scaner = new Scanner(bRead);
			//String token = System.getProperty("line.separator");
			while (scaner.hasNext()){
				reads = reads +","+scaner.next();
			}
			bRead.close();
			//bRead = null;
			repFile = null;
			if (reads.length() > 0){
				reads = reads.substring(1, reads.length());
			}
			String result[] = reads.split(",");
			reads=null;
			return result;
		}
		return null;
	}
}
