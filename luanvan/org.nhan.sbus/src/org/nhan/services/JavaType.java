package org.nhan.services;

public abstract class JavaType {
	// Parameter types
	public static final JavaType TYPE_INT = new JavaType("int") {
		public Class getType() {
			return int.class;
		}

		public Object valueOf(String value) {
			return Integer.valueOf(value);
		}

		public boolean equals(Class cls) {
			return cls.equals(int.class) || cls.equals(Integer.class);
		}
	};

	public static final JavaType TYPE_LONG = new JavaType("long") {
		public Class getType() {
			return long.class;
		}

		public Object valueOf(String value) {
			return Long.valueOf(value);
		}

		public boolean equals(Class cls) {
			return cls.equals(int.class) || cls.equals(Integer.class);
		}
	};

	public static final JavaType TYPE_FLOAT = new JavaType("float") {
		public Class getType() {
			return float.class;
		}

		public Object valueOf(String value) {
			return Float.valueOf(value);
		}

		public boolean equals(Class cls) {
			return cls.equals(float.class) || cls.equals(Float.class);
		}
	};

	public static final JavaType TYPE_DOUBLE = new JavaType("double") {
		public Class getType() {
			return double.class;
		}

		public Object valueOf(String value) {
			return Double.valueOf(value);
		}

		public boolean equals(Class cls) {
			return cls.equals(double.class) || cls.equals(Double.class);
		}
	};

	public static final JavaType TYPE_BOOLEAN = new JavaType("boolean") {
		public Class getType() {
			return boolean.class;
		}

		public Object valueOf(String value) {
			return Boolean.valueOf(value);
		}

		public boolean equals(Class cls) {
			return cls.equals(boolean.class) || cls.equals(Boolean.class);
		}
	};

	public static final JavaType TYPE_STRING = new JavaType("string") {
		public Class getType() {
			return String.class;
		}

		public Object valueOf(String value) {
			return value;
		}

		public boolean equals(Class cls) {
			return cls.equals(String.class);
		}
	};

	public static final JavaType TYPE_VOID = new JavaType("void") {
		public Class getType() {
			return void.class;
		}

		public Object valueOf(String value) {
			return value;
		}

		public boolean equals(Class cls) {
			return cls.equals(void.class);
		}
	};

	static final JavaType[] TYPES = { TYPE_INT, TYPE_LONG, TYPE_FLOAT,
			TYPE_DOUBLE, TYPE_BOOLEAN, TYPE_STRING, TYPE_VOID };

	public abstract Class getType();

	public abstract boolean equals(Class cls);

	public abstract Object valueOf(String value);

	public boolean equals(String type) {
		return type.toLowerCase().equals(this.type);
	}

	private JavaType(String type) {
		this.type = type;
	}

	private String type;
}
