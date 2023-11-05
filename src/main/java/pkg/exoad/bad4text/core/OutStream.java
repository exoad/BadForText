package pkg.exoad.bad4text.core;

import pkg.exoad.bad4text.debug.B4T_Exception;
import pkg.exoad.bad4text.debug.Code;

import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;

public class OutStream
		implements
		Flushable
{
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

	public void print(char... content)
	{
		try
		{
			byte[] bytes = new byte[content.length];
			for (int i = 0; i < content.length; i++)
				bytes[i] = (byte) content[i];
			os.write(bytes);
			os.flush();
		} catch (IOException e)
		{
			B4T_Exception.throwNow(
					this.getClass(),
					Code.referenceFx(
							"print",
							"char[] content"
					),
					e
			);
		}
	}

	@Override public void flush() throws
	                              IOException
	{
		os.flush();
	}
}
