package pkg.exoad.bad4text.debug;

import java.util.Stack;

import pkg.exoad.bad4text.B4T;

/**
 * 非常愚蠢的调试日志记录器实现
 */
public final class Debug
{
	private Debug()
	{
	}

	private static Stack< String > unusedLogMessages = new Stack<>();

	public static void logMessage(String message)
	{
		if (B4T.isPropertyTrue("b4t.internal_logging"))
		    System.out.println("[DEBUG__]: " + message);
		else if (B4T.isPropertyTrue("b4t.store_unused_logging"))
		    unusedLogMessages.push("[DEBUG__]: " + message);
	}

	public static void warnMessage(String message)
	{
		if (B4T.isPropertyTrue("b4t.internal_logging"))
		    System.out.println("[WARNING]: " + message);
		else if (B4T.isPropertyTrue("b4t.store_unused_logging"))
		    unusedLogMessages.push("[WARNING]: " + message);
	}

	public static void warnIf(boolean condition, String message)
	{
		if (condition)
		    warnMessage(message);
	}
}
