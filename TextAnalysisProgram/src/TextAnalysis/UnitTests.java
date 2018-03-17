package TextAnalysis;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.SingleTestExecutor.Executable;

class UnitTests {

	public static final String longString = "1164778 Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, and where is the use of a book, thought Alice, without pictures or conversations? So she was considering in her own mind, (as well as she could, for the hot day made her feel very sleepy and stupid,) whether the pleasure of making a daisy-chain was worth the trouble of getting up and picking the daisies, when a white rabbit with pink eyes ran close by her.";
	public static final String shortString = "99037666 This! What is this? Why, this is a (short) string.";
	public static final String varietyString = "abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {}abc def ghi";
		
	@Test
	public void characterCount_ShouldReturnCorrectCharacterCountForOneLetter_LongString() {
		// arrange
		int expectedResult = 14; 
		char character = 'W';
		TextAnalysis testCase = new TextAnalysis(longString);
		// act
		int result = testCase.countCharacters(testCase.inputAsArray, character);
		// assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void characterCount_ShouldReturnCorrectCharacterCountForOneLetter_ShortString() {
		//arrange
		int expectedResult = 0;
		char character = 'B';
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		int result = testCase.countCharacters(testCase.inputAsArray, character);
		//assert
		Assert.assertEquals(expectedResult, result);
		
	}

	@Test
	public void characterCount_ShouldReturnCorrectCharacterCountForOneCharacter_LongString() {
		//arrange
		int expectedResult = 9;
		char character = ',';
		TextAnalysis testCase = new TextAnalysis(longString);
		//act
		int result = testCase.countCharacters(testCase.inputAsArray, character);
		//assert
		Assert.assertEquals(expectedResult, result);
		
	}
	
	@Test
	public void characterCount_ShouldReturnCorrectCharacterCountForOneCharacter_ShortString() {
		//arrange
		int expectedResult = 0;
		char character = '-';
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		int result = testCase.countCharacters(testCase.inputAsArray, character);
		//assert
		Assert.assertEquals(expectedResult, result);
		
	}
	
	@Test
	public void characterCount_ShouldReturnCorrectCharacterCountForOneNumber_LongString() {
		//arrange
		int expectedResult = 2;
		char character = '7';
		TextAnalysis testCase = new TextAnalysis(longString);
		//act
		int result = testCase.countCharacters(testCase.inputAsArray, character);
		//assert
		Assert.assertEquals(expectedResult, result);		
	}
	
	@Test
	public void characterCount_ShouldReturnCorrectCharacterCountForOneNumber_ShortString() {
		//arrange
		int expectedResult = 3;
		char character = '6';
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		int result = testCase.countCharacters(testCase.inputAsArray, character);
		//assert
		Assert.assertEquals(expectedResult, result);		
	}
	
	@Test
	public void characterCount_ShouldReturnCorrectCharacterCountForOneCharacter_EmptyString() {
		//arrange
		int expectedResult = 0;
		char character = '"';
		TextAnalysis testCase = new TextAnalysis("");
		//act
		int result = testCase.countCharacters(testCase.inputAsArray, character);
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void characterFrequencies_ShouldReturnCorrectArrayForShortString() {
		//arrange
		int[] expectedArray = {2,0,0,0,0,0,1,6,6,0,0,0,0,1,1,0,0,2,7,6,0,0,2,0,1,0,1,0,0,1,0,0,3,1,0,2,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0};
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		int[] resultArray = testCase.getCharacterFrequency();
		//assert		
		Assert.assertEquals(HelperMethods.compareTwoArrays(expectedArray, resultArray), true);
	}
	
	@Test
	public void characterFrequencies_ShouldReturnCorrectArrayForLongString() {
		//arrange
		int[] expectedArray = {31,10,13,18,56,7,13,31,40,0,6,10,3,34,35,10,0,27,32,39,11,5,14,0,8,0,0,2,0,0,1,0,1,2,1,0,1,9,0,1,1,0,0,0,0,1,1,1,0,0,0};
		TextAnalysis testCase = new TextAnalysis(longString);
		//act
		int[] resultArray = testCase.getCharacterFrequency();
		//assert		
		Assert.assertEquals(HelperMethods.compareTwoArrays(expectedArray, resultArray), true);		
	}
	
	@Test
	public void characterFrequencies_ShouldReturnCorrectArrayForEmptyString() {
		//arrange
		int[] expectedArray = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		TextAnalysis testCase = new TextAnalysis("");
		//act
		int[] resultArray = testCase.getCharacterFrequency();
		//assert
		Assert.assertEquals(HelperMethods.compareTwoArrays(expectedArray, resultArray), true);	
	}
	
	@Test
	public void numberOfSpaces_ShouldReturnCorrectNumberOfSpacesForShortString() {
		//arrange
		int expectedResult = 10;
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		int result = testCase.getNumberOfSpaces();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void numberOfSpaces_ShouldReturnCorrectNumberOfSpacesForLongString() {
		//arrange
		int expectedResult = 110;
		TextAnalysis testCase = new TextAnalysis(longString);
		//act
		int result = testCase.getNumberOfSpaces();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void numberOfSpaces_ShouldReturnZeroForAnEmptyString() {
		//arrange
		int expectedResult = 0;
		TextAnalysis testCase = new TextAnalysis("");
		//act
		int result = testCase.getNumberOfSpaces();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void numberOfWords_ShouldReturnCorrectNumberOfWordsForShortString() {
		//arrange
		int expectedResult = 11;
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		int result = testCase.getNumberOfWords();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void numberOfWords_ShouldReturnCorrectNumberOfWordsForLongString() {
		//arrange
		int expectedResult = 111;
		TextAnalysis testCase = new TextAnalysis(longString);
		//act
		int result = testCase.getNumberOfWords();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void numberOfWords_ShouldReturnZeroForAnEmptyString() {
		//arrange
		int expectedResult = 0;
		TextAnalysis testCase = new TextAnalysis("");
		//act
		int result = testCase.getNumberOfWords();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void relativeFrequency_ShouldReturnCorrectArrayForShortString() {
		//arrange
		String[] expectedArray = {"0.041","0","0","0","0","0","0.021","0.123","0.123","0","0","0","0","0.021","0.021","0","0","0.041","0.143","0.123","0","0","0.041","0","0.021","0","0.021","0","0","0.021","0","0","0.062","0.021","0","0.041","0.021","0.021","0.021","0.021","0","0","0","0","0","0.021","0.021","0","0","0","0"};
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		String[] resultArray = testCase.getRelativeFrequency();
		//assert		
		Assert.assertEquals(HelperMethods.compareTwoArrays(expectedArray, resultArray), true);
		
	}
	
	@Test
	public void relativeFrequency_ShouldReturnCorrectArrayForLongString() {
		//arrange
		String[] expectedArray = {"0.066","0.022","0.028","0.038","0.118","0.015","0.028","0.066","0.085","0","0.013","0.022","0.007","0.072","0.074","0.022","0","0.057","0.068","0.083","0.024","0.011","0.03","0","0.017","0","0","0.005","0","0","0.003","0","0.003","0.005","0.003","0","0.003","0.019","0","0.003","0.003","0","0","0","0","0.003","0.003","0.003","0","0","0"};
		TextAnalysis testCase = new TextAnalysis(longString);		
		//act
		String[] resultArray = testCase.getRelativeFrequency();
		//assert		
		Assert.assertEquals(HelperMethods.compareTwoArrays(expectedArray, resultArray), true);		
	}
	
	@Test
	public void relativeFrequency_ShouldReturnCorrectArrayForEmptyString() {
		//arrange
		String[] expectedArray = {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
		TextAnalysis testCase = new TextAnalysis("");
		//act
		String[] resultArray = testCase.getRelativeFrequency();
		//assert
		Assert.assertEquals(HelperMethods.compareTwoArrays(expectedArray, resultArray), true);	
	}
	
	@Test
	public void highestCount_ShouldReturnHighestValueInFrequencyArrayForShortString() {
		//arrange
		int expectedResult = 7;
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		int result = testCase.getHighestCount();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void highestCount_ShouldReturnHighestValueInFrequencyArrayForLongString() {
		//arrange
		int expectedResult = 56;
		TextAnalysis testCase = new TextAnalysis(longString);
		//act
		int result = testCase.getHighestCount();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void highestCount_ShouldReturnZeroForEmptyString() {
		//arrange
		int expectedResult = 0;
		TextAnalysis testCase = new TextAnalysis("");
		//act
		int result = testCase.getHighestCount();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charsIncludingSpaces_ShouldReturnTotalLengthOfShortString() {
		//arrange
		int expectedResult = 59;
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		int result = testCase.getCharsIncludingSpaces();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charsIncludingSpaces_ShouldReturnTotalLengthOfLongString() {
		//arrange
		int expectedResult = 585;
		TextAnalysis testCase = new TextAnalysis(longString);
		//act
		int result = testCase.getCharsIncludingSpaces();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charsIncludingSpaces_ShouldReturnZeroForEmptyString() {
		//arrange
		int expectedResult = 0;
		TextAnalysis testCase = new TextAnalysis("");
		//act
		int result = testCase.getCharsIncludingSpaces();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charsExcludingSpaces_ShouldReturnTotalLengthOfShortString() {
		//arrange
		int expectedResult = 49;
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		int result = testCase.getCharsExcludingSpaces();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charsExcludingSpaces_ShouldReturnTotalLengthOfLongString() {
		//arrange
		int expectedResult = 475;
		TextAnalysis testCase = new TextAnalysis(longString);
		//act
		int result = testCase.getCharsExcludingSpaces();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void charsExcludingSpaces_ShouldReturnZeroForEmptyString() {
		//arrange
		int expectedResult = 0;
		TextAnalysis testCase = new TextAnalysis("");
		//act
		int result = testCase.getCharsExcludingSpaces();
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void numberOfRecognisedCharacters_ShouldReturnTotalOfCharacterFrequencyArrayForVarietyString() {
		//arrange
		int expectedResult = 71;
		TextAnalysis testCase = new TextAnalysis(varietyString);
		//act
		int result = testCase.getNumberOfRecognisedCharacters();		
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void numberOfRecognisedCharacters_ShouldReturnZeroForEmptyString() {
		//arrange
		int expectedResult = 0;
		TextAnalysis testCase = new TextAnalysis("");
		//act
		int result = testCase.getNumberOfRecognisedCharacters();		
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void numberOfUnrecognisedCharacters() {
		//arrange
		int expectedResult = 22;
		TextAnalysis testCase = new TextAnalysis(varietyString);
		//act
		int result = testCase.getNumberOfUnrecognisedCharacters();		
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void numberOfUnrecognisedCharacters_ShouldReturnZeroForEmptyString() {
		//arrange
		int expectedResult = 0;
		TextAnalysis testCase = new TextAnalysis("");
		//act
		int result = testCase.getNumberOfRecognisedCharacters();		
		//assert
		Assert.assertEquals(expectedResult, result);
	}
	
//	@Test
//	public void convertTextFile_ShouldThrowException() {
//		//arrange
//		String filename = "testfile.txt";
//		Executable convertTextFileTest = () -> {HelperMethods.convertTextFile(filename);};
//		//act
//		assertThrows(FileNotFoundException.class, convertTextFileTest);
//	}
	
}
