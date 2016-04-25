package org.nhan.pipeline;

import java.util.Iterator;
import org.dom4j.Element;
import org.dom4j.Node;
import org.nhan.sbus.Call;

public class CallElement {

	/**
	 * name of service to be invoked
	 */
	String serviceName = null;

	/**
	 * operation name to be called
	 */
	String operationName = null;

	/**
	 * element name that the call results will be wrapped in
	 */
	String elementID = null;

	/**
	 * Call return type
	 */
	String returnType = null;

	/**
	 * call parameters as an object array
	 */
	Object[] parameters = null;

	/**
	 * reference to the pipeline containing this call
	 */
	Pipeline pipe = null;

	public String getOperationName() {
		return operationName;
	}

	/**
	 * sets the operation name
	 * 
	 * @param operationName
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	/**
	 * getter method for the call's return type
	 * 
	 * @return calls's return type
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * setter method for the call's return type
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	/**
	 * getter method for the service name
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * setter method for the service name
	 * 
	 * @param serviceName
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * Constructor to create a new callElement from the given XML element which
	 * is part of the given pipeline
	 * 
	 * @param element
	 * @param thePipe
	 */
	public CallElement(Element element, Pipeline thePipe) {
		setPipe(thePipe);
		setElementID(element.attributeValue("id"));
		setServiceName(element.attributeValue("service"));
		setOperationName(element.attributeValue("operation"));
		setReturnType(element.attributeValue("returns"));
		processParameters(element);
	}

	/**
	 * Retrieve parameters from given XML element and makes a parameter array
	 * out of that.
	 * 
	 * @param element
	 */
	private void processParameters(Element element) {
		parameters = new Object[element.elements().size()];
		int ind = 0;
		for (Iterator i = element.elementIterator("parameter"); i.hasNext();) {
			Element param = (Element) i.next();
			String type = param.attributeValue("type");
			String paramValue = "";
			if (param.hasMixedContent()) {
				if (param.elements().size() > 0) {
					Element paramNode = (Element) param.elements().get(0);
					CallElement subCall = new CallElement(paramNode,
							getParentPipe());
					paramValue = subCall.invoke();
				} else {
					// here we will deal with a CDATA node
					for (int j = 0, size = param.nodeCount(); j < size; j++) {
						Node node = param.node(j);
						if (node.getNodeType() == 4) // CDATA part
							paramValue += node.getText();
						else
							paramValue += parseParamText(node.getText());
					}

				}
			} else {
				paramValue = parseParamText(param.getText());
			}
			parameters[ind++] = Util.getJavaObject(type, paramValue);
		}

	}

	/**
	 * Parse the parameter values and replace the variable parameters with th
	 * pipeline parameters. If the parameter is an XPATH parameter then the data
	 * will be extracted from the previous pipeline results
	 * 
	 * @param theParam
	 * @return clear parameter content
	 */
	public String parseParamText(String theParam) {
		String paramValue = "";
		if (theParam.indexOf("{") >= 0) {
			if (theParam.indexOf("xpath:") > 0) {
				int start = theParam.indexOf("xpath:");
				int end = theParam.indexOf("}");
				paramValue = pipe.runXPathQuery(theParam.substring(start + 6,
						end));
			} else {
				//System.out.println("TheParam : "+theParam);
				int start = theParam.indexOf("{");
				int end = theParam.indexOf("}");
				paramValue = pipe.getParameterValue(theParam.substring(
						start + 1, end));
			}
		} else {
			paramValue = theParam;
		}
		return paramValue;
	}

	public String invoke() {
		System.out.println("invoking : " + serviceName + " ;operation : "
				+ operationName);
//		for (Object parameter : parameters) {
//			System.out.println("\tparameter : " + parameter.toString());
//		}

		Object result = null;

		if (serviceName.equals("org.nhan.pipeline")) {

			if (operationName.indexOf(':') < 0)
				operationName = getParentPipe().getPipeSpace() + ":"
						+ operationName;
			Pipeline subPipe = new Pipeline(operationName);
			subPipe.setParameterValues(parameters);
			result = subPipe.processPipeline();
		} else {
			Call client = new Call(serviceName);
			// System.out.println("Services: " + serviceName + " --- "
			// + operationName);
			if (serviceName.equals("org.nhan.webservice")
					&& operationName.equals("wsCall")) {
				System.out.println("ooooooooooooo0: ");
				Object[] wsparams = new Object[5];
				for (int i = 0; i < 4; i++)
					wsparams[i] = parameters[i];

				String[] paramNames = pipe.getParamArray();
				String merged = "";
				System.out.println("ooooooooooooo1: " + paramNames.length);

				for (int i = 4; i < parameters.length; i++)
					merged += "<" + paramNames[i - 4] + ">" + parameters[i]
							+ "</" + paramNames[i - 4] + ">";

				wsparams[4] = merged;
				try {
					result = client.invoke(operationName, wsparams);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					result = client.invoke(operationName, parameters);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		// System.out.println("Result is:" + result);

		return createNode(result);
	}

	/**
	 * getter method for elementID (the tag name that call results will be
	 * wrapped in)
	 * 
	 * @return elementID
	 */
	public String getElementID() {
		return elementID;
	}

	/**
	 * setter method for elementID
	 * 
	 * @param theID
	 */
	public void setElementID(String theID) {
		this.elementID = theID;
	}

	/**
	 * Wrapes the content in elementID item and returns the XML element as
	 * string
	 * 
	 * @param content
	 * @return the content wrapped in elemntID
	 */
	public String createNode(Object content) {
		// System.out.println("Element : "+ elementID);
		if (null != elementID && elementID.length() > 0) {
			return "<" + elementID + ">" + content + "</" + elementID + ">";
		} else {
			return "" + content;
		}

	}

	/**
	 * @return the pipeline that contains this callElement
	 */
	public Pipeline getParentPipe() {
		return pipe;
	}

	/**
	 * setter method for the pipeline containing this callElement
	 * 
	 * @param thePipe
	 */
	public void setPipe(Pipeline thePipe) {
		this.pipe = thePipe;
	}

}
