package tests;

import pkg.exoad.bad4text.B4T;

public class Main
{
	public static void main(String[] args)
	{
		B4T.armEngine(true);
		B4T.IO.print("Test Character Output");
		B4T.IO.clearConsole();
		B4T.IO.print("Output end");
		B4T.IO.printNewLine();

		B4T.IO.print("Enter a number");
	}
}
