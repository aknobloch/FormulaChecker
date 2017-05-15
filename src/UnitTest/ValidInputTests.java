package UnitTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import default_package.Formula;

public class ValidInputTests {

	@Test
	public void basicCase()
	{
		String testCase = "1";
		boolean result = Formula.isValidFormula(testCase);
		assertTrue(result);
	}
	
	@Test
	public void easyCase()
	{
		String testCase = "4*7";
		boolean result = Formula.isValidFormula(testCase);
		assertTrue(result);
		
		testCase = "4/7";
		result = Formula.isValidFormula(testCase);
		assertTrue(result);
		
		testCase = "4+7";
		result = Formula.isValidFormula(testCase);
		assertTrue(result);
		
		testCase = "4-7";
		result = Formula.isValidFormula(testCase);
		assertTrue(result);
	}
	
	@Test
	public void negativeNumbersEasyCase()
	{
		String testCase = "4*-7";
		boolean result = Formula.isValidFormula(testCase);
		assertTrue(result);
		
		testCase = "-4+7";
		result = Formula.isValidFormula(testCase);
		assertTrue(result);
	}
	
	@Test
	public void easyDecimalCase()
	{
		String testCase = "4.5*7.0";
		boolean result = Formula.isValidFormula(testCase);
		assertTrue(result);
		
		testCase = "47.8/7";
		result = Formula.isValidFormula(testCase);
		assertTrue(result);
		
		testCase = "47.985+76.7";
		result = Formula.isValidFormula(testCase);
		assertTrue(result);
		
		testCase = "4-7.198";
		result = Formula.isValidFormula(testCase);
		assertTrue(result);
		
		testCase = ".4-.198";
		result = Formula.isValidFormula(testCase);
		assertTrue(result);
	}
	
	@Test
	public void parenthisesEasyCase()
	{
		String testCase = "(7*2)";
		boolean result = Formula.isValidFormula(testCase);
		assertTrue(result);
	}
	
	@Test
	public void parenthisesComplexCase()
	{
		String testCase = "(7*2)+(2-1)-3";
		boolean result = Formula.isValidFormula(testCase);
		assertTrue(result);
	}
	
	@Test
	public void parenthisesComplexDecimalCase()
	{
		String testCase = "(7.5*2)+(2.0-1)-3.558";
		boolean result = Formula.isValidFormula(testCase);
		assertTrue(result);
	}
	
	@Test
	public void bracketAndParenthesesEasyCase()
	{
		String testCase = "(7*2)+[2-1]-3";
		boolean result = Formula.isValidFormula(testCase);
		assertTrue(result);
	}
	
	@Test
	public void bracketAndParenthesesComplexCase()
	{
		String testCase = "(7*[2-3.0])+[(7-5)+2-1]-3";
		boolean result = Formula.isValidFormula(testCase);
		assertTrue(result);
	}
}
