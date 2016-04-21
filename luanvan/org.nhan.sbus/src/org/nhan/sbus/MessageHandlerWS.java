package org.nhan.sbus;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

public class MessageHandlerWS {
	private static final String TAG_PARAMS = "parameters";

	private static final String TAG_PARAM = "param";

	/**
	 * <p>
	 * Initializes the service.
	 */
	public MessageHandlerWS() {
		// Nothing to do
	}

	/**
	 * <p>
	 * Invokes the requested operation of the service and returns its response.
	 * A null response may be returned if the return type of the service is
	 * void.
	 * 
	 * @param service
	 *            Service name
	 * @param operation
	 *            Operation name
	 * @param params
	 *            The parameters for the operation as xml tree. Each parameter
	 *            should be enclosed in <em>param</em> element and finally
	 *            wrapped inside a root element, preferably <em>parameters</em>.
	 *            <p>
	 *            For example:<br/> <parameters><param>value-goes-here</param></parameters>
	 * 
	 * <p>
	 * Note: Integer or other primitive values are automatically converted to
	 * their respective types.
	 */
	public String invoke(String service, String operation, String params)
			throws Exception {
		Object res = MessageHandler.getDefault().invoke(service, operation,
				parseParams(params));
		if (res != null)
			return res.toString();
		return "";

	}

	/**
	 * Convert the input parameters in XML to string array form which will be
	 * needed for service invocation.
	 */
	protected static Object[] parseParams(String xml) throws DocumentException {
		Document doc = DocumentHelper.parseText(xml);
		Element root = doc.getRootElement();

		List list = root.elements(TAG_PARAM);
		Object[] params = new Object[list.size()];
		for (int i = 0; i < params.length; i++) {
			Node param = (Node) list.get(i);
			String contents = param.asXML();
			int endingIndex = contents.length() - 8;
			params[i] = contents.substring(7, endingIndex);
		}
		return params;
	}

	/**
	 * Convert the parameters in string array form to their XML representation
	 */
	public static String prepareParams(String... params) {
		Element root = DocumentHelper.createElement(TAG_PARAMS);

		// add individual parameters
		for (String param : params) {
			Element param0 = DocumentHelper.createElement(TAG_PARAM);
			param0.add(DocumentHelper.createText(param));
			root.add(param0);
		}
		return root.asXML();
	}
}
