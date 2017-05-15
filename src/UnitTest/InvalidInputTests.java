package UnitTest;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import default_package.Formula;

public class InvalidInputTests {

	@Test
	public void badOperations()
	{
		String testCase = "4*7/";
		boolean result = Formula.isValidFormula(testCase);
		assertFalse(result);
		
		testCase = "4*+7";
		result = Formula.isValidFormula(testCase);
		assertFalse(result);
	}
	
	@Test
	public void badParentheses()
	{
		String testCase = "(7-5)(";
		boolean result = Formula.isValidFormula(testCase);
		assertFalse(result);
		
		testCase = "4*(7";
		result = Formula.isValidFormula(testCase);
		assertFalse(result);
		
		testCase = "4)*(7";
		result = Formula.isValidFormula(testCase);
		assertFalse(result);
		
		testCase = "(7*(3-5)";
		result = Formula.isValidFormula(testCase);
		assertFalse(result);
	}
	
	@Test
	public void mismatchedParenthesesComplex()
	{
		String testCase = "4*(7/[2-5)]";
		boolean result = Formula.isValidFormula(testCase);
		assertFalse(result);
	}
	
	@Test
	public void badDecimalPlaces()
	{
		String testCase = "2-3.55.8";
		boolean result = Formula.isValidFormula(testCase);
		assertFalse(result);
		
		testCase = "2-355.";
		result = Formula.isValidFormula(testCase);
		assertFalse(result);
		
		testCase = "2.0-3..55";
		result = Formula.isValidFormula(testCase);
		assertFalse(result);
		
		testCase = "2.-3.55";
		result = Formula.isValidFormula(testCase);
		assertFalse(result);
	}
}
