package default_package;

public class Formula 
{

	public static boolean isValidFormula(String input) 
	{
		int index = 0;
		Debug.print("Analyzing the expression " + input);

		while(index < input.length())
		{
			char nextCharacter = input.charAt(index);
			Debug.print("\tAnalyzing \"" + nextCharacter + "\"");

			// if opening parentheses, recursive call with inner expression
			if(isOpeningBrace(nextCharacter))
			{
				int endIndex = indexOfClosingBrace(input, index, nextCharacter);
				
				if(endIndex != -1 && isValidFormula(input.substring(index + 1, endIndex)))
				{
					index = endIndex;
				}
				else
				{
					Debug.print("Mismatched braces found starting at index " + index);
					return false;
				}
			}

			// if number, begin check for validity
			else if(isNumerical(nextCharacter))
			{
				int endIndex = checkDigit(input, index);
				
				if(endIndex != -1)
				{
					index = endIndex;
				}
				else
				{
					Debug.print("Invalid number found starting at index " + index);
					return false;
				}
			}
			
			// if operation, check for double operations and other such nonsensical nonsense
			else if(isValidOperation(nextCharacter))
			{
				// if last character, invalid
				if(index == input.length() - 1)
				{
					Debug.print("Invalid operation at end of expression, located at index " + index);
					return false;
				}
				
				// if next character is another operation (minus could be a negative sign)
				if(isValidOperation(input.charAt(index + 1)) && input.charAt(index + 1) != '-')
				{
					Debug.print("Duplicate expressions found starting at index " + index);
					return false;
				}
			}
			
			// invalid character
			else
			{
				Debug.print("Invalid character " + nextCharacter);
				return false;
			}

			index++;
		}

		return true;
	}

	private static boolean isNumerical(char nextCharacter) 
	{
		return Character.isDigit(nextCharacter) || nextCharacter == '.';
	}

	private static boolean isOpeningBrace(char nextCharacter) {
		return nextCharacter == '(' || nextCharacter == '[';
	}

	private static boolean isValidOperation(char nextCharacter) 
	{
		return  nextCharacter == '+' ||
				nextCharacter == '-' ||
				nextCharacter == '/' ||
				nextCharacter == '*';
	}

	private static int checkDigit(String input, int index) 
	{
		boolean valid = true;
		boolean decimalEncountered = false;
		
		while(index < input.length())
		{
			char character = input.charAt(index);
			
			if(character == '.')
			{
				valid = false; // false until another number encountered
				
				if(decimalEncountered)
				{
					break;
				}
				else
				{
					decimalEncountered = true;
				}
			}
			
			else if(isNumerical(character))
			{
				valid = true;
			}
			
			else
			{
				// not a number, decrement index and break
				index--;
				break;
			}
			
			index++;
		}
		
		if( ! valid)
		{
			return -1;
		}
		
		return index;
	}

	private static int indexOfClosingBrace(String input, int index, char openingBrace) 
	{
		
		char closingBrace = getClosingBrace(openingBrace);
		
		int innerBraces = 0;
		int indexOfClosingBrace = -1;
		
		for(int i = index + 1; i < input.length(); i++)
		{
			char character = input.charAt(i);
			
			// if character is another opening brace, flag to skip its closing brace
			if(character == openingBrace)
			{
				innerBraces++;
			}
			
			if(character == closingBrace)
			{ 
				// if closing brace and have processed all inner open/close braces, return index of this closing brace
				if(innerBraces == 0)
				{
					return i;
				}
				// otherwise this is just a closing brace for the inner expression
				else
				{
					innerBraces--;
				}
			}
		}
		
		return indexOfClosingBrace; // -1 if not found
	}

	private static char getClosingBrace(char openingBrace) {
		
		if(openingBrace == '(')
		{
			return ')';
		}
		else
		{
			return ']';
		}
		
	}

}
