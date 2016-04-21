package org.nhan.sbus;

import java.lang.reflect.Method;
import org.eclipse.core.runtime.IConfigurationElement;

public class OperationProxy {
	protected OperationProxy(Object delegate,
			IConfigurationElement serviceElement) throws Exception {

		this.delegate = delegate;
		this.operationName = serviceElement.getAttribute("name");
		this.returnType = getJavaType(serviceElement.getAttribute("returns"));

		IConfigurationElement[] paramElems = serviceElement.getChildren();
		this.paramTypes = new Class[paramElems.length];

		int index = 0;
		for (IConfigurationElement param : paramElems) {
			String type = param.getAttribute("type");
			paramTypes[index++] = getJavaType(type);
		}
	}

	/**
	 * Returns the operation name
	 */
	protected String getName() {
		return operationName;
	}

	/**
	 * Returns the return type of this service
	 */
	protected Class getReturnType() {
		return returnType;
	}

	/**
	 * Returns the parameter types
	 */
	protected Class[] getParamTypes() {
		return paramTypes;
	}

	protected Object invoke(Object... params) throws Exception {
		Object[] params0 = new Object[params.length];
		for (int i = 0; i < paramTypes.length; i++) {
			if (params[i] instanceof String) {
				params0[i] = normalize(params[i].toString(), paramTypes[i]);
			} else {
				params0[i] = params[i];
			}
		}
		Class delegateCls = delegate.getClass();
		Method proxyMethod = delegateCls.getMethod(operationName, paramTypes);
		if (operationName.equals("storeItem")) {
			for (int i = 0; i < paramTypes.length; i++) {
				MessageHandler.log(paramTypes[i].toString());
				MessageHandler.log(params[i].getClass().toString());
				MessageHandler.log(params[i].toString());
			}
		}
		return proxyMethod.invoke(delegate, params);
	}

	private final Class getJavaType(String type) throws Exception {
		for (JavaType type0 : JavaType.TYPES) {
			if (type0.equals(type))
				return type0.getType();
		}
		try {
			return Class.forName(type);
		} catch (ClassNotFoundException cnfexp) {
			Class delegateCls = delegate.getClass();
			Method proxyMethod = delegateCls.getMethod("getParamClass",
					String.class);
			return (Class) proxyMethod.invoke(delegate, type);
		}
	}

	
	private static final Object normalize(String value, Class cls) {
		if (cls.equals(String.class))
			return value;

		for (JavaType type : JavaType.TYPES) {
			if (type.equals(cls))
				return type.valueOf(value);
		}
		return value;
	}

	private Object delegate;

	private String operationName;

	private Class returnType;

	private Class[] paramTypes;
}
