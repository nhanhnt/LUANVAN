package org.nhan.webservice;

import org.nhan.webservice.wsClient.ExecuteService;
import org.nhan.webservice.wsClient.ParseWSDL;

public class Connect2WS {
	public String wsCall(String wsdlLoc, String serviceName, String portName,
			String operName, String inputs)// inputs as XML
	{
		String result = null;
		try {
			System.out.println("[Connect2WS.wsCall]-------> Service Start");
			ParseWSDL parser = new ParseWSDL(wsdlLoc);
			String targetNS = parser.readTargetNamespace(wsdlLoc);
			String inputNS = parser.readInputNameSpace(wsdlLoc, operName);
			ExecuteService exec = new ExecuteService();
			System.out
					.println("[Connect2WS.wsCall]----> Start Calling Service");
			result = exec.callSynch(wsdlLoc, targetNS, serviceName, portName,
					operName, inputs, inputNS);
			System.out.println("SOAP Response is:" + result);
			System.out.println("[Connect2WS.wsCall]<---- Service Stop");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
