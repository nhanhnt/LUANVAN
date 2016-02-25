package com.vogella.extensionpoint.contribution;

import com.vogella.extensionpoint.definition.Igreeter;

public class GreeterGerman implements Igreeter {

	public GreeterGerman() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void greet() {
		System.out.println("Hi nhan");

	}

}
