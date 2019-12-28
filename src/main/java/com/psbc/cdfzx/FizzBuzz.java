package com.psbc.cdfzx;

public class FizzBuzz {

	public static String of(int number) {
		if (number % 3 == 0) {
			if(number % 5 == 0) {
				return "FizzBuss";
			}
			return "Fizz";
		}
		
		if(number % 5 == 0) {
			return "Buss";
		}
		return String.format("%d", number);
	}

}
