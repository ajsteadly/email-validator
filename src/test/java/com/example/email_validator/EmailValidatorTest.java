package com.example.email_validator;

import junit.framework.TestCase;

/**
 * Unit tests for Email Validator
 */
public class EmailValidatorTest extends TestCase {
    
	/**
	 * Constructor
	 * @param testName Name of test class
	 */
    public EmailValidatorTest (String testName) {
        super( testName );
    }

    /**
     * Tests for validate(String email)
     * Tests based on current rules for email
     */
    public void testValidate() {
        assertTrue(EmailValidator.validate("hobbyjones@gmail.com"));
        assertTrue(EmailValidator.validate("af19340@hotmail.com"));
        assertTrue(EmailValidator.validate("asd_dsaas24f@cs.dal.ca"));
        assertTrue(EmailValidator.validate("@."));
        assertTrue(EmailValidator.validate("com.gmail@hellomynameis"));
        assertFalse(EmailValidator.validate("a@a"));
        assertFalse(EmailValidator.validate("a.a"));
        assertFalse(EmailValidator.validate("aamdlea@gmailcom"));
        assertFalse(EmailValidator.validate(""));
    }
    
    /**
     * Tests for validate(String email)
     */
    public void testExactlyOneAt() {
        assertTrue(EmailValidator.exactlyOneAt("@"));
        assertTrue(EmailValidator.exactlyOneAt("af19340@hotmail.com"));
        assertTrue(EmailValidator.exactlyOneAt("asd_dsaas24f@cs.dal.ca"));
        assertFalse(EmailValidator.exactlyOneAt("@@"));
        assertFalse(EmailValidator.exactlyOneAt("a@a@"));
        assertFalse(EmailValidator.exactlyOneAt("asdjipn@nkasdn@ansdp@"));
        assertFalse(EmailValidator.exactlyOneAt("@.@"));
        assertFalse(EmailValidator.exactlyOneAt(""));
    }
    
    /**
     * Tests for validate(String email)
     */
    public void testAtLeastOnePeriod() {
        assertTrue(EmailValidator.atLeastOnePeriod("hobbyjones@gmail.com"));
        assertTrue(EmailValidator.atLeastOnePeriod("."));
        assertTrue(EmailValidator.atLeastOnePeriod(".."));
        assertTrue(EmailValidator.atLeastOnePeriod("as.djao;de."));
        assertFalse(EmailValidator.atLeastOnePeriod("@"));
        assertFalse(EmailValidator.atLeastOnePeriod("aamdlea@gmailcom"));
        assertFalse(EmailValidator.atLeastOnePeriod(""));
    }
}