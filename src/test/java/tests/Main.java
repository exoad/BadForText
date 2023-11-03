package tests;

import pkg.exoad.bad4text.debug.B4T_Exception;
import pkg.exoad.bad4text.debug.Code;
public class Main
{
	public static void main(String[] args)
	{
		B4T_Exception.throwNow(
				Main.class,
				Code.referenceFx(
						"main",
						"String[] args"
				)
		);
	}
}
