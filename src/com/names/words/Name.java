package com.names.words;

/**
 * General class of name
 * @author Diyah
 *
 */
public class Name {
	protected String lastName ="";
	protected String givenName ="";
	
	public Name(String lastName, String givenName) {
		this.lastName = lastName;
		this.givenName = givenName;
	}
	
	public String getLast() {
		return this.lastName;
	}
	
	public String getGiven() {
		return this.givenName;
	}
	
}
