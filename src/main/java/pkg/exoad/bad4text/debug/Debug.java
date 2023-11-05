package pkg.exoad.bad4text.debug;

/**
 * Very stupid implementation of a debugging logger
 */
public final class Debug
{
	private Debug()
	{}

	public static void logMessage(String message)
	{
		System.out.println("[DEBUG__]: " + message);
	}

	public static void warnMessage(String message)
	{
		System.out.println("[WARNING]: " + message);
	}
}
