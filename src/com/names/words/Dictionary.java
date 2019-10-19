package com.names.words;

public class Dictionary {
	private static Name[] listOfName;
	
	/**
	 * initialize list of name to be processed
	 * @param names
	 */
	public static void init(Name[] names) {
		listOfName = names;
	}
	
	/**
	 * Sort the initialized names
	 * @return sorted names
	 */
	public static Name[] sort() {
		Name[] nameList = listOfName;
		int size = nameList.length;
		Name tempName = null;
		
		boolean isChanged;
		do {
			isChanged = false; // flag to inform the array swapped event 
			
			//loop to all index inside nameList
			for(int nameIndex = 1; nameIndex< size; nameIndex++) {
				//get current name and next name
				String name = ((NameProcessing)nameList[nameIndex-1]).getCompleteSwapped();
				String nameNext = ((NameProcessing)nameList[nameIndex]).getCompleteSwapped();
				
				//pad the shortest name with spaces
				if(name.length() > nameNext.length()) {
					for(int index = nameNext.length(); index<name.length(); index++) {
						nameNext += " ";
					}
				}else if (name.length() < nameNext.length()) {
					for(int index = name.length(); index<nameNext.length(); index++) {
						name += " ";
					}
				}
				
				//loop to all char of 2 name comparison
				for(int charIndex = 0; charIndex<name.length() ; charIndex++) {
					char nameChar = name.toLowerCase().charAt(charIndex);
					char nameNextChar = nameNext.toLowerCase().charAt(charIndex);
					if(nameChar > nameNextChar) {
						tempName = nameList[nameIndex];
						nameList[nameIndex] = nameList[nameIndex-1];
						nameList[nameIndex-1] = tempName;
						isChanged = true; //array is swapped when current name char is > than next name char
						break;
					}else if(nameChar < nameNextChar){
						break;
					}
				}
			}
			
		}while(isChanged);
		
		return nameList;
	}
}
