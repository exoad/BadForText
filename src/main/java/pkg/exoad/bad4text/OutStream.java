package pkg.exoad.bad4text;

import java.io.IOException;
import java.io.OutputStream;

public class OutStream
{
	public static final class TUI_OutStreamException
			extends RuntimeException
	{
		public TUI_OutStreamException(String msg)
		{
			super(msg);
		}

		public TUI_OutStreamException(String msg, Throwable cause)
		{
			super(
					msg,
					cause);
		}
	}

	private OutputStream os;

	public OutStream(OutputStream defaultStream)
	{
		this.os = defaultStream;
	}

	public synchronized void setOutputStream(OutputStream newStream)
	{
		this.os = newStream;
	}

	public synchronized void resetOutputStream()
	{
		if (!os.equals(System.out))
			this.os = System.out;
	}

	public void print(char content)
	{
		try
		{
			os.write(content);
		} catch (IOException e)
		{
			throw new TUI_OutStreamException(
					"fx::print() Failed",
					e);
		}
	}
}
