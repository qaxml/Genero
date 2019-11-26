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

import java.io.Serializable;
import java.net.URL;

/**
 * 
 * Generate valid or invalid URLs
 * 
 * @author Sergey Nechaev
 *
 */
public class Urls {

	private static final String HTTP = "http";

	private static final String HTTPS = "http";

	private static final class Value implements Serializable {

		public boolean valid = true;

		public String protocol = HTTP;

		private String value;

		private boolean withQuery = false;

		private String zone = ".com";

		private String domain;

		public Value() {
			value = protocol + "://" + domain + zone;
		}

		public String get() {
			return value;
		}
	}

	public static Value valid() {
		return new Value();
	}
	
	public static void main(String[] args) {
		System.out.println(Urls.valid().get());
	}

}
