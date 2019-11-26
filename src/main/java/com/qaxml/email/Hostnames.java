/*
MIT License

Copyright (c) 2019 QAXML Pty Ptd

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package com.qaxml.email;

import org.apache.commons.lang3.RandomUtils;

public class Hostnames {

	private static final String VALID_DOMAIN_CHARACTERS = "0123456789-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final int MAX_DEFAULT_DOMAIN_LENGTH = 32;

	private static final int MIN_DEFAULT_DOMAIN_LENGTH = 1;

	private static String generateRandom(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			char c = VALID_DOMAIN_CHARACTERS.charAt(RandomUtils.nextInt(0, VALID_DOMAIN_CHARACTERS.length()));
			sb.append(c);
		}
		return sb.toString();
	}

	public static String get() {
		String hostname = generateRandom(RandomUtils.nextInt(MIN_DEFAULT_DOMAIN_LENGTH, MAX_DEFAULT_DOMAIN_LENGTH));
		String tld = Tlds.random();
		if (tld.startsWith(".")) {
			return hostname + tld;
		} else {
			return tld + hostname;
		}
	}

	public static void main(String[] args) {
		while (true)
			System.out.println(get());
	}

}
