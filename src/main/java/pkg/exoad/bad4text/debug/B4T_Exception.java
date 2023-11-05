package pkg.exoad.bad4text.debug;
public class B4T_Exception
		extends RuntimeException
{
	public static void noImplementation()
	{
		throw new B4T_Exception(
				"Functionality not implemented"
		);
	}

	public B4T_Exception(Class< ? > causeSource, String message)
	{
		super("\n\t\t[" + causeSource.getCanonicalName() + "]:\n\t\t\t" + message);
	}

	public B4T_Exception(Class< ? > causeSource, String message, Throwable cause)
	{
		super(
				"\n\t\t[" + causeSource.getCanonicalName() + "]:\n\t\t\t" + message,
				cause
		);
	}

	public B4T_Exception(Class< ? > causeSource, Throwable cause)
	{
		super(
				"\n\t\t[" + causeSource.getCanonicalName() + "]:\n\t\t\t" + cause.getMessage(),
				cause
		);
	}

	public B4T_Exception(String message)
	{
		super(message);
	}

	public static void throwIf(boolean condition, Class< ? > causeSource, String message)
	{
		if (condition)
			throw new B4T_Exception(
					causeSource,
					message
			);
	}

	public static void throwNow(Class< ? > causeSource, String message)
	{
		throw new B4T_Exception(
				causeSource,
				message
		);
	}

	public static void throwIf(boolean condition, Class< ? > causeSource, String message, Throwable cause)
	{
		if (condition)
			throw new B4T_Exception(
					causeSource,
					message,
					cause
			);
	}

	public static void throwNow(Class< ? > causeSource, String message, Throwable cause)
	{
		throw new B4T_Exception(
				causeSource,
				message,
				cause
		);
	}
}
