package pkg.exoad.bad4text.services;
import pkg.exoad.bad4text.debug.B4T_Exception;

import java.io.IOException;
public final class PlatformService
{
	private PlatformService()
	{}

	public enum PlatformName
	{
		WINDOWS,
		LINUX,
		MACOS,
		UNKNOWN
	}

	public static PlatformName getPlatformName()
	{
		String osName = System.getProperty("os.name")
		                      .toLowerCase();
		if (osName.contains("win"))
			return PlatformName.WINDOWS;
		else
			if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix"))
				return PlatformName.LINUX;
			else
				if (osName.contains("mac"))
					return PlatformName.MACOS;
				else
					return PlatformName.UNKNOWN;
	}

	public static boolean isLinux()
	{
		return getPlatformName() == PlatformName.LINUX;
	}

	public static boolean isWindows()
	{
		return getPlatformName() == PlatformName.WINDOWS;
	}

	public static boolean isMacOS()
	{
		return getPlatformName() == PlatformName.MACOS;
	}

	public static ProcessBuilder makeProcessBuilder(String... command)
	{
		return new ProcessBuilder(command);
	}

	public static void executeSysCmd(String command)
	{
		try
		{
			Runtime.getRuntime()
			       .exec(command);
		} catch (IOException e)
		{
			B4T_Exception.throwNow(
					PlatformService.class,
					"Command execution failed for \"" + command + "\"",
					e
			);
		}
	}
}
