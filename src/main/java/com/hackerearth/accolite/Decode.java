package com.hackerearth.accolite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Decode {

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); PrintWriter wr = new
		 * PrintWriter(System.out); int T =
		 * Integer.parseInt(br.readLine().trim()); for (int t_i = 0; t_i < T;
		 * t_i++) { String s = br.readLine();
		 * 
		 * String out_ = decode(s); System.out.println(out_); }
		 * 
		 * wr.close(); br.close();
		 */
		System.out.println(decode("wrien"));
		System.out.println(decode("reen"));
		System.out.println(decode("eneartsh"));
	}

	static String decode(String s) {
		StringBuilder output = new StringBuilder(s.length());
		if (s.isEmpty()) {
			return s;
		}
		output.append(s.charAt(0));
		int sLength = s.length();
		boolean isEven = false;

		if (sLength % 2 == 0) {
			isEven = true;
		}
		for (int i = 1; i < s.length(); i++) {
			if (isEven) {
				if (i % 2 == 1) {
					output.append(s.charAt(i));
				} else {
					output.insert(0, s.charAt(i));
				}
			} else {
				if (i % 2 == 1) {
					output.insert(0, s.charAt(i));
				} else {
					output.append(s.charAt(i));
				}
			}
		}
		return output.toString();
	}
}
