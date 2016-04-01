package org.nhan.pipeline;

import java.io.StringReader;
import java.util.Vector;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Util {
	private static final String TYPE_INT = "int";

	private static final String TYPE_LONG = "long";

	private static final String TYPE_FLOAT = "float";

	private static final String TYPE_DOUBLE = "double";

	private static final String TYPE_BOOLEAN = "boolean";

	private static final String TYPE_STRING = "string";

	private static final String TYPE_STRING_BASE64 = "stringBase64";

	public static final Object getJavaObject(String type, String val) {
		if (type != null) {
			if (type.equals(TYPE_INT)) {
				return Integer.valueOf(val);
			} else if (type.equals(TYPE_LONG)) {
				return Long.valueOf(val);
			} else if (type.equals(TYPE_FLOAT)) {
				return Float.valueOf(val);
			} else if (type.equals(TYPE_DOUBLE)) {
				return Double.valueOf(val);
			} else if (type.equals(TYPE_BOOLEAN)) {
				return Boolean.valueOf(val);
			} else if (type.equals(TYPE_STRING)) {
				return val;
			} else if (type.equals(TYPE_STRING_BASE64)) {
				return val;
			}
		}
		return null;
	}

	public static String[] parseParams(String theParams) {
		Vector v = new Vector();
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new StringReader("<params>" + theParams
					+ "</params>"));
			System.out.println(doc.asXML());
			Element params = doc.getRootElement();

			for (int j = 0, size = params.nodeCount(); j < size; j++) {
				Node node = params.node(j);
				if (null != node && node.hasContent()) {
					String content = node.asXML();
					int start = content.indexOf('>');
					int end = content.lastIndexOf('<');
					v.add(content.substring(start + 1, end));
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		String[] paramArray = new String[v.size()];
		for (int i = 0; i < v.size(); i++)
			paramArray[i] = (String) v.get(i);
		return paramArray;
	}
}
