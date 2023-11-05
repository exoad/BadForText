package pkg.exoad.bad4text.core;
import java.io.*;
import java.util.StringTokenizer;
public class InStream
{
	private BufferedReader reader;
	private StringTokenizer stringTokenizer;
	private String currentToken;

	public InStream(InputStream defaultStream)
	{
		reader = new BufferedReader(new InputStreamReader(defaultStream));
	}

	public synchronized void setInputStream(InputStream newStream)
	{
		reader = new BufferedReader(new InputStreamReader(newStream));
	}

	public boolean hasNextToken()
	{
		return peekNextToken() != null;
	}

	public int tryReadInt(int defaultValue)
	{
		try
		{
			return Integer.parseInt(nextToken());
		} catch (NumberFormatException e)
		{
			return defaultValue;
		}
	}

	public float tryReadFLoat(float defaultValue)
	{
		try
		{
			return Float.parseFloat(nextToken());
		} catch (NumberFormatException e)
		{
			return defaultValue;
		}
	}

	public long tryReadLong(long defaultValue)
	{
		try
		{
			return Long.parseLong(nextToken());
		} catch (NumberFormatException e)
		{
			return defaultValue;
		}
	}

	public String readLine(String defaultValue)
	{
		try
		{
			return reader.readLine();
		} catch (IOException e)
		{
			return defaultValue;
		}
	}

	public String tryReadWord(String defaultValue)
	{
		try
		{
			return nextToken();
		} catch (Exception e)
		{
			return defaultValue;
		}
	}

	public String peekNextToken()
	{
		if (currentToken == null)
		{
			try
			{
				while (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
				{
					String currentLine = reader.readLine();
					if (currentLine == null)
						return null;
					stringTokenizer = new StringTokenizer(currentLine);
				}
				currentToken = stringTokenizer.nextToken();
			} catch (IOException ignored)
			{
			}
		}
		return currentToken;
	}

	public String nextToken()
	{
		String ans = peekNextToken();
		currentToken = null;
		return ans;
	}

}
