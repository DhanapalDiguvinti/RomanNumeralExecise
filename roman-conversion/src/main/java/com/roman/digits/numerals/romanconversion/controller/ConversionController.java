package com.roman.digits.numerals.romanconversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.roman.digits.numerals.romanconversion.service.ConversionService;

@RestController
public class ConversionController {

	@Autowired
	private ConversionService conversionService;

	@GetMapping(path = "/convertNumeberToRoman/{number}")
	public String convertNumeberToRoman(@PathVariable int number) {

		return conversionService.convertNumeberToRoman(number);

	}

	@GetMapping(path = "/convertRomanToNumeber/{roman}")
	public int convertRomanToNumeber(@PathVariable String roman) {

		return conversionService.convertRomanToNumeber(roman);
	}
}

