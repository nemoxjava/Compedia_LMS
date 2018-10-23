package com.italam.data;

public enum EnumDBsConnDetails {

	TEST_CONN_STRING(0), TEST_USER(1), TEST_PASS(2), PROD_CONN_STRING(3), PROD_USER(4), PROD_PASS(5), ;

	private final int value;

	EnumDBsConnDetails(final int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}

}
