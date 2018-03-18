package TextAnalysis;

import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class TextAnalysis {
	
	//Attributes
	public String input;
	public char[] inputAsArray;
	public String inputForDisplay;
	public int numberOfSpaces;
	public int charsIncludingSpaces;
	public int charsExcludingSpaces;
	public int numberOfWords;
	public int[] characterFrequency;
	public int highestCount;
	public int numberOfRecognisedCharacters;
	public int numberOfUnrecognisedCharacters;
	public String[] relativeFrequency;
	public ArrayList<Integer> wordLengths;
	public String wordLengthDisplay;
	public ArrayList<Integer> wordLengthFrequencies;
	public String wordLengthFrequenciesDisplay;
	public static final char[] characterArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '!', '?', ':', ';', '"','\'', '&', '(', ')', '-', '@', '\\', '/'};
	
	
	//Constructor
	public TextAnalysis(String userInput) {
		this.input = userInput.toUpperCase();
		this.inputAsArray = input.toCharArray();
		this.inputForDisplay = inputForDisplay(inputAsArray);
		this.numberOfSpaces = numberOfSpaces(inputAsArray);
		this.charsIncludingSpaces = inputAsArray.length;
		this.charsExcludingSpaces = charsIncludingSpaces - numberOfSpaces;
		this.numberOfWords = numberOfWords(numberOfSpaces);
		this.characterFrequency = characterFrequency(inputAsArray, characterArray);
		this.highestCount = highestCount(characterFrequency);
		this.numberOfRecognisedCharacters = numberOfRecognisedCharacters(characterFrequency);
		this.numberOfUnrecognisedCharacters = numberOfUnrecognisedCharacters(numberOfRecognisedCharacters, charsExcludingSpaces);
		this.relativeFrequency = relativeFrequency(characterFrequency, charsExcludingSpaces);
		this.wordLengths = wordLengths(inputAsArray, characterArray);
		this.wordLengthDisplay = wordLengthDisplay(wordLengths);
		this.wordLengthFrequencies = wordLengthFrequencies(wordLengths);
		this.wordLengthFrequenciesDisplay = wordLengthFrequenciesDisplay(wordLengthFrequencies);
	}
	
	
	//Methods
	//Get methods
	public String getInput() {return input;}
	public int getNumberOfSpaces() {return numberOfSpaces;}
	public int getCharsIncludingSpaces() {return charsIncludingSpaces;}
	public int getCharsExcludingSpaces() {return charsExcludingSpaces;}
	public int getNumberOfWords() {return numberOfWords;}
	public int[] getCharacterFrequency() {return characterFrequency;}
	public int getHighestCount() {return highestCount;}
	public int getNumberOfRecognisedCharacters() {return numberOfRecognisedCharacters;}
	public int getNumberOfUnrecognisedCharacters() {return numberOfUnrecognisedCharacters;}
	public String[] getRelativeFrequency() {return relativeFrequency;}
	public ArrayList<Integer> getWordLengths() {return wordLengths;}
	public ArrayList<Integer> getWordLengthFrequencies() {return wordLengthFrequencies;}
	
	//Analysis methods
	
	public int numberOfSpaces(char[] inputAsArray) {
		int count = 0;
		for (int i = 0; i < inputAsArray.length; i++) {
			if (inputAsArray[i] == ' ') {
				count++;
			}
		}
		return count;
	}
	
	public int numberOfWords(int numberOfSpaces) {
		if (numberOfSpaces == 0) {
			return 0;
		}
		else {
			return numberOfSpaces + 1;
		}
	}
	
	public int countCharacters(char[] inputAsArray, char character) {
		int count = 0;		
		for (int i = 0; i < inputAsArray.length; i++) {
			if (character == inputAsArray[i]) {
				count++;
			}
		}		
		return count;
	}
	
	public int[] characterFrequency(char[] strArray, char[] characterArray) {
		int[] frequencyValues = new int[51];	
		for (int i = 0; i < characterArray.length; i++) {
			frequencyValues[i] = countCharacters(strArray, characterArray[i]); 
		}		
		return frequencyValues;
	}
	
	public int highestCount(int[] characterFrequency) {
		int count = 0;
		for (int i = 0; i < characterFrequency.length; i++) {
			if (characterFrequency[i] > count) {
				count = characterFrequency[i];
			}
		}
		return count;
	}
	
	public int numberOfRecognisedCharacters(int[] characterFrequency) {
		int count = 0;
		for (int i = 0; i < characterFrequency.length; i++) {
			count += characterFrequency[i];
		}
		return count;
	}
	
	public int numberOfUnrecognisedCharacters(int numberOfRecognisedCharacters, int charsExcludingSpaces) {
		int count = charsExcludingSpaces - numberOfRecognisedCharacters;
		return count;
	}
	
	public String[] relativeFrequency(int[] characterFrequency, int length) {
		double[] relativeFrequency = new double[51];
		double[] characterFrequencyDouble = new double[51];
		String[] formattedRelativeFrequency = new String[51];
		for (int i = 0; i < characterFrequency.length; i++) {
			characterFrequencyDouble[i] = characterFrequency[i];
		}
		for (int i = 0; i < characterFrequency.length; i++) {
			if (length > 0) {
				relativeFrequency[i] = (characterFrequencyDouble[i] / length);
			}
			else {
				relativeFrequency[i] = 0;
			}
		}
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		for (int i = 0; i < relativeFrequency.length; i++) {
			if (length > 0) {
				formattedRelativeFrequency[i] = df.format(relativeFrequency[i]);
			}
			else {
				formattedRelativeFrequency[i] = "0";
			}
		}
		
		return formattedRelativeFrequency;
	}
	
	public ArrayList<Integer> wordLengths(char[] inputAsArray, char[] characterArray) {
		ArrayList<Integer> wordLengths = new ArrayList<Integer>();
		int count = 0;
		
   		for (Character character : inputAsArray) {
			if (character != ' ') {
				for (int j = 0; j < 26; j++) {
					if (character == characterArray[j]) {
						count++;
					}
				}
			}

			if (character == ' ' && count != 0) {
				wordLengths.add(count);
				count = 0;
			}
		}
   		wordLengths.add(count);
		return wordLengths;
	}
	
	public ArrayList<Integer> wordLengthFrequencies(ArrayList<Integer> wordLengths) {
		ArrayList<Integer> wordLengthFrequencies = new ArrayList<Integer>();
		int count = 0;
		
		for (int i = 1; i <= 8; i++) {
			for (Integer item : wordLengths) {
				if (i == 8) {
					if (item >= i) {
						count++;
					}
				}
				else {
					if (item == i) {
						count++;
					}
				}
			}
			wordLengthFrequencies.add(count);
			count = 0;
		}
		return wordLengthFrequencies;
	}
	
	//Display methods
	
	public String inputForDisplay(char[] inputAsArray) {
		String string = "";
		int count = 0;
		for (int i = 0; i < inputAsArray.length; i++) {
			string += inputAsArray[i];
			if (inputAsArray[i] == ' ') {
				count++;
			}
			if (inputAsArray[i] == ' ' && count%20 == 0) {
				string += "\n";
			}
		}
		return string;
	}
	
	public String wordLengthDisplay(ArrayList<Integer> wordLengths) {
		String wordLengthDisplay = "";
		
		for (int i = 0; i < wordLengths.size(); i++) {
			wordLengthDisplay += "Word " + (i+1) + " is " + wordLengths.get(i) + " letters long.\n";
		}
		return wordLengthDisplay;
	}
	
	public String wordLengthFrequenciesDisplay(ArrayList<Integer> wordLengthFrequencies) {
		String wordLengthFrequenciesDisplay = "";
		
		for (int i = 0; i < 8; i++) {
			if (i <= 6) {
				wordLengthFrequenciesDisplay += "There are " + wordLengthFrequencies.get(i) + " words containing " + (i+1) + " letters.\n";
			}
			else {
				wordLengthFrequenciesDisplay += "There are " + wordLengthFrequencies.get(i) + " words containing 8 or more letters.\n";
			}
		}
		return wordLengthFrequenciesDisplay;
	}
	 
	public String toString() {
		return "\nThe text you are analysing is :\n\n" + inputForDisplay + "\n\nNumber of words: " 
				+ numberOfWords + "\nNumber of spaces: " + numberOfSpaces + "\nTotal characters including spaces: " 
				+ charsIncludingSpaces + "\nTotal characters excluding spaces: " + charsExcludingSpaces 
				+ "\nTotal number of recognised characters: " + numberOfRecognisedCharacters + "\nTotal number of unrecognised characters: " 
				+ numberOfUnrecognisedCharacters + "\n" + wordLengthFrequenciesDisplay;
	}
	
	public void displayWordLengths() {
		System.out.println(wordLengthDisplay);
	}
	
	public void displayFrequencies(int[] characterFrequency, char[] characterArray, String[] relativeFrequency) {
		//Part 1
		String leftColumnTopBottom = "+---------+";
		String columnTopBottom = "-----+";
		String character = "|Character|";
		String frequency = "|Frequency|";
		String relative = "|Relative |";
		String leftColumnSpace = "|         |";
		String columnSpace = "     |";
		
		System.out.print(leftColumnTopBottom);
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print(columnTopBottom);
			}
			else {
				System.out.println(columnTopBottom);
			}
		}
		System.out.println("");
		
		System.out.print(character);
		for (int i = 0; i < 26; i++) {
			System.out.format("%-5s|", characterArray[i]);
		}
		System.out.println("");
		
		System.out.print(leftColumnSpace);
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print(columnSpace);
			}
			else {
				System.out.println(columnSpace);
			}
		}
		System.out.println("");
		
		System.out.print(leftColumnTopBottom);
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print(columnTopBottom);
			}
			else {
				System.out.println(columnTopBottom);
			}
		}
		System.out.println("");
		
		System.out.print(character);
		for (int i = 0; i < 26; i++) {
			System.out.format("%-5s|", characterFrequency[i]);
		}
		System.out.println("");
		
		System.out.print(frequency);
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print(columnSpace);
			}
			else {
				System.out.println(columnSpace);
			}
		}
		System.out.println("");
		
		System.out.print(leftColumnTopBottom);
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print(columnTopBottom);
			}
			else {
				System.out.println(columnTopBottom);
			}
		}
		System.out.println("");
		
		System.out.print(relative);
		for (int i = 0; i < 26; i++) {
			System.out.format("%-5s|", relativeFrequency[i]);
		}
		System.out.println("");
		
		System.out.print(frequency);
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print(columnSpace);
			}
			else {
				System.out.println(columnSpace);
			}
		}
		System.out.println("");
		
		System.out.print(leftColumnTopBottom);
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print(columnTopBottom);
			}
			else {
				System.out.println(columnTopBottom);
			}
		}
		System.out.println("");
		
		//Part 2
		
		System.out.print(leftColumnTopBottom);
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print(columnTopBottom);
			}
			else {
				System.out.println(columnTopBottom);
			}
		}
		System.out.println("");
		
		System.out.print(character);
		for (int i = 26; i < 51; i++) {
			System.out.format("%-5s|", characterArray[i]);
		}
		System.out.println("");
		
		System.out.print(leftColumnSpace);
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print(columnSpace);
			}
			else {
				System.out.println(columnSpace);
			}
		}
		System.out.println("");
		
		System.out.print(leftColumnTopBottom);
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print(columnTopBottom);
			}
			else {
				System.out.println(columnTopBottom);
			}
		}
		System.out.println("");
		
		System.out.print(character);
		for (int i = 26; i < 51; i++) {
			System.out.format("%-5s|", characterFrequency[i]);
		}
		System.out.println("");
		
		System.out.print(frequency);
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print(columnSpace);
			}
			else {
				System.out.println(columnSpace);
			}
		}
		System.out.println("");
		
		System.out.print(leftColumnTopBottom);
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print(columnTopBottom);
			}
			else {
				System.out.println(columnTopBottom);
			}
		}
		System.out.println("");
		
		System.out.print(relative);
		for (int i = 26; i < 51; i++) {
			System.out.format("%-5s|", relativeFrequency[i]);
		}
		System.out.println("");
		
		System.out.print(frequency);
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print(columnSpace);
			}
			else {
				System.out.println(columnSpace);
			}
		}
		System.out.println("");
		
		System.out.print(leftColumnTopBottom);
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print(columnTopBottom);
			}
			else {
				System.out.println(columnTopBottom);
			}
		}
		System.out.println("");
	}
	
	public void barChartFrequencies(int[] characterFrequency, char[] characterArray, int count) {
	
		if (count < 5) {
			count = 5;
		}
		System.out.println("\n Number of character occurrences");

		for (int i = count; i > 0; i--) {
			if (i < 10) {
				System.out.print(i + "  |");
			}
			else if (i > 9 && i < 100) {
				System.out.print(i + " |");
			}
			else {
				System.out.print(i + "|");
			}
			for (int j = 0; j < characterFrequency.length; j++) {
				if (characterFrequency[j] != 0 && characterFrequency[j] >= i) {
					System.out.print("X ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println("");
		}
		System.out.println("==========================================================================================================");
		System.out.print("   |");
		for (int i = 0; i < characterArray.length; i++) {
			System.out.print(characterArray[i] + " ");
		}
		System.out.println("\n");


	}
	

}
