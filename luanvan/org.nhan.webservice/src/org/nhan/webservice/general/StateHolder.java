package org.nhan.webservice.general;

public class StateHolder {

	
//	public static String formName[] = new String[5]; // 4 is the number of window in application
//	//0 stay for ReadWSDL_1
//	//1 stay for SelectService_3
//	//2 stay for SelectportType_4
//	//3 stay for Selectoperation_4
//	//4 stay for MesageRequest_5

	private static String targetNameSpace = "";
	private static String inputNameSpace = "";
	private static String chooseWSDL = "";
	private static String chooseServic = "";
	private static String choosePortType = "";
	private static String chooseOperation = "";
	private static String chooseMessage = "";
	private static String chFunction= "";
	
public static String getChFunction() {
		return chFunction;
	}
	public static void setChFunction(String chFunction) {
		StateHolder.chFunction = chFunction;
	}
public static String getChooseMessage() {
		return chooseMessage;
	}
	public static void setChooseMessage(String chooseMessage) {
		StateHolder.chooseMessage = chooseMessage;
	}
	//	public static String formWidgetValue[] = new String[5];
	//0 stay for WSDL Location in ReadWSDL_1
	//1 stay for Selected services in list in SelectService_3
	//2 stay for selected portType in SelectportType_4 form's list
	//3 stay for selected operation
	public static String getChooseOperation() {
		return chooseOperation;
	}
	public static void setChooseOperation(String chooseOperation) {
		StateHolder.chooseOperation = chooseOperation;
	}
	public static String getChoosePortType() {
		return choosePortType;
	}
	public static void setChoosePortType(String choosePortType) {
		StateHolder.choosePortType = choosePortType;
	}
	public static String getChooseServic() {
		return chooseServic;
	}
	public static void setChooseServic(String chooseServic) {
		StateHolder.chooseServic = chooseServic;
	}
	public static String getChooseWSDL() {
		return chooseWSDL;
	}
	public static void setChooseWSDL(String chooseWSDL) {
		StateHolder.chooseWSDL = chooseWSDL;
	}
	public static String getTargetNameSpace() {
		return targetNameSpace;
	}
	public static void setTargetNameSpace(String targetNameSpace) {
		StateHolder.targetNameSpace = targetNameSpace;
	}
	public static String getInputNameSpace() {
		return inputNameSpace;
	}
	public static void setInputNameSpace(String inputNameSpace) {
		StateHolder.inputNameSpace = inputNameSpace;
	}

}
