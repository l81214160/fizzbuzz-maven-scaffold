package com.psbc.cdfzx;

public class FizzBuzz {

	public static void main(String[] args) {
		for (int i = 0; i < 101; i++) {
			System.out.println(of(i));
		}
	}
	
	public static String of(int number) {
		if (number % 3 == 0) {
			if(number % 5 == 0) {
				return "FizzBuzz";
			}
			return "Fizz";
		}
		
		if(number % 5 == 0) {
			return "Buzz";
		}
		return String.format("%d", number);
	}

}
