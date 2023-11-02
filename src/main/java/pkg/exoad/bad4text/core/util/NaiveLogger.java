package pkg.exoad.bad4text.core.util;
import pkg.exoad.bad4text.OutStream;
public class NaiveLogger
{
	private static NaiveLogger instance;

	public static NaiveLogger getInstance()
	{
		if(instance == null)
			instance = new NaiveLogger();
		return instance;
	}

	private OutStream outStream;

	private NaiveLogger()
	{
		this.outStream = new OutStream(System.err);
	}
}
