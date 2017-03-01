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
        assertFalse(EmailValidator.validate("@."));
        assertFalse(EmailValidator.validate("com.gmail@hellomynameis"));
        assertFalse(EmailValidator.validate("a@a"));
        assertFalse(EmailValidator.validate("a.a"));
        assertFalse(EmailValidator.validate("aamdlea@gmailcom"));
        assertFalse(EmailValidator.validate(""));
    }
    
    /**
     * Tests for exactlyOneAt(String email)
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
     * Tests for atLeastOnePeriod(String email)
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
    
    /**
     * Tests for periodAfterAt(String email)
     */
    public void testPeriodAfterAt() {
        assertTrue(EmailValidator.periodAfterAt("hobbyjones@gmail.com"));
        assertTrue(EmailValidator.periodAfterAt("@."));
        assertTrue(EmailValidator.periodAfterAt("asdas@sdfsdf.sdfsdf.fdsf"));
        assertTrue(EmailValidator.periodAfterAt("@asd."));
        assertFalse(EmailValidator.periodAfterAt(".@"));
        assertFalse(EmailValidator.periodAfterAt("aamdlea@gmailcom"));
        assertFalse(EmailValidator.periodAfterAt("asd.sdfs@afd"));
        assertFalse(EmailValidator.periodAfterAt(""));
    }
    
    /**
     * Tests for longEnough(String email)
     */
    public void testLongEnough() {
        assertTrue(EmailValidator.longEnough("hobbyjones@gmail.com"));
        assertTrue(EmailValidator.longEnough("a@g.c"));
        assertTrue(EmailValidator.longEnough("a23,4"));
        assertTrue(EmailValidator.longEnough("34567uyhdgfvsdsf"));
        assertFalse(EmailValidator.longEnough("@"));
        assertFalse(EmailValidator.longEnough("asf"));
        assertFalse(EmailValidator.longEnough("@."));
        assertFalse(EmailValidator.longEnough("a@c."));
        assertFalse(EmailValidator.longEnough(""));
    }
}