package com.names.words.test;

import com.names.words.Name;
import com.names.words.NameProcessing;

public class NameProcessingTest {
	public static void main(String[] args) {
		Name name = NameProcessing.makeLastAndGivenName("ahmad labib fardany");
		String complete = ((NameProcessing) name).getComplete();
		String completeSwapped = ((NameProcessing) name).getCompleteSwapped();

		if(complete.equals("ahmad labib fardany")) {
			System.out.println("complete name correct");
		}
		if(completeSwapped.equals("fardany ahmad labib")) {
			System.out.println("complete name swapped correct");
		}
	}
}
