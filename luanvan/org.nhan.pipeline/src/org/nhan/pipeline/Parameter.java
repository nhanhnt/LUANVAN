package org.nhan.pipeline;

import org.dom4j.Element;

public class Parameter {
	private String name = null;

	private String type = null;

	private String value = null;

	public Parameter(Element element) {
		setName(element.attributeValue("name"));
		setType(element.attributeValue("type"));
	}

	public String getName() {
		return name;
	}

	public void setName(String theName) {
		this.name = theName;
	}

	public String getType() {
		return type;
	}

	public void setType(String theType) {
		this.type = theType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String theValue) {
		this.value = theValue;
	}

}
