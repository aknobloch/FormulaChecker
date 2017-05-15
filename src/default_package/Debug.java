package default_package;

public class Debug 
{
	static final boolean debugMode = false;
	
	public static void print(String message)
	{
		if(debugMode)
		{
			System.out.println(message);	
		}
	}
}
