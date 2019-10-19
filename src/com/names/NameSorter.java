package com.names;

import java.io.IOException;

import com.names.io.FileIO;
import com.names.words.Dictionary;
import com.names.words.Name;
import com.names.words.NameProcessing;


/**
 * 
 * @author Diyah
 *Main Class, contains main function to be executed
 */
public class NameSorter {
	private static final String INPUT_FILE_PATH = "./resource";
	private static final String OUTPUT_FILE_PATH = "./resource/sorted-names-list.txt";
	
	/**
	 * main function to execute
	 * @param inputFileName : file name with extension (must be inside resource folder)
	 */
	public static void main(String[] inputFileName) {
		try {
			FileIO.setInputFile(INPUT_FILE_PATH + inputFileName[0].substring(1));
			String[] nameList = FileIO.readFromFile();
			
			int listLength = nameList.length;
			Name[] completeNames = new Name[listLength];
			
			for(int i = 0; i< listLength; i++) {
				completeNames[i] = NameProcessing.makeLastAndGivenName(nameList[i]);
			}
			
			Dictionary.init(completeNames);
			completeNames = Dictionary.sort();
			
			FileIO.setOutputFile(OUTPUT_FILE_PATH);
			for(Name name : completeNames) {
				String completeName = ((NameProcessing) name).getComplete();
				System.out.println(completeName);
				FileIO.writeToFile(completeName);
			}
			FileIO.closeWriter();
			
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			System.out.println("An Error Occured...:(");
			e.printStackTrace();
		}
		
	}
}
