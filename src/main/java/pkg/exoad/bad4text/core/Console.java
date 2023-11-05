package pkg.exoad.bad4text.core;
import pkg.exoad.bad4text.B4T;
import pkg.exoad.bad4text.debug.B4T_Exception;
import pkg.exoad.bad4text.services.PlatformService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This is the barebones implementation of detecting input events
 * from the user through the console.
 *
 * @author Jack Meng
 */
public class Console
{
	private final InStream input;
	private final OutStream output;

	public Console()
	{
		this(
				System.in,
				System.out
		);
	}

	public Console(InputStream iStream, OutputStream oStream)
	{
		input = new InStream(iStream);
		output = new OutStream(oStream);
	}

	public void setOutput(OutputStream newStream)
	{
		output.setOutputStream(newStream);
	}

	public void resetOutput()
	{
		output.resetOutputStream();
	}

	public void clearConsole()
	{
		if (Boolean.TRUE.equals(B4T.getProperty("io.useansi")))
			print("\033[H\033[2J");
		else
		{
			if (PlatformService.isWindows())
			{
				try
				{
					PlatformService.makeProcessBuilder(
							               "cls",
							               "/c",
							               "cls"
					               )
					               .inheritIO()
					               .start()
					               .waitFor();
				} catch (InterruptedException e)
				{
					throw new RuntimeException(e);
				} catch (IOException e)
				{
					B4T_Exception.throwNow(
							this.getClass(),
							"Console::clearConsole (isWindows_check)",
							e
					);
				}
			}
			else
				if (PlatformService.isMacOS() || PlatformService.isLinux())
					PlatformService.executeSysCmd("clear");
				else
					print("\n".repeat((int) B4T.getProperty("io.dumb_console_clear_nls")));
		}
	}

	public void print(char... content)
	{
		output.print(content);
	}

	public void print(String content)
	{
		output.print(content.toCharArray());
	}
}
