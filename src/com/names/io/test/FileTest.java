package com.names.io.test;

import java.io.IOException;
import java.util.Arrays;
import com.names.io.FileIO;

public class FileTest {
	static String[] expected = {
							"Orson Milka Iddins",
							"Erna Dorey Battelle",
							"Flori Chaunce Franzel",
							"Odetta Sue Kaspar",
							"Roy Ketti Kopfen",
							"Madel Bordie Mapplebeck",
							"Selle Bellison",
							"Leonerd Adda Mitchell Monaghan",
							"Debra Micheli",
							"Hailey Annakin",
							"Leonerd Adda Micheli Monaghan",
							"Avie Annakin"
						};
	
	static String[] expected2 = {
							"Avie Annakin",
							"Leonerd Adda Micheli Monaghan",
							"Hailey Annakin",
							"Debra Micheli",
							"Leonerd Adda Mitchell Monaghan",
							"Selle Bellison",
							"Madel Bordie Mapplebeck",
							"Roy Ketti Kopfen",
							"Odetta Sue Kaspar",
							"Flori Chaunce Franzel",
							"Erna Dorey Battelle",
							"Orson Milka Iddins"
						};
	
	public static void main(String[] args) throws IOException {
		String path = "./resource/unsorted-names-list.txt";
		String outPath = "./resource/sorted-names-list.txt";
		FileIO.setInputFile(path);
		FileIO.setOutputFile(outPath);
		
		//input test
		String[] lines = FileIO.readFromFile();
		System.out.println("input size = "+lines.length);
		if(Arrays.equals(lines, expected)){
			System.out.println("Read file success");
		}else {
			System.out.println("Read file failed");
		}
		
		//output test
		for(int i = lines.length-1 ; i>= 0 ; i--) {
			FileIO.writeToFile(lines[i]);
		}
		FileIO.closeWriter();
		FileIO.setInputFile(outPath);
		lines = FileIO.readFromFile();
		System.out.println("output size = "+lines.length);
		if(Arrays.equals(lines, expected2)){
			System.out.println("Write file success");
		}else {
			System.out.println("Write file failed");
		}
		
	}
}
