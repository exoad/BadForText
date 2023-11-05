package pkg.exoad.bad4text.debug;

/**
 * 非常愚蠢的调试日志记录器实现
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
