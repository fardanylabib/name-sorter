package com.names.words;

/**
 * Child class of name to handle more process
 * @author Diyah
 *
 */
public class NameProcessing extends Name{

	private String complete;
	private String completeSwapped;
	
	
	public NameProcessing(String lastName, String givenName) {
		super(lastName, givenName);
		this.complete = super.givenName + " " +super.lastName;
		this.completeSwapped = super.lastName + " " +super.givenName;
	}

	/**
	 * Make name scheme based on last name and given name
	 * @param name
	 * @return
	 */
	public static Name makeLastAndGivenName(String name) {
		String[] separate = name.split(" ");
		String givenName = "";
		String lastName = separate[separate.length-1]; //get the last of name separation
		for(int i = 0; i < (separate.length - 1); i++) {
			givenName += (separate[i] + " "); //get first, second,... of name separation
		}
		givenName = givenName.trim();
		return new NameProcessing(lastName,givenName);
	}	
	
	/**
	 * Get complete name (given name + last name)
	 * @return
	 */
	public String getComplete() {
		return this.complete;
	}
	
	/**
	 * Get swapped complete name (last name + given name)
	 * @return
	 */
	public String getCompleteSwapped() {
		return this.completeSwapped;
	}	
	
}
