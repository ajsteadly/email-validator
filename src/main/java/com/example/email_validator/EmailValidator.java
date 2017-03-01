package com.example.email_validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	
	private static final int NUM_TESTS = 2;
	
	/**
	 * Validates an email through a series of tests
	 * @param email
	 * @return True if all tests passed
	 */
	public static boolean validate(String email) {
		return runTests(email) == NUM_TESTS;
	}
	
	/**
	 * Runs all tests on email
	 * @param email
	 * @return number of tests passed
	 */
	public static int runTests(String email) {
		int numPassed = 0;
		if (exactlyOneAt(email)) numPassed++;
		if (atLeastOnePeriod(email)) numPassed++;
		return numPassed;
	}
	
	/**
	 * Checks email for exactly one @ character
	 * @param email
	 * @return true if exactly one
	 */
	public static boolean exactlyOneAt(String email) {
		Pattern p = Pattern.compile("[^@]*@[^@]*");
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	/**
	 * Checks email for all least one . character
	 * @param email
	 * @return True if at least one
	 */
	public static boolean atLeastOnePeriod(String email) {
		Pattern p = Pattern.compile(".*\\..*");
		Matcher m = p.matcher(email);
		return m.matches();
	}
}
