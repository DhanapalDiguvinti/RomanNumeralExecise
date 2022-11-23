package com.roman.digits.numerals.romanconversion.service;

import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

	public String convertNumeberToRoman(int number) {

		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		String[] romanLetters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		StringBuilder roman = new StringBuilder();

		for (int i = 0; i < values.length; i++) {
			while (number >= values[i]) {
				number = number - values[i];
				roman.append(romanLetters[i]);
			}
		}
		return roman.toString();
	}

	public int convertRomanToNumeber(String romanNumber) {

		int total = 0;
		for (int i = 0; i < romanNumber.length(); i++) {
			int s1 = value(romanNumber.charAt(i));
			if (i + 1 < romanNumber.length()) {
				int s2 = value(romanNumber.charAt(i + 1));
				if (s1 >= s2) {
					total = total + s1;
				} else {
					total = total - s1;
				}
			} else {
				total = total + s1;
			}
		}
		return total;
	}

	int value(char r) {
		if (r == 'I')
			return 1;
		if (r == 'V')
			return 5;
		if (r == 'X')
			return 10;
		if (r == 'L')
			return 50;
		if (r == 'C')
			return 100;
		if (r == 'D')
			return 500;
		if (r == 'M')
			return 1000;
		return -1;
	}

}
