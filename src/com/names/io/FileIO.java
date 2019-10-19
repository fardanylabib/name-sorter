package com.names.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Diyah
 *Class to handle input/output file
 */
public class FileIO {	
	//file path of input file
	private static String inputPath = null;
	//using buffered writer to write the output
	private static BufferedWriter bufferedWriter;
	
	public static int maxCapturedLineLength = 0;
	
	/**
	 * Initialize the path of input file
	 * @param path
	 */
	public static void setInputFile(String path) {
		maxCapturedLineLength = 0;
		inputPath = path;
	}
		
	/**
	 * Read from target file that has initialized
	 * @return String array of file content
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String[] readFromFile() throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		//create a file reader
		FileReader reader = new FileReader(inputPath);
		//upgrade to buffered to increase performance
		BufferedReader bufferedReader = new BufferedReader(reader); 
		String aTextLine = null;
		//read and save into array list result
		int maxLineLength = 0;
		int currentLineLength;
		while((aTextLine = bufferedReader.readLine()) != null){
			aTextLine = aTextLine.trim().replace("\n", "");
			currentLineLength = aTextLine.length();
			if(currentLineLength > 0) {
				lines.add(aTextLine);
				if(currentLineLength > maxLineLength) {
					maxLineLength = currentLineLength;
				}
			}
		}
		bufferedReader.close();
		String[] result = new String[lines.size()];
		lines.toArray(result);
		maxCapturedLineLength = maxLineLength;
		return result;
	}
	
	/**
	 * Initialize the path of output file
	 * @param path
	 * @throws IOException
	 */
	public static void setOutputFile(String path) throws IOException {
		File file = new File(path);
		FileWriter writer = new FileWriter(file,false);
		bufferedWriter = new BufferedWriter(writer);
	}
	
	/**
	 * Write the output
	 * @param lineToWrite
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void writeToFile(String lineToWrite) throws IOException {
		//write it to file
		bufferedWriter.write(lineToWrite + "\n");
	}
	
	/**
	 * Close the file writer
	 * @throws IOException
	 */
	public static void closeWriter() throws IOException {
		bufferedWriter.close();
	}
	
}
