package com.stringcompressor.app;

public class Compress {
	private String compressed;

	private Compress(String value) {
		this.compressed = value;
	}

	public static Compress compressString(String value) {
		if (value.length() == 0)
			return new Compress("");
		value = value.toLowerCase();
		StringBuffer outputValue = new StringBuffer();
		int charIndex = 1;
		Character lastChar = value.charAt(0);
		int charCount = 1;
		while (charIndex < value.length()) {
			if (!Character.isLetter(value.charAt(charIndex)))
				throw new invalidCharExeption("invalid Char '" + value.charAt(charIndex) + "' at pos " + charIndex);
			if (lastChar != value.charAt(charIndex)) {
				outputValue.append(charCount);
				outputValue.append(lastChar);
				charCount = 0;
			}
			lastChar = value.charAt(charIndex);
			charCount++;
			charIndex++;
		}
		outputValue.append(charCount);
		outputValue.append(lastChar);
		return new Compress(outputValue.toString());
	}

	public String getCompressed() {
		return this.compressed;
	}
}
