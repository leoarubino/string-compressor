package com.stringcompressor.entity;

public class CompressInput {
	public String value;

	public CompressInput() {
		this.value = "";
	}

	public CompressInput(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	};
}
