package org.nhan.sbus;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.encoding.XMLType;

public class Call {
	public Call(String service) {
		int pos = service.indexOf("@");
		if (pos > 0) {
			String host = service.substring(pos + 1);
			if (!(host.equalsIgnoreCase("LOCALHOST") || host
					.equalsIgnoreCase("127.0.0.1")))
				this.endpoint = "http://" + host
						+ ":8088/services/MessageHandler";
			this.service = service.substring(0, pos);
		} else {
			this.service = service;
		}
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Object invoke(String operation, Object... params) throws Exception {
		setOperation(operation);
		return invoke(params);
	}

	public void invokeAsyn(ICallback callback, String operation,
			Object... params) {
		setOperation(operation);
		invokeAsyn(callback, params);
	}

	public Object invoke(Object... params) throws Exception {
		if (service == null || operation == null)
			throw new IllegalArgumentException(
					"Service or operation name must NOT be null");

		else
			return MessageHandler.getDefault().invoke(service, operation,
					params);
	}

	public void invokeAsyn(final ICallback callback, final Object... params) {
		Runnable runner = new Runnable() {
			public void run() {
				try {
					Object res = invoke(params);
					callback.callback(res);
				} catch (Exception exp) {
					callback.callback(exp);
				}
			}
		};
		new Thread(runner).start();
	}

	public Object invoke(String operation, String... params) throws Exception {
		throw new NoSuchMethodException("Method not supported anymore");
	}

	public Object invoke(String... params) throws Exception {
		throw new NoSuchMethodException("Method not supported anymore");
	}

	@SuppressWarnings("unused")
	private String invokeRemote(String params) throws IOException {
		javax.xml.rpc.Call call = new org.apache.axis.client.Call(endpoint);

		call.setOperationName(new QName("urn:cominfo", "invoke"));
		call.addParameter("service", XMLType.XSD_STRING, ParameterMode.IN);
		call.addParameter("operation", XMLType.XSD_STRING, ParameterMode.IN);
		call.addParameter("param", XMLType.XSD_STRING, ParameterMode.IN);
		call.setReturnType(XMLType.XSD_STRING);

		return (String) call
				.invoke(new Object[] { service, operation, params });
	}

	private String service;

	private String operation;

	private String endpoint;
}
